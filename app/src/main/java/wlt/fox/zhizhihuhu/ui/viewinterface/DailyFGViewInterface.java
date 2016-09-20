package wlt.fox.zhizhihuhu.ui.viewinterface;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by wlt on 2016/9/19.
 * E-mail : autumnsassou@163.com
 */
public interface DailyFGViewInterface {
    void setDataRefresh(Boolean refresh);
    RecyclerView getRecyclerView();
    LinearLayoutManager getLayoutManager();
}
