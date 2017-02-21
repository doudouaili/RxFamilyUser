package www.rxfamilyuser.com.coom.Login.view;

import android.view.View;

import com.blankj.utilcode.utils.ToastUtils;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
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
                    //获取验证码成功
                    Observable.just(data)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Consumer<Object>() {
                                @Override
                                public void accept(Object o) throws Exception {
                                    ToastUtils.showShortToast("获取验码成功");
                                }
                            });

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
        SMSSDK.initSDK(this, ConstantUtil.sMOB_APP_kEY, ConstantUtil.sMOB_APP_SECRET);
        SMSSDK.registerEventHandler(mEventHandler); //注册短信回调

        mType = getIntent().getIntExtra("type", 0);
        switch (mType) {
            case 1://注册
                new TitleBuilderUtils(this)
                        .setTitleText(getResources().getString(R.string.register))
                        .setLeftImage(R.mipmap.icon_back)
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
        mModel.showActivityExitAnimation();
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
        mModel.showActivityExitAnimation();
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
}
