package www.rxfamilyuser.com.coom.Login.view;

import android.view.View;

import com.blankj.utilcode.utils.SPUtils;
import com.blankj.utilcode.utils.ToastUtils;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseActivity;
import www.rxfamilyuser.com.coom.Login.viewmodel.LoginModel;
import www.rxfamilyuser.com.databinding.ActivityLoginBinding;
import www.rxfamilyuser.com.util.SPkeyConstantUtil;
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
                .setLeftImage(R.mipmap.arrow_back)
                .setLeftOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
        mBinder.setLog(mModel);

        //是否要求保存用户名
        SPUtils spUtils = new SPUtils(SPkeyConstantUtil.SSP_KEY);
        if (spUtils.getBoolean("saveuser")) {
            mBinder.editPhoneLogin.setText(spUtils.getString("user_phone"));
            mBinder.etPasswordLogin.setText(spUtils.getString("user_password"));
        }
    }

    //登录
    public void btnLoginOrRegister(View view) {
        mModel.login();
    }

    //注册
    public void btnRegister(View view) {
        mModel.intentRegis(1);
    }

    //找回密码
    public void btnFindPassword(View view) {
        mModel.intentRegis(2);
    }

    //QQ
    public void btnQQ(View view) {
        ToastUtils.showShortToast(R.string.versionhint);
    }

    //微信
    public void btnWX(View view) {
        ToastUtils.showShortToast(R.string.versionhint);
    }

    //新浪
    public void btnSia(View view) {
        ToastUtils.showShortToast(R.string.versionhint);
    }

}
