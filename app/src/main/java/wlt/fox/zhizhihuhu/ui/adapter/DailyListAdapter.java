package wlt.fox.zhizhihuhu.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.bean.daily.DailyBean;
import wlt.fox.zhizhihuhu.bean.zhihu.LatestNews;
import wlt.fox.zhizhihuhu.ui.activity.WebActivity;
import wlt.fox.zhizhihuhu.view.TopStoriesViewPager;

/**
 * Created by wlt on 2016/9/20.
 * E-mail : autumnsassou@163.com
 */
public class DailyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    DailyBean.ResponseBean response;

    private static final int TYPE_TOP = -1;

    private static final int TYPE_HEADLINE = -3;

    private int feed_position = 2;

    public DailyListAdapter(Context mContext, DailyBean.ResponseBean response) {
        this.mContext = mContext;
        this.response = response;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return TYPE_TOP;
        } else if(position == 1) {
            return TYPE_HEADLINE;
        } else {
            return position;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView;
        if(viewType == TYPE_TOP) {
            rootView = View.inflate(parent.getContext(),
                    R.layout.item_zhihu_top_stories, null);
            return new TopStoriesViewHolder(rootView);
        } else if (viewType == TYPE_HEADLINE) {
            rootView = View.inflate(parent.getContext(),
                    R.layout.item_daily_headline, null);
            return new HeadlineViewHolder(rootView);
        } else {
            DailyBean.ResponseBean.FeedsBean feedsBean = response.getFeeds().get(viewType - 2);
            switch (feedsBean.getType()) {
                case 0: {
                    rootView = View.inflate(parent.getContext(),
                            R.layout.item_daily_feed_0, null);
                    return new Feed_0_ViewHolder(rootView);
                }
                case 1: {
                    rootView = View.inflate(parent.getContext(),
                            R.layout.item_daily_feed_1, null);
                    return new Feed_1_ViewHolder(rootView);
                }
                case 2: {
                    rootView = View.inflate(parent.getContext(),
                            R.layout.item_daily_feed_0, null);
                    return new Feed_0_ViewHolder(rootView);
                }
                default:
                    rootView = View.inflate(parent.getContext(),
                            R.layout.item_empty, null);
                    return new EmptyViewHolder(rootView);
            }
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopStoriesViewHolder) {
            TopStoriesViewHolder topStoriesViewHolder = (TopStoriesViewHolder) holder;
            topStoriesViewHolder.bindItem(response.getBanners());
        } else if (holder instanceof HeadlineViewHolder) {
            HeadlineViewHolder headlineViewHolder = (HeadlineViewHolder) holder;
            headlineViewHolder.bindItem(response.getHeadline());
        } else if (holder instanceof Feed_1_ViewHolder) {
            Feed_1_ViewHolder feed_1_viewHolder = (Feed_1_ViewHolder) holder;
            DailyBean.ResponseBean.FeedsBean feedsBean = response.getFeeds().get(position - feed_position);
            if (feedsBean.getType() == 1) {
                feed_1_viewHolder.bindItem(feedsBean);
            }
        } else if (holder instanceof Feed_0_ViewHolder) {
            Feed_0_ViewHolder feed_0_viewHolder = (Feed_0_ViewHolder) holder;
            DailyBean.ResponseBean.FeedsBean feedsBean = response.getFeeds().get(position - feed_position);
            if (feedsBean.getType() == 0) {
                feed_0_viewHolder.bindItem(feedsBean);
            } else if (feedsBean.getType() == 2) {
                feed_0_viewHolder.bindItem(feedsBean);
            }
        } else if (holder instanceof EmptyViewHolder) {

        }
    }

    @Override
    public int getItemCount() {
        return response.getFeeds().size() + 2;
    }

    class TopStoriesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.vp_top_stories)
        TopStoriesViewPager vp_top_stories;
        @BindView(R.id.tv_top_title)
        TextView tv_top_title;
        @BindView(R.id.tv_tag)
        TextView tv_tag;

        public TopStoriesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            tv_tag.setVisibility(View.GONE);
        }

        public void bindItem(List<DailyBean.ResponseBean.BannersBean> banners) {
            List<LatestNews.TopStories> topList = new ArrayList<>();
            for (DailyBean.ResponseBean.BannersBean banner : banners) {
                LatestNews.TopStories t = new LatestNews.TopStories();
                t.setImage(banner.getImage());
                t.setTitle(banner.getPost().getTitle());
                t.setUrl(banner.getPost().getAppview());
                topList.add(t);
            }
            vp_top_stories.init(topList, tv_top_title, new TopStoriesViewPager.ViewPagerClickListenner() {
                @Override
                public void onClick(LatestNews.TopStories item) {
                    startWebActivity(item.getUrl());
                }
            });
        }
    }

    private void startWebActivity(String url) {
        Intent intent = WebActivity.newIntent(mContext, url);
        mContext.startActivity(intent);
    }

    class HeadlineViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_headline_1)
        TextView tv_headline_1;
        @BindView(R.id.tv_headline_2)
        TextView tv_headline_2;
        @BindView(R.id.tv_headline_3)
        TextView tv_headline_3;
        @BindView(R.id.card_headline)
        CardView card_headline;

        public HeadlineViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(final DailyBean.ResponseBean.HeadlineBean headline) {
            List<DailyBean.ResponseBean.HeadlineBean.ListBean> headLines = headline.getList();
            tv_headline_1.setText(headLines.get(0).getDescription());
            tv_headline_2.setText(headLines.get(1).getDescription());
            tv_headline_3.setText(headLines.get(2).getDescription());
            card_headline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startWebActivity(headline.getPost().getAppview());
                }
            });
        }
    }


    class Feed_0_ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_feed_0_icon)
        ImageView iv_feed_0_icon;
        @BindView(R.id.tv_feed_0_title)
        TextView tv_feed_0_title;
        @BindView(R.id.tv_feed_0_desc)
        TextView tv_feed_0_desc;
        @BindView(R.id.iv_feed_0_type)
        ImageView iv_feed_0_type;
        @BindView(R.id.tv_Feed_0_type)
        TextView tv_Feed_0_type;
        @BindView(R.id.card_layout)
        CardView card_layout;

        public Feed_0_ViewHolder(View rootView) {
            super(rootView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(final DailyBean.ResponseBean.FeedsBean feeds) {
            tv_feed_0_title.setText(feeds.getPost().getTitle());
            tv_feed_0_desc.setText(feeds.getPost().getDescription());
            tv_Feed_0_type.setText(feeds.getPost().getCategory().getTitle());
            Glide.with(mContext).load(feeds.getImage()).centerCrop().into(iv_feed_0_icon);
            if (feeds.getType() == 0) {
                Glide.with(mContext).load(R.drawable.feed_0_icon).centerCrop().into(iv_feed_0_type);
                card_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            } else if (feeds.getType() == 2) {
                Glide.with(mContext).load(R.drawable.feed_1_icon).centerCrop().into(iv_feed_0_type);
                card_layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startWebActivity(feeds.getPost().getAppview());
                    }
                });
            }
        }
    }

    class Feed_1_ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_feed_1_title)
        TextView tv_feed_1_title;
        @BindView(R.id.tv_feed_1_type)
        TextView tv_feed_1_type;
        @BindView(R.id.iv_feed_1_type_icon)
        ImageView iv_feed_1_type_icon;
        @BindView(R.id.iv_feed_1_icon)
        ImageView iv_feed_1_icon;
        @BindView(R.id.card_feed_1)
        CardView card_feed_1;

        public Feed_1_ViewHolder(View rootView) {
            super(rootView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(final DailyBean.ResponseBean.FeedsBean feeds) {
            tv_feed_1_title.setText(feeds.getPost().getTitle());
            tv_feed_1_type.setText(feeds.getPost().getCategory().getTitle());
            Glide.with(mContext).load(feeds.getPost().getCategory().getImage_lab()).centerCrop().into(iv_feed_1_type_icon);
            Glide.with(mContext).load(feeds.getImage()).centerCrop().into(iv_feed_1_icon);

            card_feed_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startWebActivity(feeds.getPost().getAppview());
                }
            });
        }
    }

    private class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View rootView) {
            super(rootView);
        }
    }
}
