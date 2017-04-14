package www.rxfamilyuser.com.coom.drycargo.netcontrol.impl;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import www.rxfamilyuser.com.base.BaseNetControl;
import www.rxfamilyuser.com.coom.drycargo.bean.JokeListBean;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.IJokeFragmentControl;
import www.rxfamilyuser.com.network.RequestCallBack;
import www.rxfamilyuser.com.network.request.HttpRequestImpl;

/**
 * Created by ali on 2017/3/29.
 */

public class JokeFragmentControlImpl extends BaseNetControl implements IJokeFragmentControl {


    @Override
    public void getJokeList(final RequestCallBack callBack, Map<String, Integer> map, final int tag) {
        callBack.beforeRequest(tag);
        HttpRequestImpl.getInstance().getJokeCommentData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .safeSubscribe(new Observer<JokeListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(JokeListBean value) {
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
