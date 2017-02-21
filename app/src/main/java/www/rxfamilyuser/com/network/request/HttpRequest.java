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

    /**
     * 找回密码接口
     *
     * @param map
     * @return
     */
    Observable<UserBean> findPassWord(Map<String, String> map);

    /**
     * 注册接口
     *
     * @param map
     * @return
     */
    Observable<UserBean> login(Map<String, String> map);

}
