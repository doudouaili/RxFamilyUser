package www.rxfamilyuser.com.base;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;
import android.view.View;

import com.blankj.utilcode.utils.ToastUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.network.RequestCallBack;


/**
 * Created by ali on 2017/2/15.
 */

public abstract class BaseModel<T extends ViewDataBinding, M extends IBaseControl> extends BaseObservable implements IModel, RequestCallBack {

    protected IModelActivitiy UI = null;
    protected T mBinder = null;
    protected M mControl = null;


    public View mNotWorkView;//无网络图片

    public void setView(IModelActivitiy activity) {

        UI = activity;
        mBinder = (T) UI.getBinder();
        mNotWorkView = View.inflate(UI.getConText(), R.layout.network, null);

        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class<M> bizClass = (Class) params[1];
        try {
            mControl = bizClass.newInstance();
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
        mControl.disposableCancel();
        UI.hideWaitDialog();
    }


    @Override
    public void beforeRequest(int tag) {
        onBeforeRequest(tag);
    }

    @Override
    public void success(Object data, int tag) {
        UI.hideWaitDialog();
        onSuccess(data, tag);

    }

    @Override
    public void error(String errorMsg) {
        UI.hideWaitDialog();
        onError(errorMsg);
        ToastUtils.showShortToast("网络连接异常!");
    }


    /**
     * 请求开始
     */
    public abstract void onBeforeRequest(int tag);

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
        return UI.getConText();
    }



}
