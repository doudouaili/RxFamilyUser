package www.rxfamilyuser.com.coom.Login.viewmodel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.CountDownTimer;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.blankj.utilcode.utils.RegexUtils;
import com.blankj.utilcode.utils.StringUtils;
import com.blankj.utilcode.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import cn.smssdk.SMSSDK;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.Login.bean.UserBean;
import www.rxfamilyuser.com.coom.Login.netcontrol.impl.IRegisterControlImpl;
import www.rxfamilyuser.com.coom.Login.view.RegisterActivity;
import www.rxfamilyuser.com.databinding.ActivityRegisterBinding;
import www.rxfamilyuser.com.util.AESHelperUtil;

/**
 * Created by ali on 2017/2/20.
 */

public class RegisterModel extends BaseModel<ActivityRegisterBinding, IRegisterControlImpl> {
    RegisterActivity activity;

    @Override
    public void onCreate() {
        super.onCreate();
        activity = (RegisterActivity) UI;
    }

    @Override
    public void onBeforeRequest(int tag) {
        UI.showWaitDialog();
    }

    @Override
    public void onSuccess(Object bean, int tag) {
        switch (tag) {
            case 1://注册/找回密码
                UserBean userBean = (UserBean) bean;
                if (userBean.getCode() == 1) {
                    ToastUtils.showShortToast(userBean.getMessage());
                    activity.finish();

                  /*  List<UserBean.User> users = userBean.getResult();
                    if (users != null) {
                        SPUtils spUtils = new SPUtils(SPkeyConstantUtil.SSP_KEY);
                        spUtils.putBoolean("login", true);
                        spUtils.putString("phone", users.get(0).getUser_phone());
                        spUtils.putString("photo", users.get(0).getUser_photo());
                    }

                    Intent intent = new Intent(getContent(), MainActivity.class);
                    getContent().startActivity(intent);
                    ToastUtils.showShortToast(userBean.getMsg());
                    activity.finish();
                    AppManagerUtils.getActivity(LoginActivity.class).finish();*/

                } else {
                    ToastUtils.showShortToast(userBean.getMessage());
                }
                break;
        }
    }

    @Override
    public void onError(String errorMsg) {

    }

    /**
     * 进入动画
     */
    public void showEnterAnimation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition transition = TransitionInflater.from(activity).inflateTransition(R.transition.fabtransition);
            activity.getWindow().setSharedElementEnterTransition(transition);
            transition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {
                    mBinder.cvMain.setVisibility(View.GONE);
                }

