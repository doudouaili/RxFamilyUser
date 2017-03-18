package www.rxfamilyuser.com.coom.drycargo.view;

import android.os.Bundle;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseActivity;
import www.rxfamilyuser.com.coom.drycargo.viewmodel.InforModel;
import www.rxfamilyuser.com.databinding.ActivityInforBinding;

public class InforActivity extends BaseActivity<ActivityInforBinding,InforModel> {


    @Override
    public int getLayoutId() {

        return R.layout.activity_infor;
    }

    @Override
    public void initView() {
        Bundle extras = getIntent().getExtras();
        String html = extras.getString("html");
        mBinder.webview.loadUrl(html);
    }
}
