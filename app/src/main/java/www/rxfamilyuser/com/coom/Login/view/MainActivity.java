package www.rxfamilyuser.com.coom.Login.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.blankj.utilcode.utils.SPUtils;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseActivity;
import www.rxfamilyuser.com.coom.Login.viewmodel.MainModel;
import www.rxfamilyuser.com.coom.sidebar.view.PersonageActivity;
import www.rxfamilyuser.com.databinding.ActivityMainBinding;
import www.rxfamilyuser.com.databinding.NavHeaderBinding;
import www.rxfamilyuser.com.util.ConstantUtil;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainModel> implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mBinder.setMain(mModel);

       /* ArrayList<Fragment> fragmentsList = mMainViewModel.addListFragment();
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), fragmentsList);
        binder.viewPager.setAdapter(mainViewPagerAdapter);
        binder.viewPager.setOffscreenPageLimit(2);
        binder.rg.setOnCheckedChangeListener(this);*/

        setSupportActionBar(mBinder.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mBinder.drawerLayout, mBinder.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mBinder.drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //侧边栏头布局
        View headview = navigationView.inflateHeaderView(R.layout.nav_header);

        NavHeaderBinding headerBinding = DataBindingUtil.bind(headview);

        headerBinding.ivUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!new SPUtils(ConstantUtil.sSP_KEY).getBoolean("login")) {
                    intent2Activity(LoginActivity.class);
                } else {
                    intent2Activity(PersonageActivity.class);
                }
            }
        });

    }



   /* @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                binder.viewPager.setCurrentItem(0, false);
                break;
            case R.id.rb_live:
                binder.viewPager.setCurrentItem(1, false);
                break;
            case R.id.rb_center:
                binder.viewPager.setCurrentItem(2, false);
                break;
        }
    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        mBinder.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mBinder.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mBinder.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
