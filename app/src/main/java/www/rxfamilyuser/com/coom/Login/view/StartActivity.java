package www.rxfamilyuser.com.coom.Login.view;

import com.blankj.utilcode.utils.SPUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseActivity;
import www.rxfamilyuser.com.coom.Login.viewmodel.StartModel;
import www.rxfamilyuser.com.databinding.ActivityStartBinding;
import www.rxfamilyuser.com.util.ConstantUtil;

public class StartActivity extends BaseActivity<ActivityStartBinding, StartModel> {


    @Override
    public int getLayoutId() {


        return R.layout.activity_start;
    }

    @Override
    public void initView() {

        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        jumpNextPage();
                    }
                });
    }

    private void jumpNextPage() {
        SPUtils spUtils = new SPUtils(ConstantUtil.sSP_KEY);
        if (!spUtils.getBoolean("initialize")) {
            intent2Activity(GuideActivity.class);
            spUtils.putBoolean("initialize", true);
            finish();
        } else {
            intent2Activity(MainActivity.class);
            finish();
        }
    }
}
