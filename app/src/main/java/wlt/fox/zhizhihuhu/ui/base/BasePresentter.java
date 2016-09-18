package wlt.fox.zhizhihuhu.ui.base;


import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Fox on 2016/9/17.
 */
public abstract class BasePresentter<T> {

    protected Reference<T> mViewRef;//view接口类型的弱引用

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
