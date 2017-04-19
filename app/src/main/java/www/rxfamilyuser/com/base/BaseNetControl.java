package www.rxfamilyuser.com.base;

import java.lang.reflect.Method;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import www.rxfamilyuser.com.network.RequestCallBack;
import www.rxfamilyuser.com.network.request.HttpRequestImpl;

/**
 * Created by ali on 2017/2/17.
 */

public class BaseNetControl implements IBaseControl {

    public Disposable mDisposable = null;

    /**
     * 销毁
     */
    @Override
    public void disposableCancel() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }

    /**
     * 普通post请求
     *
     * @param callBack   回调
     * @param map        参数
     * @param tag        请求tag
     * @param methodName 方法名字
     */
    public void postDataMap(final RequestCallBack callBack, Map<String, Integer> map, final int tag, String methodName) {
        callBack.beforeRequest(tag);

        HttpRequestImpl httpRequest = HttpRequestImpl.getInstance();
        Class<? extends HttpRequestImpl> httpClass = httpRequest.getClass();
        try {
            Method httpRequestdMethod = httpClass.getDeclaredMethod(methodName, Map.class);
            Observable<Object> invitationData = (Observable<Object>) httpRequestdMethod.invoke(httpRequest, map);
            invitationData.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Object>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            mDisposable = d;
                        }

                        @Override
                        public void onNext(Object value) {
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

        } catch (Exception e) {
            callBack.error(e.toString());
        }
    }


}
