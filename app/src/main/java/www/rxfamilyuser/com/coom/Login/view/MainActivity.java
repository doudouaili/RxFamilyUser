package www.rxfamilyuser.com.coom.Login.view;

import android.view.Menu;
import android.widget.RadioGroup;

import com.blankj.utilcode.utils.ToastUtils;
import com.jude.swipbackhelper.SwipeBackHelper;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseActivity;
import www.rxfamilyuser.com.coom.Login.viewmodel.MainModel;
import www.rxfamilyuser.com.databinding.ActivityMainBinding;
import www.rxfamilyuser.com.util.AppManagerUtils;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainModel> implements RadioGroup.OnCheckedChangeListener {
    //返回键点击时间
    private long mExitTime = 0;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        SwipeBackHelper.getCurrentPage(this)
                .setSwipeBackEnable(false);
        SwipeBackHelper.getCurrentPage(this).setDisallowInterceptTouchEvent(true);


        mBinder.setMain(mModel);

        mModel.initViewPager();

        mBinder.rg.setOnCheckedChangeListener(this);

//        mBinder.viewPager.addOnPageChangeListener(mChListener);

    }

    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() - mExitTime > 2000) {
            mExitTime = System.currentTimeMillis();
            ToastUtils.showShortToast(R.string.edit_name);
        } else {
            AppManagerUtils.getAppManager().AppExit(getApplicationContext());
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                mModel.setCurrentItem(0);
                break;
            case R.id.rb_live:
                mModel.setCurrentItem(1);
                break;
            case R.id.rb_center:
                mModel.setCurrentItem(2);
                break;
            case R.id.rb_my:
                mModel.setCurrentItem(3);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
        setGuideView();
    }

    /**
     * 显示引导图
     */
    private void setGuideView() {

      /*   // 使用图片
        final ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.img_new_task_guide);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        iv.setLayoutParams(params);

        // 使用文字
        TextView tv = new TextView(this);
        tv.setText("欢迎使用");
        tv.setTextColor(getResources().getColor(R.color.white));
        tv.setTextSize(30);
        tv.setGravity(Gravity.CENTER);

        // 使用文字
        final TextView tv2 = new TextView(this);
        tv2.setText("欢迎使用2");
        tv2.setTextColor(getResources().getColor(R.color.white));
        tv2.setTextSize(30);
        tv2.setGravity(Gravity.CENTER);


        guideView = GuideView.Builder
                .newInstance(this)
                .setTargetView(menu)//设置目标
                .setCustomGuideView(iv)
                .setDirction(GuideView.Direction.LEFT_BOTTOM)
                .setShape(GuideView.MyShape.CIRCULAR)   // 设置圆形显示区域，
                .setBgColor(getResources().getColor(R.color.shadow))
                .setOnclickListener(new GuideView.OnClickCallback() {
                    @Override
                    public void onClickedGuideView() {
                        guideView.hide();
                        guideView2.show();
                    }
                })
                .build();


        guideView2 = GuideView.Builder
                .newInstance(this)
                .setTargetView(btnTest)
                .setCustomGuideView(tv)
                .setDirction(GuideView.Direction.LEFT_BOTTOM)
                .setShape(GuideView.MyShape.ELLIPSE)   // 设置椭圆形显示区域，
                .setBgColor(getResources().getColor(R.color.shadow))
                .setOnclickListener(new GuideView.OnClickCallback() {
                    @Override
                    public void onClickedGuideView() {
                        guideView2.hide();
                        guideView3.show();
                    }
                })
                .build();


        guideView3 = GuideView.Builder
                .newInstance(this)
                .setTargetView(btnTest2)
                .setCustomGuideView(tv2)
                .setDirction(GuideView.Direction.LEFT_BOTTOM)
                .setShape(GuideView.MyShape.RECTANGULAR)   // 设置矩形显示区域，
                .setRadius(80)          // 设置圆形或矩形透明区域半径，默认是targetView的显示矩形的半径，如果是矩形，这里是设置矩形圆角大小
                .setBgColor(getResources().getColor(R.color.shadow))
                .setOnclickListener(new GuideView.OnClickCallback() {
                    @Override
                    public void onClickedGuideView() {
                        guideView3.hide();
                        guideView.show();
                    }
                })
                .build();

        guideView.show();*/
    }

    /**
     * viewpager滑动监听
     */
   /* private ViewPager.OnPageChangeListener mChListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mBinder.rg.check(R.id.rb_home);
                    break;
                case 1:
                    mBinder.rg.check(R.id.rb_live);
                    break;
                case 2:
                    mBinder.rg.check(R.id.rb_center);
                    break;
                case 3:
                    mBinder.rg.check(R.id.rb_my);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };*/
}
