package wlt.fox.zhizhihuhu.ui.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.bean.daily.DailyBean;
import wlt.fox.zhizhihuhu.ui.adapter.DailyListAdapter;
import wlt.fox.zhizhihuhu.ui.base.BasePresentter;
import wlt.fox.zhizhihuhu.ui.viewinterface.DailyFGViewInterface;
import wlt.fox.zhizhihuhu.util.LogUtils;

/**
 * Created by wlt on 2016/9/19.
 * E-mail : autumnsassou@163.com
 */
public class DailyFgPresenter extends BasePresentter<DailyFGViewInterface> {

    private Context mContext;
    private DailyFGViewInterface dailyFgView;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;

    public DailyFgPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void getDailyTimeLine(String num) {
        dailyFgView = getView();
        if(dailyFgView != null) {
            mRecyclerView = dailyFgView.getRecyclerView();
            layoutManager = dailyFgView.getLayoutManager();
            dailyApi.getDailyTimeLine(num)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<DailyBean>() {
                        @Override
                        public void call(DailyBean dailyBean) {
                            LogUtils.d("wan",dailyBean.toString());
                            displayDaily(mContext, dailyBean, mRecyclerView, dailyFgView);
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            throwable.printStackTrace();
                            Toast.makeText(mContext, R.string.net_wrong, Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private DailyBean mDailyBean;
    private DailyListAdapter adapter;
    private void displayDaily(Context mContext, DailyBean dailyBean,
                              RecyclerView mRecyclerView, DailyFGViewInterface dailyFgView) {
        LogUtils.d("wan", "displayDaily()");
        //加载更多，稍后完善
        if(false) {

        } else {
            mDailyBean = dailyBean;
            adapter = new DailyListAdapter(mContext, dailyBean.getResponse());
            mRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        dailyFgView.setDataRefresh(false);
    }

    public void reView() {
        adapter.notifyDataSetChanged();
    }

}
