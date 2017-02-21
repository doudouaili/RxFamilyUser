package www.rxfamilyuser.com.coom.Login.view;

import android.view.View;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseActivity;
import www.rxfamilyuser.com.coom.Login.viewmodel.LoginModel;
import www.rxfamilyuser.com.databinding.ActivityLoginBinding;
import www.rxfamilyuser.com.util.TitleBuilderUtils;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginModel> {


    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        new TitleBuilderUtils(this)
                .setTitleText(getResources().getString(R.string.login))
                .setLeftImage(R.mipmap.icon_back)
                .setLeftOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
        mBinder.setLog(mModel);
    }

    //登录
    public void btnLoginOrRegister(View view) {

    }

    //注册
    public void btnRegister(View view) {
        mModel.intentRegis(1);
    }

    //找回密码
    public void btnFindPassword(View view) {
        mModel.intentRegis(2);
    }


}
