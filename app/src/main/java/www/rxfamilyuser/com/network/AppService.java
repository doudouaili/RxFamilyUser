package www.rxfamilyuser.com.network;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import www.rxfamilyuser.com.coom.Login.bean.UserBean;

/**
 * Created by ali on 2017/2/16.
 */

public interface AppService {
    /**
     * 注册接口
     * <P @FieldMap的post提交一定要加@FormUrlEncoded注解,不然报错
     *
     * @param cacheControl 缓存
     * @param map          参数
     * @return Observable
     * @Header("Cache-Control") String cacheControl是缓存 />
     */
    @FormUrlEncoded
    @POST("TomcatTest/DisplayHeader")
    Observable<UserBean> register(@Header("Cache-Control") String cacheControl, @FieldMap Map<String, String> map);

}
