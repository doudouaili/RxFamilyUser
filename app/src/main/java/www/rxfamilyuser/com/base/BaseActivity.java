package www.rxfamilyuser.com.base;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.zhy.autolayout.AutoLayoutActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.util.AppManagerUtils;

public abstract class BaseActivity<T extends ViewDataBinding, M extends BaseModel> extends AutoLayoutActivity {

    public T mBinder = null;//binder
    public M mModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinder = DataBindingUtil.setContentView(this, getLayoutId());
        AppManagerUtils.getAppManager().addActivity(this);
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class<M> bizClass = (Class) params[1];
        try {
            mModel = bizClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mModel.setView(this);
        mModel.onCreate();
        initView();
    }

    public abstract int getLayoutId();

    /**
     * 初始化 视图
     */
    public abstract void initView();

    @Override
    protected void onStart() {
        super.onStart();
        mModel.onStart();
    }

    public T getBinder() {
        return mBinder;
    }


    @Override
    protected void onResume() {
        super.onResume();
        mModel.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mModel.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mModel.onDestroy();
        AppManagerUtils.getAppManager().finishActivity(this);
    }

    /**
     * 跳转activity
     *
     * @param tarActivity 指定的activity
     */
    public void intent2Activity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(getApplicationContext(), tarActivity);
        startActivity(intent);
    }

}
