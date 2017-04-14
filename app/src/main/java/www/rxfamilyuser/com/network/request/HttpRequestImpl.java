package www.rxfamilyuser.com.network.request;

import android.support.annotation.NonNull;

import java.util.Map;

import io.reactivex.Observable;
import www.rxfamilyuser.com.base.BaseApplication;
import www.rxfamilyuser.com.coom.Login.bean.UserBean;
import www.rxfamilyuser.com.coom.circle.Bean.CircleBean;
import www.rxfamilyuser.com.coom.drycargo.bean.HomeBean;
import www.rxfamilyuser.com.coom.drycargo.bean.InforCommentBean;
import www.rxfamilyuser.com.coom.drycargo.bean.JokeListBean;
import www.rxfamilyuser.com.coom.drycargo.bean.TitleBean;
import www.rxfamilyuser.com.coom.find.bean.MessageBean;
import www.rxfamilyuser.com.network.RetrofitManager;
import www.rxfamilyuser.com.util.ConstantUtil;
import www.rxfamilyuser.com.util.NetUtil;

/**
 * Created by ali on 2017/2/16.
 */

public class HttpRequestImpl implements IHttpRequest {

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
        return NetUtil.isConnected(BaseApplication.getContext()) ? ConstantUtil.SCACHE_CONTROL_AGE : ConstantUtil.SCACHE_CONTROL_CACHE;
    }

    @Override
    public Observable<UserBean> register(Map<String, String> map) {
        return RetrofitManager.getInstance().getAppService().register(getCacheControl(), map);
    }

    @Override
    public Observable<UserBean> findPassWord(Map<String, String> map) {
        return RetrofitManager.getInstance().getAppService().findPassWord(getCacheControl(), map);
    }

    @Override
    public Observable<UserBean> login(Map<String, String> map) {
        return RetrofitManager.getInstance().getAppService().login(getCacheControl(), map);
    }

    @Override
    public Observable<HomeBean> infor(Map<String, Integer> map) {
        return RetrofitManager.getInstance().getAppService().infor(getCacheControl(), map);
    }


    @Override
    public Observable<TitleBean> getTitle(Map<String, Integer> map) {
        return RetrofitManager.getInstance().getAppService().getTitle(getCacheControl(), map);
    }


    @Override
    public Observable<HomeBean.DataBean.ExpertBean> findExertId(Map<String, Integer> map) {
        return RetrofitManager.getInstance().getAppService().findExertId(getCacheControl(), map);
    }

    @Override
    public Observable<InforCommentBean> getCommentData(Map<String, Integer> map) {
        return RetrofitManager.getInstance().getAppService().getCommentData(getCacheControl(), map);
    }

    @Override
    public Observable<JokeListBean> getJokeCommentData(Map<String, Integer> map) {
        return RetrofitManager.getInstance().getAppService().getJokeCommentData(getCacheControl(), map);
    }

    @Override
    public Observable<CircleBean> getInvitationData(Map<String, Integer> map) {
        return RetrofitManager.getInstance().getAppService().getInvitationData(getCacheControl(), map);
    }

    @Override
    public Observable<MessageBean> getMessageData(Map<String, Integer> map) {

        return RetrofitManager.getInstance().getAppService().getMessageData(getCacheControl(), map);

    }

}
