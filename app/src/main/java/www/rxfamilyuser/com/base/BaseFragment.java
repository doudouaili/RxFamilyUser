package www.rxfamilyuser.com.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import www.rxfamilyuser.com.util.DialogUtil;

/**
 * Created by ali on 2017/2/23.
 */

public abstract class BaseFragment<T extends ViewDataBinding, M extends BaseModel> extends Fragment implements IModelActivitiy<T> {
    public T mBinder = null;//binder
    public M mModel = null;
    public DialogUtil mDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class<M> bizClass = (Class) params[1];
        try {
            mModel = bizClass.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinder = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), getLayoutId(), null, false);

        mModel.setView(this);
        mModel.onCreate();
        initView();
        return mBinder.getRoot();
    }

    public abstract int getLayoutId();

    public abstract void initView();

    @Override
    public Context getConText() {
        return this.getContext();
    }

    @Override
    public T getBinder() {
        return mBinder;
    }

    @Override
    public void onStart() {
        super.onStart();
        mModel.onStart();
    }


    @Override
    public void onResume() {
        super.onResume();
        mModel.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        mModel.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mModel.onDestroy();
    }

    /**
     * 显示进度条
     */
    public void showWaitDialog() {
        if (mDialog == null) {
            mDialog = new DialogUtil(getActivity());
        }
        mDialog.show();
    }

    /**
     * 隐藏进度条
     */
    public void hideWaitDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }


}
