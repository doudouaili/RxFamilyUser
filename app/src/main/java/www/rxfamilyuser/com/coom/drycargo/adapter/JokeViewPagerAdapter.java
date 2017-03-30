package www.rxfamilyuser.com.coom.drycargo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by ali on 2017/3/30.
 */

public class JokeViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragmentArrayList;

    public JokeViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentArrayList = new ArrayList<Fragment>();
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    public void addItem(Fragment fragment) {
        fragmentArrayList.add(fragment);
        notifyDataSetChanged();
    }

}
