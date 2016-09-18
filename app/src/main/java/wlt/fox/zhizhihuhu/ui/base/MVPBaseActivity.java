package wlt.fox.zhizhihuhu.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wlt on 2016/9/17.
 * E-mail : autumnsassou@163.com
 */
public abstract class MVPBaseActivity<V, T extends BasePresentter<V>> extends AppCompatActivity {

    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(createPresenter() != null) {
            mPresenter = createPresenter();
            mPresenter.attachView((V) this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract T createPresenter();

}
