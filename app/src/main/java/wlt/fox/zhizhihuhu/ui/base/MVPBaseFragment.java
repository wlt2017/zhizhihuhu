package wlt.fox.zhizhihuhu.ui.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public abstract class MVPBaseFragment<V, T extends BasePresentter<V>> extends Fragment {

    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(createPresenter() != null) {
            mPresenter = createPresenter();
            mPresenter.attachView((V) this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract T createPresenter();

}
