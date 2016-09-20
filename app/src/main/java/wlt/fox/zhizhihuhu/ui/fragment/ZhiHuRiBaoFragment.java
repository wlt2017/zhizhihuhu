package wlt.fox.zhizhihuhu.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.ui.base.MVPBaseFragment;
import wlt.fox.zhizhihuhu.ui.presenter.ZhihuFgPresenter;
import wlt.fox.zhizhihuhu.ui.viewinterface.ZhiHuFGViewInterface;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public class ZhiHuRiBaoFragment
        extends MVPBaseFragment <ZhiHuFGViewInterface,ZhihuFgPresenter>
        implements ZhiHuFGViewInterface {

    private final static String TAG = "ZhiHuRiBaoFragment";

    private LinearLayoutManager mLayoutManager;

    //正在刷新
    private boolean mIsRequestDataRefresh = false;

    @BindView(R.id.content_recycler_view)
    RecyclerView content_recycler_view;

    @Override
    protected void initView(View rootView) {
        mLayoutManager = new LinearLayoutManager(getContext());
        content_recycler_view.setLayoutManager(mLayoutManager);
    }

    @Override
    protected ZhihuFgPresenter createPresenter() {
        return new ZhihuFgPresenter(getContext());
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_zhihuribao;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setDataRefresh(true);
        mPresenter.getLatestNews();
    }

    //用户下拉刷新回调
    @Override
    public void requestDataRefresh() {
        super.requestDataRefresh();
        mPresenter.getLatestNews();
    }

    //刷新，或者关闭刷新
    @Override
    public void setDataRefresh(Boolean refresh) {
        setRefresh(refresh);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return content_recycler_view;
    }

    @Override
    public LinearLayoutManager getLayoutManager() {
        return mLayoutManager;
    }
}
