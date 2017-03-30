package www.rxfamilyuser.com.coom.Login.view;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jude.swipbackhelper.SwipeBackHelper;

import java.util.ArrayList;
import java.util.List;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseActivity;
import www.rxfamilyuser.com.coom.Login.adapter.GuideAdapter;
import www.rxfamilyuser.com.coom.Login.viewmodel.GuildeModel;
import www.rxfamilyuser.com.databinding.ActivityGuideBinding;

public class GuideActivity extends BaseActivity<ActivityGuideBinding, GuildeModel> {

    // 引导页图片资源
    private static final int[] pics = {R.layout.guid_view_one,
            R.layout.guid_view_two, R.layout.guid_view_three, R.layout.guid_view_four};
    // 底部小点图片
    private ImageView[] mDots;
    // 记录当前选中位置
    private int mCurrentIndex;
    private List<View> mViews;
    private Button btn_home;

    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initView() {
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeBackEnable(false);
        SwipeBackHelper.getCurrentPage(this).setDisallowInterceptTouchEvent(true);

        mViews = new ArrayList<View>();
        // 初始化引导页视图列表
        for (int i = 0; i < pics.length; i++) {
            View view = LayoutInflater.from(this).inflate(pics[i], null);
            mViews.add(view);
        }
        GuideAdapter guideAdapter = new GuideAdapter(mViews);
        mBinder.vpGuide.setAdapter(guideAdapter);
        mBinder.vpGuide.setOnPageChangeListener(new PageChangeListener());
        initDots();
    }

    private void initDots() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        mDots = new ImageView[pics.length];

        // 循环取得小点图片
        for (int i = 0; i < pics.length; i++) {
            // 得到一个LinearLayout下面的每一个子元素
            mDots[i] = (ImageView) ll.getChildAt(i);
            mDots[i].setEnabled(false);// 都设为灰色
            mDots[i].setTag(i);// 设置位置tag，方便取出与当前位置对应
        }

        mCurrentIndex = 0;
        mDots[mCurrentIndex].setEnabled(true); // 设置为白色，即选中状态

    }

    /**
     * 设置当前view
     *
     * @param position
     */
    private void setCurView(int position) {
        if (position < 0 || position >= pics.length) {
            return;
        }
        mBinder.vpGuide.setCurrentItem(position);
    }

    /**
     * 设置当前指示点
     *
     * @param position
     */
    private void setCurDot(int position) {
        if (position < 0 || position > pics.length || mCurrentIndex == position) {
            return;
        }
        mDots[position].setEnabled(true);
        mDots[mCurrentIndex].setEnabled(false);
        mCurrentIndex = position;
    }


    public void enterMainActivity(View view) {
        intent2Activity(MainActivity.class);
        finish();
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        // 当滑动状态改变时调用
        @Override
        public void onPageScrollStateChanged(int position) {
            // arg0 ==1的时辰默示正在滑动，arg0==2的时辰默示滑动完毕了，arg0==0的时辰默示什么都没做。

        }

        // 当前页面被滑动时调用
        @Override
        public void onPageScrolled(int position, float arg1, int arg2) {
            // arg0 :当前页面，及你点击滑动的页面
            // arg1:当前页面偏移的百分比
            // arg2:当前页面偏移的像素位置
            if (position == 3) {
                mBinder.btnHome.setVisibility(View.VISIBLE);
            } else {
                mBinder.btnHome.setVisibility(View.GONE);
            }

        }

        // 当新的页面被选中时调用
        @Override
        public void onPageSelected(int position) {
            // 设置底部小点选中状态
            setCurDot(position);
        }

    }

}
