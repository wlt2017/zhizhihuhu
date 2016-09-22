package wlt.fox.zhizhihuhu.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.ui.base.MVPBaseFragment;
import wlt.fox.zhizhihuhu.ui.presenter.GanhuoFgPresenter;
import wlt.fox.zhizhihuhu.ui.viewinterface.GanHuoFGViewInterface;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public class GanHuoFragment
        extends MVPBaseFragment<GanHuoFGViewInterface, GanhuoFgPresenter>
        implements GanHuoFGViewInterface {

    private GridLayoutManager mGridLayoutManager;

    @BindView(R.id.content_list)
    RecyclerView content_list;

    @Override
    protected GanhuoFgPresenter createPresenter() {
        return new GanhuoFgPresenter(getContext());
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_gank;
    }


    @Override
    protected void initView(View rootView) {
        mGridLayoutManager = new GridLayoutManager(getContext(), 2);
        content_list.setLayoutManager(mGridLayoutManager);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setDataRefresh(true);
        mPresenter.init();
        mPresenter.getGankData();
    }

    @Override
    public void requestDataRefresh() {
        super.requestDataRefresh();
        mPresenter.getGankData();
    }

    @Override
    protected void rePaintView() {
        mPresenter.reView();
    }

    @Override
    public void setDataRefresh(Boolean refresh) {
        setRefresh(refresh);
    }

    @Override
    public GridLayoutManager getLayoutManager() {
        return mGridLayoutManager;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return content_list;
    }
}
