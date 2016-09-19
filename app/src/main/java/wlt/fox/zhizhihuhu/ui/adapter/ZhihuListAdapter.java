package wlt.fox.zhizhihuhu.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.bean.zhihu.LatestNews;
import wlt.fox.zhizhihuhu.util.LogUtils;
import wlt.fox.zhizhihuhu.view.TopStoriesViewPager;

/**
 * Created by wlt on 2016/9/19.
 * E-mail : autumnsassou@163.com
 */
public class ZhihuListAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static String TAG = "ZhihuListAdapter";

    private Context mContext;
    private LatestNews mLatestNews;

    //??
    private int mStatus = 1;

    public static final int LOAD_MORE = 0;
    public static final int LOAD_PULL_TO = 1;
    public static final int LOAD_NONE = 2;
    public static final int LOAD_END = 3;

    private static final int TYPE_TOP = -1;
    private static final int TYPE_FOOTER = -2;

    public ZhihuListAdapter(Context Context, LatestNews LatestNews) {
        mContext = Context;
        mLatestNews = LatestNews;
    }

    @Override
    public int getItemViewType(int position) {
        if (mLatestNews.getTop_stories() != null) {
            if (position == 0) {
                return TYPE_TOP;
            }else {
                return position;
            }
        } else {
            return position;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_TOP) {
            View rootView = View.inflate(
                    parent.getContext(), R.layout.item_zhihu_top_stories, null);
            return new TopStroiedViewHolder(rootView);
        }else {
            View rootView = View.inflate(
                    parent.getContext(), R.layout.item_zhihu_stories, null);
            return  new StoriesViewHolder(rootView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof StoriesViewHolder) {
            StoriesViewHolder storiesViewHolder = (StoriesViewHolder) holder;
            storiesViewHolder.bindItem(mLatestNews.getStories().get(position-1));
        } else if (holder instanceof  TopStroiedViewHolder) {
            TopStroiedViewHolder topStroiedViewHolder = (TopStroiedViewHolder) holder;
            topStroiedViewHolder.bindItem(mLatestNews.getTop_stories());
        }
    }

    /**
     * Top
     */
    class TopStroiedViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.vp_top_stories)
        TopStoriesViewPager vp_top_stories;
        @BindView(R.id.tv_top_title)
        TextView tv_top_title;

        public TopStroiedViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(List<LatestNews.TopStories> top_stories) {
            vp_top_stories.init(top_stories, tv_top_title, new TopStoriesViewPager.ViewPagerClickListenner() {
                @Override
                public void onClick(LatestNews.TopStories item) {
                    // TODO: 2016/9/19
                }
            });
        }
    }

    /**
     * Content
     */
    class StoriesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_stories)
        CardView card_stories;
        @BindView(R.id.tv_stories_title)
        TextView tv_stories_title;
        @BindView(R.id.iv_stories_img)
        ImageView iv_stories_img;

        public StoriesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(LatestNews.Stories stories) {
            LogUtils.d(TAG, stories.getTitle());
            if(stories.getTitle() != null) {
                tv_stories_title.setText(stories.getTitle());
            }
            List<String> images = stories.getImages();
            Glide.with(mContext).load(images.get(0)).centerCrop().into(iv_stories_img);
            card_stories.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    // TODO: 2016/9/19
    @Override
    public int getItemCount() {
        LogUtils.d(TAG, " "+ (mLatestNews.getStories().size()+1));
        return mLatestNews.getStories().size()+1;
    }

    // change recycler state
    public void updateLoadStatus(int status) {
        mStatus = status;
        notifyDataSetChanged();
    }

}
