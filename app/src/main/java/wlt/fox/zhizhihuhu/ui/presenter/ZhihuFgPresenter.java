package wlt.fox.zhizhihuhu.ui.presenter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import wlt.fox.zhizhihuhu.bean.zhihu.LatestNews;
import wlt.fox.zhizhihuhu.ui.adapter.ZhihuListAdapter;
import wlt.fox.zhizhihuhu.ui.base.BasePresentter;
import wlt.fox.zhizhihuhu.ui.viewinterface.ZhiHuFGViewInterface;
import wlt.fox.zhizhihuhu.util.LogUtils;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public class ZhihuFgPresenter extends BasePresentter<ZhiHuFGViewInterface> {

    private Context mContext;

    private ZhiHuFGViewInterface zhiHuRBView;

    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;

    private LatestNews mLatestNews;
    //是否加载过更多
    private boolean isLoadMore = false;

    /**
     * 最后一个可见的item的position
     */
    private int lastVisibleItemPosition;

    public ZhihuFgPresenter(Context context) {
        mContext = context;
    }

    public void init() {
        zhiHuRBView = getView();
        mRecyclerView = zhiHuRBView.getRecyclerView();
        layoutManager = zhiHuRBView.getLayoutManager();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //当停止滑动时，newState为0，即RecyclerView.SCROLL_STATE_IDLE
                if(newState == RecyclerView.SCROLL_STATE_IDLE) {
                    lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                    //滑动到加载更多item时
                    if(lastVisibleItemPosition + 1 == layoutManager.getItemCount()) {
                        isLoadMore = true;
                        //一秒后刷新
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                getBeforeNews(time);
                            }
                        },1000);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LogUtils.d("dx=" + dx +  "  dy=" + dy);
            }
        });
    }

    //加载更多News
    private void getBeforeNews(String time) {
        if(zhiHuRBView != null) {
            zhihuApi.getBeforeNews(time)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<LatestNews>() {
                        @Override
                        public void call(LatestNews latestNews) {
                            displayZhihuList(latestNews, mContext, zhiHuRBView, mRecyclerView);
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    });
        }
    }

    //获取主页News
    public void getLatestNews() {
        if(zhiHuRBView != null) {
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
                                  ZhiHuFGViewInterface zhiHuRBView, RecyclerView mRecyclerView) {
        if(isLoadMore) {
            if (time == null) {
                //一般time是不会为空的，因为在加载更多之前肯定加载过一次
                //time在本函数末尾已经赋值了
                return;
            } else {
                mLatestNews.getStories().addAll(latestNews.getStories());
            }
        } else {
            mLatestNews = latestNews;
            adapter = new ZhihuListAdapter(mContext, mLatestNews);
            mRecyclerView.setAdapter(adapter);
        }
        adapter.notifyDataSetChanged();
        zhiHuRBView.setDataRefresh(false);
        time = latestNews.getDate();
    }

    public void reView() {
        adapter.notifyDataSetChanged();
    }

}
