package wlt.fox.zhizhihuhu.ui.activity;

import android.os.Bundle;

import butterknife.ButterKnife;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.ui.base.BasePresentter;
import wlt.fox.zhizhihuhu.ui.base.MVPBaseActivity;


public class AboutMeActivity extends MVPBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        ButterKnife.bind(this);
    }

    @Override
    protected BasePresentter createPresenter() {
        return null;
    }


}
