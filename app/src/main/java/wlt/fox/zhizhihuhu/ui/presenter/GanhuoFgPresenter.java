package wlt.fox.zhizhihuhu.ui.presenter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.bean.ganhuo.MeiZi;
import wlt.fox.zhizhihuhu.bean.ganhuo.Video;
import wlt.fox.zhizhihuhu.ui.adapter.GanhuoListAdapter;
import wlt.fox.zhizhihuhu.ui.base.BasePresentter;
import wlt.fox.zhizhihuhu.ui.viewinterface.GanHuoFGViewInterface;
import wlt.fox.zhizhihuhu.util.LogUtils;

/**
 * Created by wlt on 2016/9/19.
 * E-mail : autumnsassou@163.com
 */
public class GanhuoFgPresenter extends BasePresentter<GanHuoFGViewInterface> {


    private Context mContext;
    private GanHuoFGViewInterface ganhuoFgView;
    private RecyclerView mRecyclerView;
    private GridLayoutManager layoutManager;

    private int page = 1;
    
    public GanhuoFgPresenter(Context context) {
        mContext = context;
    }

    public void getGankData() {
        ganhuoFgView = getView();
        if(ganhuoFgView != null) {
            mRecyclerView = ganhuoFgView.getRecyclerView();
            layoutManager = ganhuoFgView.getLayoutManager();
        }

        Observable.zip(
                gankApi.getMeiziData(page),
                gankApi.getVideoData(page),
                new Func2<MeiZi, Video, MeiZi>() {
                    @Override
                    public MeiZi call(MeiZi meiZi, Video video) {
                        List<MeiZi.Results> results = meiZi.getResults();
                        for (MeiZi.Results gankmeizhi : results) {
                            int position = results.indexOf(gankmeizhi);
                            gankmeizhi.setDesc( gankmeizhi.getDesc() + " " +
                                    video.getResults().get(position).getDesc());
                            gankmeizhi.setContentUrl(video.getResults().get(position).getUrl());
                        }
                        return meiZi;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<MeiZi>() {
                    @Override
                    public void call(MeiZi meiZi) {
                        displayMeizi(mContext, meiZi.getResults(), ganhuoFgView, mRecyclerView);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                        Toast.makeText(mContext, R.string.net_wrong, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    List<MeiZi.Results> list;
    private GanhuoListAdapter adapter;
    private void displayMeizi(Context mContext, List<MeiZi.Results> results,
                              GanHuoFGViewInterface ganhuoFgView, RecyclerView mRecyclerView) {
        if(false) {

        } else {
            list = results;
            adapter = new GanhuoListAdapter(mContext, list);
            mRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        ganhuoFgView.setDataRefresh(false);

    }


}
