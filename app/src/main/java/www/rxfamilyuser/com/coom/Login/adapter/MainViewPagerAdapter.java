package www.rxfamilyuser.com.coom.Login.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by ali on 2017/2/20.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> mFragmentsList;

    public MainViewPagerAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> fragmentsList) {
        super(supportFragmentManager);
        mFragmentsList = fragmentsList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentsList.size();
    }

}