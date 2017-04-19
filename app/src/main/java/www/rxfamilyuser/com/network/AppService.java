package www.rxfamilyuser.com.network;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import www.rxfamilyuser.com.coom.Login.bean.UserBean;
import www.rxfamilyuser.com.coom.circle.Bean.CircleBean;
import www.rxfamilyuser.com.coom.drycargo.bean.HomeBean;
import www.rxfamilyuser.com.coom.drycargo.bean.InforCommentBean;
import www.rxfamilyuser.com.coom.drycargo.bean.JokeListBean;
import www.rxfamilyuser.com.coom.drycargo.bean.TitleBean;
import www.rxfamilyuser.com.coom.find.bean.MessageBean;

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
    @POST("restful/register")
    Observable<UserBean> register(@Header("Cache-Control") String cacheControl, @FieldMap Map<String, String> map);

    /**
     * 找回密码
     *
     * @param cacheControl
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("restful/findPass")
    Observable<UserBean> findPassWord(@Header("Cache-Control") String cacheControl, @FieldMap Map<String, String> map);

    /**
     * 登录
     *
     * @param cacheControl
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("restful/login")
    Observable<UserBean> login(@Header("Cache-Control") String cacheControl, @FieldMap Map<String, String> map);

    /**
     * 资讯首页
     *
     * @param cacheControl
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("concentrantion/Infor")
    Observable<HomeBean> infor(@Header("Cache-Control") String cacheControl, @FieldMap Map<String, Integer> map);

    /**
     * 获取干货标题
     *
     * @param cacheControl
     * @return
     */
    @FormUrlEncoded
    @POST("concentrantion/LayoutTitle")
    Observable<TitleBean> getTitle(@Header("Cache-Control") String cacheControl, @FieldMap Map<String, Integer> map);

    /**
     * 获取专家
     *
     * @param cacheControl
     * @return
     */
    @FormUrlEncoded
    @POST("concentrantion/FindExpert")
    Observable<HomeBean.DataBean.ExpertBean> findExertId(@Header("Cache-Control") String cacheControl, @FieldMap Map<String, Integer> map);

    /**
     * 获取评论列表
     *
     * @param cacheControl
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("concentrantion/InforComment")
    Observable<InforCommentBean> getCommentData(@Header("Cache-Control") String cacheControl, @FieldMap Map<String, Integer> map);

    /**
     * 获取单个乐趣该评论
     *
     * @param cacheControl
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("concentrantion/JokeOne")
    Observable<JokeListBean> getJokeCommentData(@Header("Cache-Control") String cacheControl, @FieldMap Map<String, Integer> map);

    /**
     * 获取互动中心列表
     *
     * @param cacheControl
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("invitation/invita")
    Observable<CircleBean> getInvitationData(@Header("Cache-Control") String cacheControl, @FieldMap Map<String, Integer> map);

    /**
     * 消息
     *
     * @param cacheControl
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("message/message")
    Observable<MessageBean> getMessageData(@Header("Cache-Control") String cacheControl, @FieldMap Map<String, Integer> map);
}
