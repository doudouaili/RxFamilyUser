package www.rxfamilyuser.com.base;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.blankj.utilcode.utils.Utils;

/**
 * Created by ali on 2017/2/15.
 */

public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Utils.init(this);

        LogUtils.Builder builder = LogUtils.getBuilder();

        builder.setTag("RxFamilyUser")
                .setLogSwitch(true)
                .setLog2FileSwitch(false)
                .create();
        ToastUtils.init(false);
    }

    // 获取ApplicationContext
    public static Context getContext() {
        return mContext;
    }
}