                @Override
                public void onTransitionEnd(Transition transition) {
                    showActivityEnterAnimation();
                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });
        }
    }

    /**
     * 开启动画
     */
    private void showActivityEnterAnimation() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = ViewAnimationUtils.createCircularReveal(mBinder.cvMain, mBinder.cvMain.getWidth() / 2, 0, mBinder.fabQuitRegister.getWidth() / 2, mBinder.cvMain.getHeight());
            animator.setDuration(500);
            animator.setInterpolator(new AccelerateDecelerateInterpolator());
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    mBinder.cvMain.setVisibility(View.VISIBLE);
                    super.onAnimationStart(animation);
                }
            });
            animator.start();
        }
    }


    /**
     * 获取验证码
     */
    public void getCode() {
        String phone = mBinder.editPhoneRegister.getText().toString().trim();

        if (StringUtils.isEmpty(phone)) {
            ToastUtils.showShortToast("您输入的手机号为空");
            return;
        }

        if (RegexUtils.isMobileExact(phone)) {
            SMSSDK.getVerificationCode("86", phone);
            new TimeCount(60000, 1000).start();
        } else {
            ToastUtils.showShortToast("您输入的手机号格式不正确");
        }
    }

    /**
     * 注册
     */
    public void register() {
        String name = userNameReg();
        String againPaw = againPassWordReg();
        String psw = passWordReg();
        String code = codeReg();
        String phone = phoneReg();

        if (phone == "" | code == "" | psw == "" | againPaw == "" | name == "") {
            return;
        }

        if (!psw.equals(againPaw)) {
            ToastUtils.showShortToast("您输入的两次密码不一致");
            return;
        }

        //加密上传
        phone = AESHelperUtil.encrypt(phone);
        psw = AESHelperUtil.encrypt(psw);

        Map<String, String> map = new HashMap<>();
        map.put("user_name", name);
        map.put("user_password", psw);
        map.put("user_code", code);
        map.put("user_phone", phone);
        mControl.register(this, map, 1);
    }

    /**
     * 找回密码
     */
    public void findPassWord() {
        String againPaw = againPassWordReg();
        String psw = passWordReg();
        String code = codeReg();
        String phone = phoneReg();
        if (phone == "" | code == "" | psw == "" | againPaw == "") {
            return;
        }

        if (!psw.equals(againPaw)) {
            ToastUtils.showShortToast("您输入的两次密码不一致");
            return;
        }

        phone = AESHelperUtil.encrypt(phone);
        psw = AESHelperUtil.encrypt(psw);

        Map<String, String> map = new HashMap<>();
        map.put("user_password", psw);
        map.put("user_code", code);
        map.put("user_phone", phone);
        mControl.findPassWord(this, map, 1);


    }

    /**
     * 手机号验证
     *
     * @return 手机号
     */
    private String phoneReg() {

        String phone = mBinder.editPhoneRegister.getText().toString().trim();

        if (StringUtils.isEmpty(phone)) {
            ToastUtils.showShortToast("您输入的手机号为空");
        } else if (!RegexUtils.isMobileExact(phone)) {
            ToastUtils.showShortToast("您输入的手机号格式不正确");
        } else {
            return phone;
        }
        return "";
    }

    /**
     * 验证码验证
     *
     * @return 输入的验证码
     */
    private String codeReg() {
        String code = mBinder.editCode.getText().toString().trim();
        if (StringUtils.isEmpty(code)) {
            ToastUtils.showShortToast("您输入的验证码为空");
        } else {
            return code;
        }
        return "";
    }

    /**
     * 第一次密码验证
     *
     * @return 密码
     */
    private String passWordReg() {
        String pwd = mBinder.editPwd.getText().toString().trim();
        if (StringUtils.isEmpty(pwd)) {
            ToastUtils.showShortToast("您输入的密码空");
        } else if (pwd.length() < 6 || pwd.length() > 12) {
            ToastUtils.showShortToast("密码在6-12位之间");
        } else {
            return pwd;
        }
        return "";
    }

    /**
     * 第二次密码验证
     *
     * @return 密码
     */
    private String againPassWordReg() {
        String pwd = mBinder.editAgainPwd.getText().toString().trim();
        if (StringUtils.isEmpty(pwd)) {
            ToastUtils.showShortToast("您输入的二次密码为空");
        } else if (pwd.length() < 6 || pwd.length() > 12) {
            ToastUtils.showShortToast("二次密码在6-12位之间");
        } else {
            return pwd;
        }
        return "";
    }

    /**
     * 用户名验证
     *
     * @return 用户名
     */
    private String userNameReg() {
        String name = mBinder.editName.getText().toString().trim();
        if (StringUtils.isEmpty(name)) {
            ToastUtils.showShortToast("您输入的用户名为空");
        } else if (name.length() > 8) {
            ToastUtils.showShortToast("用户名的长度在8位一下");
        } else {
            return name;
        }
        return "";
    }

    /**
     * 获取验证码成功的回调
     *
     * @param data
     */
    public void getCodeSuccess(Object data) {

        Observable.just(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        ToastUtils.showShortToast("获取验码成功");
                    }
                });
    }

    /**
     * 验证码时间设置
     */
    class TimeCount extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mBinder.btnCode.setClickable(false);
            mBinder.btnCode.setText(millisUntilFinished / 1000 + "s");
            mBinder.btnCode.setTextColor(activity.getResources().getColor(R.color.test_head_color));
        }

        @Override
        public void onFinish() {
            mBinder.btnCode.setText("重新获取");
            mBinder.btnCode.setClickable(true);
            mBinder.btnCode.setTextColor(activity.getResources().getColor(R.color.login_view));
        }
    }
}
