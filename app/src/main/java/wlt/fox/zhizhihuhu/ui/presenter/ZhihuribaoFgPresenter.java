package wlt.fox.zhizhihuhu.ui.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    public ZhihuribaoFgPresenter(Context context) {
        mContext = context;
    }

    public void getLatestNews() {
        zhiHuRBView = getView();
        if(zhiHuRBView != null) {
            mRecyclerView = zhiHuRBView.getRecyclerView();
            layoutManager = zhiHuRBView.getLayoutManager();
        }
    }
}
