package wlt.fox.zhizhihuhu.ui.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import wlt.fox.zhizhihuhu.ui.base.BasePresentter;
import wlt.fox.zhizhihuhu.ui.viewinterface.DailyFGViewInterface;

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
            //dailyApi
        }
    }
}
