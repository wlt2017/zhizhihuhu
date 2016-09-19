package wlt.fox.zhizhihuhu.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.ui.adapter.ViewPagerFragmentAdapter;
import wlt.fox.zhizhihuhu.ui.base.BasePresentter;
import wlt.fox.zhizhihuhu.ui.base.MVPBaseActivity;
import wlt.fox.zhizhihuhu.ui.base.MVPBaseFragment;
import wlt.fox.zhizhihuhu.ui.fragment.GanHuoFragment;
import wlt.fox.zhizhihuhu.ui.fragment.ThirdFragment;
import wlt.fox.zhizhihuhu.ui.fragment.ZhiHuRiBaoFragment;

/**
 * Created by wlt on 2016/9/17.
 * E-mail : autumnsassou@163.com
 */
public class MainActivity extends MVPBaseActivity {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.content_viewPager)
    ViewPager content_viewPager;

    private List<MVPBaseFragment> fragmentList;

    @Override
    protected BasePresentter createPresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initTabView();
    }

    private void initTabView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new ZhiHuRiBaoFragment());
        fragmentList.add(new GanHuoFragment());
        fragmentList.add(new ThirdFragment());
        content_viewPager.setOffscreenPageLimit(3);
        content_viewPager.setAdapter(new ViewPagerFragmentAdapter(
                getSupportFragmentManager(), fragmentList));
        tabLayout.setupWithViewPager(content_viewPager);
    }

}
