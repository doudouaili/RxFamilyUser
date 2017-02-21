package www.rxfamilyuser.com.coom.Login.netcontrol.impl;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import www.rxfamilyuser.com.base.BaseBiz;
import www.rxfamilyuser.com.coom.Login.bean.UserBean;
import www.rxfamilyuser.com.coom.Login.netcontrol.LoginBiz;
import www.rxfamilyuser.com.network.request.HttpRequestImpl;
import www.rxfamilyuser.com.network.RequestCallBack;

/**
 * Created by ali on 2017/2/17.
 */

public class LoginBizImpl extends BaseBiz implements LoginBiz {

    @Override
    public void login(final RequestCallBack callBack, Map<String, String> map) {
        HttpRequestImpl.getInstance().login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(UserBean value) {
                        callBack.success(value, 1);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.error(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
