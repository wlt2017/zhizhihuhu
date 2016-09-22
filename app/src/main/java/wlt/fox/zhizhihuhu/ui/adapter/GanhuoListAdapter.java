package wlt.fox.zhizhihuhu.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.bean.ganhuo.MeiZi;
import wlt.fox.zhizhihuhu.ui.activity.PictureActivity;
import wlt.fox.zhizhihuhu.ui.activity.WebActivity;

/**
 * Created by wlt on 2016/9/19.
 * E-mail : autumnsassou@163.com
 */
public class GanhuoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<MeiZi.Results> mList;

    public GanhuoListAdapter(Context context, List<MeiZi.Results> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_gank_meizi, parent, false);
        return new MeiziViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MeiziViewHolder meiziViewHolder = (MeiziViewHolder) holder;
        meiziViewHolder.bindItem(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MeiziViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card)
        CardView card_meizhi;
        @BindView(R.id.iv_meizhi)
        ImageView iv_meizhi;
        @BindView(R.id.tv_meizhi_title)
        TextView tv_meizhi_title;

        public MeiziViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(final MeiZi.Results meizi) {
            ChangeCardViewColor.setCardViewBackgroundColor(card_meizhi);
            tv_meizhi_title.setText(meizi.getDesc());
            Glide.with(mContext).load(meizi.getUrl()).centerCrop().into(iv_meizhi);
//            Glide.with(mContext).load(meizi.getUrl()).asBitmap().into(new SimpleTarget<Bitmap>() {
//                @Override
//                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                    iv_meizhi.setImageBitmap(resource);
//                    Palette.generateAsync(resource, new Palette.PaletteAsyncListener() {
//                        @Override
//                        public void onGenerated(Palette palette) {
//                            // 有活力的颜色
//                            Palette.Swatch vibrant = palette.getVibrantSwatch();
//                            if (vibrant != null) {
//                                card_meizhi.setBackgroundColor(vibrant.getRgb());
//                                tv_meizhi_title.setTextColor(vibrant.getTitleTextColor());
//                            }
//                        }
//                    });
//                }
//            });

            iv_meizhi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = PictureActivity.newIntent(mContext, meizi.getUrl(), meizi.getDesc());
                    mContext.startActivity(intent);
                }
            });

            card_meizhi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startWebActivity(meizi.getContentUrl());
                }
            });

        }
    }

    private void startWebActivity(String url) {
        Intent intent = WebActivity.newIntent(mContext, url);
        mContext.startActivity(intent);
    }


}
