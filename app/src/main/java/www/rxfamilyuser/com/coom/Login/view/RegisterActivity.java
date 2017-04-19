package www.rxfamilyuser.com.coom.Login.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.blankj.utilcode.utils.ToastUtils;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseActivity;
import www.rxfamilyuser.com.coom.Login.viewmodel.RegisterModel;
import www.rxfamilyuser.com.databinding.ActivityRegisterBinding;
import www.rxfamilyuser.com.util.ConstantUtil;
import www.rxfamilyuser.com.util.TitleBuilderUtils;

/**
 * 注册和找回密码
 */
public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegisterModel> {
    /**
     * share发送验证码回调
     */
    private EventHandler mEventHandler = new EventHandler() {
        @Override
        public void afterEvent(int event, int result, Object data) {

            if (result == SMSSDK.RESULT_COMPLETE) {

                //回调完成
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {

                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    mModel.getCodeSuccess(data);

                } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                    //返回支持发送验证码的国家列表

                }
            } else {
                ((Throwable) data).printStackTrace();
                ToastUtils.showShortToast("当前手机号发送短信的数量超过限");
            }
        }
    };
    /**
     * 1是注册/2是找回密码
     */
    private int mType = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        SMSSDK.initSDK(this, ConstantUtil.SMOB_APP_kEY, ConstantUtil.SMOB_APP_SECRET);
        SMSSDK.registerEventHandler(mEventHandler); //注册短信回调

        mType = getIntent().getIntExtra("type", 0);
        switch (mType) {
            case 1://注册
                new TitleBuilderUtils(this)
                        .setTitleText(getResources().getString(R.string.register))
                        .setLeftImage(R.mipmap.arrow_back)
                        .setLeftOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                finish();
                            }
                        });
                mBinder.lineName.setVisibility(View.VISIBLE);
                mBinder.btnRegister.setText(getResources().getString(R.string.register));
                break;
            case 2://找回密码
                new TitleBuilderUtils(this)
                        .setTitleText(getResources().getString(R.string.find_password))
                        .setLeftImage(R.mipmap.icon_back)
                        .setLeftOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                finish();
                            }
                        });
                mBinder.lineName.setVisibility(View.GONE);
                mBinder.btnRegister.setText(getResources().getString(R.string.chick_login));
                break;
        }
        mModel.showEnterAnimation();
    }

    @Override
    public void onBackPressed() {
        showActivityExitAnimation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(mEventHandler);
    }

    /**
     * 获取验证码的点击
     *
     * @param view
     */
    public void btnCode(View view) {
        mModel.getCode();
    }

    /**
     * FloatingActionButton点击消失动画
     *
     * @param view
     */
    public void btnFinsh(View view) {
        showActivityExitAnimation();
    }

    /**
     * 注册/找回密码
     *
     * @param view
     */
    public void btnLogin(View view) {
        switch (mType) {
            case 1:
                mModel.register();
                break;
            case 2:
                mModel.findPassWord();
                break;
        }
    }

    /**
     * 结束动画
     */
    public void showActivityExitAnimation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = ViewAnimationUtils.createCircularReveal(mBinder.cvMain, mBinder.cvMain.getWidth() / 2, 0, mBinder.cvMain.getHeight(), mBinder.fabQuitRegister.getWidth() / 2);
            animator.setDuration(500);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mBinder.cvMain.setVisibility(View.GONE);
                    super.onAnimationEnd(animation);
                    mBinder.fabQuitRegister.setImageResource(R.mipmap.plus);
                    RegisterActivity.super.onBackPressed();
                }
            });
            animator.start();

        } else {
            super.onBackPressed();
        }
    }
}
