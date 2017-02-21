package www.rxfamilyuser.com.coom.Login.netcontrol;

import java.util.Map;

import www.rxfamilyuser.com.network.RequestCallBack;

/**
 * Created by ali on 2017/2/20.
 */

public interface RegisterBiz {
    /**
     * 注册
     * @param callBack 回调
     * @param map 参数
     */
    void register(RequestCallBack callBack, Map<String, String> map);
}
