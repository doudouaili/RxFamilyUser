package www.rxfamilyuser.com.coom.Login.viewmodel;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.Login.adapter.MainViewPagerAdapter;
import www.rxfamilyuser.com.coom.Login.netcontrol.impl.MainControlImpl;
import www.rxfamilyuser.com.coom.Login.view.MainActivity;
import www.rxfamilyuser.com.coom.circle.view.CircleFragment;
import www.rxfamilyuser.com.coom.drycargo.view.DryCargoFragment;
import www.rxfamilyuser.com.coom.find.view.MessageFragment;
import www.rxfamilyuser.com.coom.personal.view.PerCenterFragment;
import www.rxfamilyuser.com.databinding.ActivityMainBinding;

/**
 * Created by ali on 2017/2/20.
 */

public class MainModel extends BaseModel<ActivityMainBinding, MainControlImpl> {
    @Override
    public void onBeforeRequest(int tag) {

    }

    @Override
    public void onSuccess(Object bean, int tag) {

    }

    @Override
    public void onError(String errorMsg) {

    }

    /**
     * 初始化viewpager
     */
    public void initViewPager() {
        MainActivity mainActivity = (MainActivity) UI;
        ArrayList<Fragment> fragments = addListFragment();
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(mainActivity.getSupportFragmentManager(),fragments );
        mBinder.viewPager.setAdapter(mainViewPagerAdapter);
        mBinder.viewPager.setOffscreenPageLimit(3);

    }

    /**
     * 添加fragment
     *
     * @return fragment集合
     */
    public ArrayList<Fragment> addListFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new DryCargoFragment());
        fragments.add(new CircleFragment());
        fragments.add(new MessageFragment());
        fragments.add(new PerCenterFragment());
        return fragments;
    }


    /**
     * 设置vp的界面
     *
     * @param id
     */
    public void setCurrentItem(int id) {
        mBinder.viewPager.setCurrentItem(id, false);
    }


}
