package www.rxfamilyuser.com.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.jude.swipbackhelper.SwipeBackHelper;
import com.zhy.autolayout.AutoLayoutActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import www.rxfamilyuser.com.util.AppManagerUtils;

public abstract class BaseActivity<T extends ViewDataBinding, M extends BaseModel> extends AutoLayoutActivity implements IModelActivitiy<T> {

    public T mBinder = null;//binder
    public M mModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //滑动删除库初始化
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeBackEnable(true)
                .setSwipeSensitivity(0.5f)
                .setSwipeRelateEnable(true)
                .setSwipeRelateOffset(300);

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

    @Override
    public T getBinder() {
        return mBinder;
    }

    @Override
    public Context getConText() {
        return this.getApplication();
    }

    /**
     * 初始化 视图
     */
    public abstract void initView();


    @Override
    protected void onStart() {
        super.onStart();
        mModel.onStart();
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
        SwipeBackHelper.onDestroy(this);
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
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }


}
