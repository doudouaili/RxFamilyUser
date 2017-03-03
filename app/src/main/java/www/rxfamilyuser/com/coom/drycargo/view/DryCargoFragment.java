package www.rxfamilyuser.com.coom.drycargo.view;

import android.support.v4.app.Fragment;
import android.transition.Explode;

import java.util.ArrayList;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseFragment;
import www.rxfamilyuser.com.coom.Login.adapter.MainViewPagerAdapter;
import www.rxfamilyuser.com.coom.drycargo.viewmodel.DryCargoModel;
import www.rxfamilyuser.com.databinding.FragmentDryCargoBinding;

/**
 * 干货集中营
 */
public class DryCargoFragment extends BaseFragment<FragmentDryCargoBinding, DryCargoModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_dry_cargo;
    }

    @Override
    public void initView() {

        ArrayList<Fragment> fragments = mModel.addListFragment();
        mBinder.toolbar.setTitle("干货集中营");
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getChildFragmentManager(), fragments);
        mBinder.vpView.setAdapter(mainViewPagerAdapter);
        mBinder.tabs.setupWithViewPager(mBinder.vpView);//将TabLayout和ViewPager关联起来。

        mBinder.tabs.getTabAt(0).setText("安装");
        mBinder.tabs.getTabAt(1).setText("安装");
        mBinder.tabs.getTabAt(2).setText("安装");
        mBinder.tabs.getTabAt(3).setText("安装");
        mBinder.tabs.getTabAt(4).setText("安装");
        mBinder.tabs.getTabAt(5).setText("安装");
        mBinder.tabs.getTabAt(6).setText("安装");
        mBinder.tabs.getTabAt(7).setText("安装");
        mBinder.tabs.getTabAt(8).setText("安装");
        mBinder.tabs.getTabAt(9).setText("安装");
        showEnterAnimation();

    }

    private void showEnterAnimation() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Explode explode = new Explode();
            explode.setDuration(1000);
            getActivity().getWindow().setEnterTransition(explode);
        }
    }
}
