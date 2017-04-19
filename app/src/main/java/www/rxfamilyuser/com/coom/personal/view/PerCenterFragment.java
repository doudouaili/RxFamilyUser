package www.rxfamilyuser.com.coom.personal.view;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.blankj.utilcode.utils.SPUtils;

import java.util.ArrayList;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseFragment;
import www.rxfamilyuser.com.coom.Login.adapter.MainViewPagerAdapter;
import www.rxfamilyuser.com.coom.Login.view.LoginActivity;
import www.rxfamilyuser.com.coom.personal.viewmodel.PerCenterViewModel;
import www.rxfamilyuser.com.databinding.FragmentPerCenterBinding;
import www.rxfamilyuser.com.util.GlideUtil;
import www.rxfamilyuser.com.util.SPkeyConstantUtil;
import www.rxfamilyuser.com.util.UserUtil;

public class PerCenterFragment extends BaseFragment<FragmentPerCenterBinding, PerCenterViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_per_center;
    }

    @Override
    public void initView() {

        mBinder.setModel(mModel);

        mBinder.toolbar.setTitle(getString(R.string.rb_mycenter));

        mBinder.collapsingToolbarLogin.setTitle("阿狸先生");

        ArrayList<Fragment> fragmentList = getFragmentList();

        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getChildFragmentManager(), fragmentList);
        mBinder.viewPager.setAdapter(mainViewPagerAdapter);
        mBinder.tabs.setupWithViewPager(mBinder.viewPager);//将TabLayout和ViewPager关联起来。

        mBinder.tabs.getTabAt(0).setText("个人主页");
        mBinder.tabs.getTabAt(1).setText("详细资料");


        mBinder.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });
    }

    private void setOnClickListener() {

    }

    private ArrayList<Fragment> getFragmentList() {
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        PersonalHomepageFragment personalHomepageFragment = new PersonalHomepageFragment();
        PersonalDetailsFragment personalDetailsFragment = new PersonalDetailsFragment();
        fragmentArrayList.add(personalHomepageFragment);
        fragmentArrayList.add(personalDetailsFragment);
        return fragmentArrayList;

    }

    @Override
    public void onResume() {
        //登录
        SPUtils spUtils = new SPUtils(SPkeyConstantUtil.SSP_KEY);
        boolean login = spUtils.getBoolean("login", false);
        if (login) {
            mBinder.linearNoLogin.setVisibility(View.GONE);
            mBinder.appbarLogin.setVisibility(View.VISIBLE);
            mBinder.nestedLogin.setVisibility(View.VISIBLE);
            GlideUtil.getInstance().loadImage(getContext(), UserUtil.getUserPhoto(), mBinder.ivUserPhoto);
            mBinder.collapsingToolbarLogin.setTitle(UserUtil.getUserName());

        } else {
          /*  mBinder.linearNoLogin.setVisibility(View.VISIBLE);
            mBinder.appbarLogin.setVisibility(View.GONE);
            mBinder.nestedLogin.setVisibility(View.GONE);*/
        }
        super.onResume();
    }
}
