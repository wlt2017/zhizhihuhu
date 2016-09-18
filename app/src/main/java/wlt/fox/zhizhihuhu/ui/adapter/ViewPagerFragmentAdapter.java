package wlt.fox.zhizhihuhu.ui.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import wlt.fox.zhizhihuhu.ui.base.MVPBaseFragment;

/**
 * Created by wlt on 2016/9/18.
 * E-mail : autumnsassou@163.com
 */
public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {

    //private String tag;

    private List<MVPBaseFragment> fragmentList;

    public ViewPagerFragmentAdapter(FragmentManager fm, List<MVPBaseFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
//    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "知乎日报";
            case 1:
                return "只知呼呼";
            case 2:
                return "知之乎乎";
        }
        return null;
    }
}
