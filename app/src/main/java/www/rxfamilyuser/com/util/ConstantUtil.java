package www.rxfamilyuser.com.util;

/**
 * Created by ali on 2017/2/17.
 * 常量类
 */

public class ConstantUtil {
    /**
     * 设缓存有效期为两天
     */
    public static final long SCACHE_STALE_SEC = 60 * 60 * 24 * 2;

    /**
     * 查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
     * max-stale 指示客户机可以接收超出超时期间的响应消息。如果指定max-stale消息的值，那么客户机可接收超出超时期指定值之内的响应消息。
     */
    public static final String SCACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + SCACHE_STALE_SEC;

    /**
     * 查询网络的Cache-Control设置，头部Cache-Control设为max-age=0
     * (假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)时则不会使用缓存而请求服务器
     */
    public static final String SCACHE_CONTROL_AGE = "max-age=0";

    /**
     * share官方appkey
     */
    public static final String SMOB_APP_kEY = "1b64f77b855de";
    /**
     * share官方appSecret
     */
    public static final String SMOB_APP_SECRET = "20587190c237f7eaa85873ee49ebdc21";

    //--------Acche缓存key---->>>>>>>>>
    /**
     * 标题
     */
    public static final String STITLE_KEY ="title";

    public static final String SNES_KEY ="news";
}
