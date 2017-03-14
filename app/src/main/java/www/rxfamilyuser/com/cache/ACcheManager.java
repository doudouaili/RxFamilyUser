package www.rxfamilyuser.com.cache;

import android.content.Context;

import java.io.Serializable;

/**
 * 缓存工具类
 * <p/>
 * 创建人:马鹏涛
 * 修改人:
 * 修改时间:
 * 修改内容:
 */
public class ACcheManager {

    private static ACache getACcheManager(Context context) {
        return ACache.get(context);
    }

    /**
     * 获取缓存
     *
     * @param context 上下文
     * @param tag     获取缓存的key
     * @return 缓存的对象
     */
    public static Object getObjectBean(Context context, String tag) {
        return getACcheManager(context).getAsObject(tag);
    }

    /**
     * put缓存对象
     *
     * @param context 上下文
     * @param key     缓存key
     * @param value   缓存的数据对象
     */
    public static void putObjectBean(Context context, String key, Serializable value) {
        getACcheManager(context).put(key, value, ACache.TIME_LOG);
    }

    /**
     * put缓存对象
     *
     * @param context 上下文
     * @param key     缓存key
     * @param value   缓存的数据对象
     * @param time   缓存的时长
     */
    public static void putObjectBean(Context context, String key, Serializable value, int time) {
        getACcheManager(context).put(key, value, time);
    }

    /**
     * 获取缓存
     *
     * @param context 上下文
     * @param tag     获取缓存的key
     * @return 缓存的对象
     */
    public static String getString(Context context, String tag) {
        return getACcheManager(context).getAsString(tag);
    }

    /**
     * put缓存对象
     *
     * @param context 上下文
     * @param key     缓存key
     * @param value   缓存的数据对象
     */
    public static void putString(Context context, String key, String value) {
        getACcheManager(context).put(key, value, ACache.TIME_LOG * 12);
    }

}
