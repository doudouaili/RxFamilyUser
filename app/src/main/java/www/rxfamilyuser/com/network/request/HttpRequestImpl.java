package www.rxfamilyuser.com.network.request;

import android.support.annotation.NonNull;

import java.util.Map;

import io.reactivex.Observable;
import www.rxfamilyuser.com.base.BaseApplication;
import www.rxfamilyuser.com.coom.Login.bean.UserBean;
import www.rxfamilyuser.com.network.RetrofitManager;
import www.rxfamilyuser.com.util.ConstantUtil;
import www.rxfamilyuser.com.util.NetUtil;

/**
 * Created by ali on 2017/2/16.
 */

public class HttpRequestImpl implements HttpRequest {

    public static HttpRequestImpl httpRequest;

    public static HttpRequestImpl getInstance() {
        if (httpRequest == null) {
            httpRequest = new HttpRequestImpl();
            return httpRequest;
        }
        return httpRequest;
    }

    /**
     * 根据网络状况获取缓存的策略
     */
    @NonNull
    private String getCacheControl() {
        return NetUtil.isConnected(BaseApplication.getContext()) ? ConstantUtil.sCACHE_CONTROL_AGE : ConstantUtil.sCACHE_CONTROL_CACHE;
    }

    @Override
    public Observable<UserBean> register(Map<String, String> map) {
        return RetrofitManager.getInstance().getAppService().register(getCacheControl(), map);
    }
}
