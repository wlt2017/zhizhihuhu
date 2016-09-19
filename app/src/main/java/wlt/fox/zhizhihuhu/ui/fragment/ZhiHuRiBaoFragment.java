package wlt.fox.zhizhihuhu.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.ui.base.MVPBaseFragment;
import wlt.fox.zhizhihuhu.ui.presenter.ZhihuribaoFgPresenter;
import wlt.fox.zhizhihuhu.ui.viewinterface.ZhiHuRBViewInterface;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public class ZhiHuRiBaoFragment
        extends MVPBaseFragment <ZhiHuRBViewInterface,ZhihuribaoFgPresenter>
        implements ZhiHuRBViewInterface {

    private final static String TAG = "ZhiHuRiBaoFragment";

    private LinearLayoutManager mLayoutManager;

    //正在刷新
    private boolean mIsRequestDataRefresh = false;

    @BindView(R.id.content_recycler_view)
    RecyclerView content_recycler_view;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipe_refresh_layout;

    @Override
    protected ZhihuribaoFgPresenter createPresenter() {
        return new ZhihuribaoFgPresenter(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_zhihuribao,container,false);
        ButterKnife.bind(this, rootView);
        setUpSwipeRefresh();
        mLayoutManager = new LinearLayoutManager(getContext());
        content_recycler_view.setLayoutManager(mLayoutManager);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRefresh(true);
        mPresenter.getLatestNews();

    }

    private void setUpSwipeRefresh() {
        swipe_refresh_layout.setColorSchemeColors(
                R.color.refresh_progress_1,
                R.color.refresh_progress_2,
                R.color.refresh_progress_3);
        swipe_refresh_layout.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        swipe_refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mIsRequestDataRefresh = true;
                setRefresh(true);
                mPresenter.getLatestNews();
            }
        });
    }

    @Override
    public void setRefresh(boolean requestDataRefresh) {
        if( !requestDataRefresh ) {
            mIsRequestDataRefresh = false;
            swipe_refresh_layout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    swipe_refresh_layout.setRefreshing(false);
                }
            }, 1000);
        } else {
            swipe_refresh_layout.setRefreshing(true);
        }
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
