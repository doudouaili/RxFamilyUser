package www.rxfamilyuser.com.coom.drycargo.viewmodel;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.impl.DryCargoControlImpl;
import www.rxfamilyuser.com.coom.drycargo.view.DryReuseFragment;
import www.rxfamilyuser.com.databinding.FragmentDryCargoBinding;

/**
 * Created by ali on 2017/2/23.
 */

public class DryCargoModel extends BaseModel<FragmentDryCargoBinding, DryCargoControlImpl> {
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
     * 添加fragment
     *
     * @return fragment集合
     */
    public ArrayList<Fragment> addListFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        /* mBinder.tabs.getTabAt(0).setText("安装");
        mBinder.tabs.getTabAt(1).setText("ios");
        mBinder.tabs.getTabAt(2).setText("java");*/
        TabLayout tabs = mBinder.tabs;

        for (int i = 0; i < 10; i++) {
            fragments.add(new DryReuseFragment());
        }

        return fragments;
    }

}
