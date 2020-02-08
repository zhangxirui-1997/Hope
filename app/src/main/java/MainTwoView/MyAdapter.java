package MainTwoView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends FragmentPagerAdapter {
    List<Fragment> listFragment;
    List<String> listTab = new ArrayList<String>();

    public MyAdapter(FragmentManager fm, List<Fragment> listFragment, List<String>listTab) {
        super(fm);
        this.listFragment=listFragment;
        this.listTab=listTab;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        //返回标题名称
        return listTab.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        //返回页面内容
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        //一共多少个页面
        return listFragment.size();
    }
}
