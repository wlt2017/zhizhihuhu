package wlt.fox.zhizhihuhu.ui.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import wlt.fox.zhizhihuhu.bean.zhihu.LatestNews;
import wlt.fox.zhizhihuhu.ui.adapter.ZhihuListAdapter;
import wlt.fox.zhizhihuhu.ui.base.BasePresentter;
import wlt.fox.zhizhihuhu.ui.viewinterface.ZhiHuRBViewInterface;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public class ZhihuribaoFgPresenter extends BasePresentter<ZhiHuRBViewInterface> {

    private Context mContext;

    private ZhiHuRBViewInterface zhiHuRBView;

    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;

    private LatestNews mLatestNews;
    //是否加载过更多
    private boolean isLoadMore = false;


    public ZhihuribaoFgPresenter(Context context) {
        mContext = context;
    }

    public void getLatestNews() {
        zhiHuRBView = getView();
        if(zhiHuRBView != null) {
            mRecyclerView = zhiHuRBView.getRecyclerView();
            layoutManager = zhiHuRBView.getLayoutManager();
            zhihuApi.getLatestNews()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<LatestNews>() {
                        @Override
                        public void call(LatestNews latestNews) {
                            displayZhihuList(latestNews, mContext,
                                    zhiHuRBView, mRecyclerView);
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    });

        }
    }

    private ZhihuListAdapter adapter;
    String time;
    private void displayZhihuList(LatestNews latestNews, Context mContext,
                                  ZhiHuRBViewInterface zhiHuRBView, RecyclerView mRecyclerView) {
        if(isLoadMore) {

        } else {
            mLatestNews = latestNews;
            adapter = new ZhihuListAdapter(mContext, mLatestNews);
            mRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        zhiHuRBView.setRefresh(false);
        time = latestNews.getDate();
    }
}
