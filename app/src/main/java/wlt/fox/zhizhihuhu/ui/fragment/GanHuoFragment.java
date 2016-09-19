package wlt.fox.zhizhihuhu.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gank,container,false);
        ButterKnife.bind(this, rootView);
        mGridLayoutManager = new GridLayoutManager(getContext(), 2);
        content_list.setLayoutManager(mGridLayoutManager);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getGankData();
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
