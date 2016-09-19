package wlt.fox.zhizhihuhu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.ui.base.MVPBaseFragment;
import wlt.fox.zhizhihuhu.ui.presenter.DailyFgPresenter;
import wlt.fox.zhizhihuhu.ui.viewinterface.DailyFGViewInterface;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public class DailyFragment
        extends MVPBaseFragment<DailyFGViewInterface, DailyFgPresenter>
        implements DailyFGViewInterface {

    private LinearLayoutManager mLayoutManager;
    @BindView(R.id.content_list)
    RecyclerView content_list;

    @Override
    protected DailyFgPresenter createPresenter() {
        return new DailyFgPresenter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_daily,container,false);
        ButterKnife.bind(this, rootView);
        mLayoutManager = new LinearLayoutManager(getContext());
        content_list.setLayoutManager(mLayoutManager);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getDailyTimeLine("0");
    }

    @Override
    public RecyclerView getRecyclerView() {
        return content_list;
    }

    @Override
    public LinearLayoutManager getLayoutManager() {
        return mLayoutManager;
    }
}
