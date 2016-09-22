package wlt.fox.zhizhihuhu.ui.adapter;

import android.support.v7.widget.CardView;

import wlt.fox.zhizhihuhu.MyApp;
import wlt.fox.zhizhihuhu.R;

/**
 * Created by wlt on 2016/9/22.
 * E-mail : autumnsassou@163.com
 */
public class ChangeCardViewColor {
    public static int color;
    public static void setCardViewBackgroundColor(CardView cardView) {
        cardView.setCardBackgroundColor(color);
    }
    public static void getColor() {
        color = MyApp.mContext.getResources().getColor(R.color.cardBackColor);
    }
}
