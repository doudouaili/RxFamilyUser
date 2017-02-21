package www.rxfamilyuser.com.coom.Login.viewmodel;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;

import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.Login.netcontrol.impl.LoginBizImpl;
import www.rxfamilyuser.com.coom.Login.view.LoginActivity;
import www.rxfamilyuser.com.coom.Login.view.RegisterActivity;
import www.rxfamilyuser.com.databinding.ActivityLoginBinding;

/**
 * Created by ali on 2017/2/15.
 */

public class LoginModel extends BaseModel<ActivityLoginBinding, LoginBizImpl> {


    @Override
    public void onBeforeRequest() {

    }

    @Override
    public void onSuccess(Object bean, int tag) {
        //做界面显示或其他
    }

    @Override
    public void onError(String errorMsg) {

    }

    /**
     * 登录
     */
    public void login() {

    }


    /**
     * 跳转到注册界面
     *
     * @param type 1:注册;2:找回密码
     */
    public void intentRegis(int type) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBaseActivity.getWindow().setEnterTransition(null);
            mBaseActivity.getWindow().setExitTransition(null);
            LoginActivity loginActivity = (LoginActivity) mBaseActivity;
            ActivityOptions op = ActivityOptions.makeSceneTransitionAnimation(loginActivity, mBinder.fabRegisterLogin, mBinder.fabRegisterLogin.getTransitionName());
            Intent intent = new Intent(mBaseActivity.getApplicationContext(), RegisterActivity.class);
            intent.putExtra("type", type);
            loginActivity.startActivity(intent, op.toBundle());
        } else {
            Intent intent = new Intent(mBaseActivity.getApplicationContext(), RegisterActivity.class);
            intent.putExtra("type", type);
            mBaseActivity.startActivity(intent);
        }
    }
}
