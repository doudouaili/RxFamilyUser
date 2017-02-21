package www.rxfamilyuser.com.network.request;

import java.util.Map;

import io.reactivex.Observable;
import www.rxfamilyuser.com.coom.Login.bean.UserBean;

/**
 * Created by ali on 2017/2/16.
 */

public interface HttpRequest {
    /**
     * 注册接口
     *
     * @param map
     * @return
     */
    Observable<UserBean> register(Map<String, String> map);
}
