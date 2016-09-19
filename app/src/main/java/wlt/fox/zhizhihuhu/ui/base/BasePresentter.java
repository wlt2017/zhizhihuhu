package wlt.fox.zhizhihuhu.ui.base;


import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import wlt.fox.zhizhihuhu.api.ApiFactory;
import wlt.fox.zhizhihuhu.api.DailyApi;
import wlt.fox.zhizhihuhu.api.GankApi;
import wlt.fox.zhizhihuhu.api.ZhihuApi;

/**
 * Created by Fox on 2016/9/17.
 */
public abstract class BasePresentter<T> {

    protected Reference<T> mViewRef;//view接口类型的弱引用

    public static final ZhihuApi zhihuApi = ApiFactory.getZhihuApiSingleton();
    public static final GankApi gankApi = ApiFactory.getGankApiSingleton();
    public static final DailyApi dailyApi = ApiFactory.getDailyApiSingleton();


    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);//建立关联
    }

    protected T getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
