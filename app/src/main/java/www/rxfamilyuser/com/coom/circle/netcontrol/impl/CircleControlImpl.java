package www.rxfamilyuser.com.coom.circle.netcontrol.impl;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import www.rxfamilyuser.com.base.BaseNetControl;
import www.rxfamilyuser.com.coom.circle.Bean.CircleBean;
import www.rxfamilyuser.com.coom.circle.netcontrol.ICircleControl;
import www.rxfamilyuser.com.network.RequestCallBack;
import www.rxfamilyuser.com.network.request.HttpRequestImpl;

/**
 * Created by ali on 2017/223.
 */

public class CircleControlImpl extends BaseNetControl implements ICircleControl {
    @Override
    public void getInvitationListData(final RequestCallBack callBack, Map<String, Integer> map, final int tag) {
        callBack.beforeRequest(tag);
        HttpRequestImpl.getInstance()
                .getInvitationData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CircleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;

                    }

                    @Override
                    public void onNext(CircleBean value) {
                        callBack.success(value, tag);
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
