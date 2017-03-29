package www.rxfamilyuser.com.coom.drycargo.netcontrol.impl;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import www.rxfamilyuser.com.base.BaseApplication;
import www.rxfamilyuser.com.base.BaseNetControl;
import www.rxfamilyuser.com.cache.ACache;
import www.rxfamilyuser.com.cache.ACcheManager;
import www.rxfamilyuser.com.coom.drycargo.bean.HomeBean;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.IDryReuseControl;
import www.rxfamilyuser.com.network.RequestCallBack;
import www.rxfamilyuser.com.network.request.HttpRequestImpl;
import www.rxfamilyuser.com.util.ConstantUtil;

/**
 * Created by ali on 2017/3/2.
 */

public class DryReuseControlImpl extends BaseNetControl implements IDryReuseControl {
    @Override
    public void getDryData(final RequestCallBack callBack, Map<String, Integer> map, final int tag) {
        callBack.beforeRequest(tag);
        HttpRequestImpl.getInstance().infor(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                        HomeBean homeBean = (HomeBean) ACcheManager.getObjectBean(BaseApplication.getContext(), ConstantUtil.SNES_KEY);
                        if (homeBean != null) {
                            onNext(homeBean);
                            mDisposable.dispose();
                        }
                    }

                    @Override
                    public void onNext(HomeBean value) {
                        ACcheManager.putObjectBean(BaseApplication.getContext(), ConstantUtil.SNES_KEY, value, ACache.TIME_LOG);
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
