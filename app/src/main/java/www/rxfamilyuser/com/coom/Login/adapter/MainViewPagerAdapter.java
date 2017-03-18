package www.rxfamilyuser.com.coom.Login.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ali on 2017/2/20.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragmentsList;
    private FragmentManager fm;

    public MainViewPagerAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> fragmentsList) {
        super(supportFragmentManager);
        fm = supportFragmentManager;
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

    @Override
    public Fragment instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container,
                position);
        fm.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // super.destroyItem(container, position, object);
        Fragment fragment = mFragmentsList.get(position);
        fm.beginTransaction().hide(fragment).commit();
    }
}