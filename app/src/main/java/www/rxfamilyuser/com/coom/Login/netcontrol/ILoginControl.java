package www.rxfamilyuser.com.coom.Login.netcontrol;

import java.util.Map;

import www.rxfamilyuser.com.network.RequestCallBack;

/**
 * Created by ali on 2017/2/17.
 */

public interface ILoginControl {
    /**
     * 注册
     * @param callBack
     * @param map
     * @param tag
     */
    void login(RequestCallBack callBack, Map<String, String> map,int tag);
}
