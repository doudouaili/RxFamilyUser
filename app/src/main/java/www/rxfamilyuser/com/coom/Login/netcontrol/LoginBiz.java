package www.rxfamilyuser.com.coom.Login.netcontrol;

import java.util.Map;

import www.rxfamilyuser.com.network.RequestCallBack;

/**
 * Created by ali on 2017/2/17.
 */

public interface LoginBiz {

    void register(RequestCallBack callBack, Map<String, String> map);
}
