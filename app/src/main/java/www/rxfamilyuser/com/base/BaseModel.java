package www.rxfamilyuser.com.base;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import www.rxfamilyuser.com.network.RequestCallBack;


/**
 * Created by ali on 2017/2/15.
 */

public abstract class BaseModel<T extends ViewDataBinding, M extends BaseBiz> extends BaseObservable implements ModelImpl, RequestCallBack {

    protected BaseActivity mBaseActivity = null;
    protected T mBinder = null;
    protected M mBiz = null;

    public void setView(BaseActivity activity) {
        mBaseActivity = activity;
        mBinder = (T) activity.getBinder();

        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class<M> bizClass = (Class) params[1];
        try {
            mBiz = bizClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        mBiz.disposableCancel();
    }


    @Override
    public void beforeRequest() {
        onBeforeRequest();
    }

    @Override
    public void success(Object data, int tag) {
        onSuccess(data, tag);
    }

    @Override
    public void error(String errorMsg) {
        onError(errorMsg);
    }


    /**
     * 请求开始
     */
    public abstract void onBeforeRequest();

    /**
     * 请求成功
     *
     * @param tag  标签
     * @param bean 实体类对象
     */
    public abstract void onSuccess(Object bean, int tag);

    /**
     * 请求失败
     */
    public abstract void onError(String errorMsg);

    public Context getContent() {
        return mBaseActivity.getApplication();
    }

}
