package wlt.fox.zhizhihuhu.ui.viewinterface;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public interface ZhiHuFGViewInterface {
    void setRefresh(boolean requestDataRefresh);
    RecyclerView getRecyclerView();
    LinearLayoutManager getLayoutManager();
}
