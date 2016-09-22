package wlt.fox.zhizhihuhu.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wlt.fox.zhizhihuhu.MyApp;
import wlt.fox.zhizhihuhu.R;
import wlt.fox.zhizhihuhu.ui.adapter.ChangeCardViewColor;
import wlt.fox.zhizhihuhu.ui.adapter.ViewPagerFragmentAdapter;
import wlt.fox.zhizhihuhu.ui.base.BasePresentter;
import wlt.fox.zhizhihuhu.ui.base.MVPBaseActivity;
import wlt.fox.zhizhihuhu.ui.base.MVPBaseFragment;
import wlt.fox.zhizhihuhu.ui.fragment.DailyFragment;
import wlt.fox.zhizhihuhu.ui.fragment.GanHuoFragment;
import wlt.fox.zhizhihuhu.ui.fragment.ZhiHuRiBaoFragment;
import wlt.fox.zhizhihuhu.util.nightmodel.NightModelManager;

/**
 * Created by wlt on 2016/9/17.
 * E-mail : autumnsassou@163.com
 */
public class MainActivity extends MVPBaseActivity {

//    @BindView(R.id.tabLayout)
//    TabLayout tabLayout;

    @BindView(R.id.content_viewPager)
    ViewPager content_viewPager;

    @BindView(R.id.app_bar_layout)
    AppBarLayout app_bar_layout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawerlayout)
    DrawerLayout mDrawerlayout;

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;

    @OnClick(R.id.about_me)
    void about_me(){
        //关于我
        mDrawerlayout.closeDrawers();
        startActivity(new Intent(this,AboutMeActivity.class));
    }

    @OnClick(R.id.exit)
    void exit() {
        //退出应用
        finish();
    }

    private List<MVPBaseFragment> fragmentList;

    @Override
    protected BasePresentter createPresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        NightModelManager.getInstance().attach(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBarAndDrawlayout();
        initTabView();
    }

    @Override
    protected void onDestroy() {
        NightModelManager.getInstance().detach(this);
        super.onDestroy();
    }

    private void initBarAndDrawlayout() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, mDrawerlayout, toolbar, R.string.open, R.string.close) {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                    }
                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                    }
                };
        actionBarDrawerToggle.syncState();
        mDrawerlayout.addDrawerListener(actionBarDrawerToggle);
        //解决NavigationView中的图标是灰色的问题
        //mNavigationView.setItemIconTintList(null);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if(item.getItemId() == R.id.yejian) {
                    changeNightModel();
                    return true;
                }
                mDrawerlayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.zhihu:
                        goToPage(0);
                        return true;
                    case R.id.ganhuo:
                        goToPage(1);
                        return true;
                    case R.id.haoqixin:
                        goToPage(2);
                        return true;
                    case R.id.about_me:
                        startActivity(new Intent(MainActivity.this,AboutMeActivity.class));
                        return true;
                }
                return false;
            }
        });
    }

    private void initTabView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new ZhiHuRiBaoFragment());
        fragmentList.add(new GanHuoFragment());
        fragmentList.add(new DailyFragment());
        content_viewPager.setOffscreenPageLimit(3);
        final ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(
                getSupportFragmentManager(), fragmentList);
        content_viewPager.setAdapter(adapter);
        content_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                toolbar.setTitle( adapter.getPageTitle(position) );
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //tabLayout.setupWithViewPager(content_viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mode:
                changeNightModel();
                return true;
            case R.id.about_me:
                startActivity(new Intent(this,AboutMeActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToPage(int pageCount) {
        content_viewPager.setCurrentItem(pageCount, true);
    }

    private void changeNightModel() {
        if (NightModelManager.getInstance().isCurrentNightModel(this)) {
            NightModelManager.getInstance().applyDayModel(this);
        } else {
            NightModelManager.getInstance().applyNightModel(this);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            int color = MyApp.mContext.getResources().getColor(R.color.colorPrimaryDark);
            getWindow().setNavigationBarColor(color);
            getWindow().setStatusBarColor(color);
        }
        ChangeCardViewColor.getColor();
        Intent intent = new Intent("android.intent.action.CART_BROADCAST");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        //recreate();
    }



}
