package www.rxfamilyuser.com.coom.drycargo.view;

import android.support.v4.view.ViewPager;

import com.jude.swipbackhelper.SwipeBackHelper;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseActivity;
import www.rxfamilyuser.com.coom.drycargo.adapter.JokeViewPagerAdapter;
import www.rxfamilyuser.com.coom.drycargo.viewmodel.JokeModel;
import www.rxfamilyuser.com.databinding.ActivityJokeBinding;

/**
 * 笑话界面
 */

public class JokeAvtivity extends BaseActivity<ActivityJokeBinding, JokeModel> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_joke;
    }

    @Override
    public void initView() {
        final JokeViewPagerAdapter jokeViewPagerAdapter = new JokeViewPagerAdapter(getSupportFragmentManager());
        mBinder.viewpagerJoke.setAdapter(jokeViewPagerAdapter);

        jokeViewPagerAdapter.addItem(new JokeFragment(1));
        jokeViewPagerAdapter.addItem(new JokeFragment(2));

        mBinder.viewpagerJoke.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //第一页可以右滑退出
                if (position == 0) {
                    SwipeBackHelper.getCurrentPage(JokeAvtivity.this).setDisallowInterceptTouchEvent(false);
                } else {
                    SwipeBackHelper.getCurrentPage(JokeAvtivity.this).setDisallowInterceptTouchEvent(true);
                    jokeViewPagerAdapter.addItem(new JokeFragment(position + 2));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
