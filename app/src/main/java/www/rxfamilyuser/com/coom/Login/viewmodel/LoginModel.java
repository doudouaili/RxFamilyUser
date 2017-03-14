package www.rxfamilyuser.com.coom.Login.viewmodel;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;

import com.blankj.utilcode.utils.RegexUtils;
import com.blankj.utilcode.utils.SPUtils;
import com.blankj.utilcode.utils.StringUtils;
import com.blankj.utilcode.utils.ToastUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.Login.bean.UserBean;
import www.rxfamilyuser.com.coom.Login.netcontrol.impl.ILoginControlImpl;
import www.rxfamilyuser.com.coom.Login.view.LoginActivity;
import www.rxfamilyuser.com.coom.Login.view.MainActivity;
import www.rxfamilyuser.com.coom.Login.view.RegisterActivity;
import www.rxfamilyuser.com.databinding.ActivityLoginBinding;
import www.rxfamilyuser.com.util.AppManagerUtils;
import www.rxfamilyuser.com.util.SPkeyConstantUtil;

/**
 * Created by ali on 2017/2/15.
 */

public class LoginModel extends BaseModel<ActivityLoginBinding, ILoginControlImpl> {


    @Override
    public void onBeforeRequest(int tag) {
        mDialog.show();
    }

    @Override
    public void onSuccess(Object bean, int tag) {

        //做面显示或其他
        switch (tag) {
            case 1:
                UserBean userBean = (UserBean) bean;
                if (userBean.getCode() != 0) {
                    List<UserBean.User> users = userBean.getResult();
                    SPUtils spUtils = new SPUtils(SPkeyConstantUtil.SSP_KEY);
                    if (users != null) {
                        spUtils.putBoolean("login", true);
                        spUtils.putString("phone", users.get(0).getUser_phone());
                        spUtils.putString("photo", users.get(0).getUser_photo());
                    }
                    //保存用户名
                    spUtils.putBoolean("saveuser", mBinder.checkEnableLogin.isChecked());

                    //自动登录
                    spUtils.putBoolean("automaticlogin", mBinder.checkRememberPwd.isChecked());

                    Intent intent = new Intent(getContent(), MainActivity.class);
                    getContent().startActivity(intent);
                    AppManagerUtils.getAppManager().finishActivity(LoginActivity.class);
                    ToastUtils.showShortToast(userBean.getMsg());
                }
                ToastUtils.showShortToast(userBean.getMsg());
                break;
        }
    }

    @Override
    public void onError(String errorMsg) {

    }

    /**
     * 登录
     */
    public void login() {
        String passWord = passWordReg();

        String phone = phoneReg();

        if (phone == "" | passWord == "") {
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("user_phone", phone);
        map.put("user_password", passWord);
        mControl.login(this, map, 1);
    }

    /**
     * 手机号验证
     *
     * @return 手机号
     */
    private String phoneReg() {

        String phone = mBinder.editPhoneLogin.getText().toString().trim();

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
     * 第一次密码验证
     *
     * @return 密码
     */
    private String passWordReg() {
        String pwd = mBinder.etPasswordLogin.getText().toString().trim();
        if (StringUtils.isEmpty(pwd)) {
            ToastUtils.showShortToast("您输入的密码为空");
        } else if (pwd.length() < 6 || pwd.length() > 12) {
            ToastUtils.showShortToast("密码在6-12位之间");
        } else {
            return pwd;
        }
        return "";
    }


    /**
     * 跳转到注册界面
     *
     * @param type 1:注册;2:找回密码
     */
    public void intentRegis(int type) {
        LoginActivity loginActivity = (LoginActivity) UI;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            loginActivity.getWindow().setEnterTransition(null);
            loginActivity.getWindow().setExitTransition(null);
            ActivityOptions op = ActivityOptions.makeSceneTransitionAnimation(loginActivity, mBinder.fabRegisterLogin, mBinder.fabRegisterLogin.getTransitionName());
            Intent intent = new Intent(getContent(), RegisterActivity.class);
            intent.putExtra("type", type);
            loginActivity.startActivity(intent, op.toBundle());
        } else {
            Intent intent = new Intent(getContent(), RegisterActivity.class);
            intent.putExtra("type", type);
            loginActivity.startActivity(intent);
        }
    }
}
