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
import www.rxfamilyuser.com.coom.drycargo.bean.TitleBean;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.IDryCargoControl;
import www.rxfamilyuser.com.network.RequestCallBack;
import www.rxfamilyuser.com.network.request.HttpRequestImpl;
import www.rxfamilyuser.com.util.ConstantUtil;

/**
 * Created by ali on 2017/2/23.
 */

public class DryCargoControlImpl extends BaseNetControl implements IDryCargoControl {

    @Override
    public void getTitile(final RequestCallBack callBack, Map<String, Integer> map, final int tag) {
        callBack.beforeRequest(tag);
        HttpRequestImpl.getInstance()
                .getTitle(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TitleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                        TitleBean titleBean = (TitleBean) ACcheManager.getObjectBean(BaseApplication.getContext(), ConstantUtil.STITLE_KEY);
                        //判断缓存,存在就取消请求
                        if (titleBean != null) {
                            onNext(titleBean);
                            mDisposable.dispose();
                        }
                    }

                    @Override
                    public void onNext(TitleBean value) {
                        ACcheManager.putObjectBean(BaseApplication.getContext(), ConstantUtil.STITLE_KEY, value, ACache.TIME_DAY);
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
