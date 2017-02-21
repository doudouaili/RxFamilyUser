package www.rxfamilyuser.com.coom.Login.netcontrol.impl;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import www.rxfamilyuser.com.base.BaseBiz;
import www.rxfamilyuser.com.coom.Login.bean.UserBean;
import www.rxfamilyuser.com.coom.Login.netcontrol.RegisterBiz;
import www.rxfamilyuser.com.network.RequestCallBack;
import www.rxfamilyuser.com.network.request.HttpRequestImpl;

/**
 * Created by ali on 2017/2/20.
 */

public class RegisterBizImpl extends BaseBiz implements RegisterBiz {

    @Override
    public void register(final RequestCallBack callBack, Map<String, String> map) {
        HttpRequestImpl.getInstance().register(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(UserBean value) {
                        callBack.success(value, 0);
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
