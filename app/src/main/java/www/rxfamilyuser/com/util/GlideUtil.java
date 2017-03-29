package www.rxfamilyuser.com.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.widget.GlideCircleTransform;
import www.rxfamilyuser.com.widget.GlideRoundTransform;

/**
 * Created by ali on 2017/3/29.
 */

public class GlideUtil {
    private static GlideUtil instance;

    public static GlideUtil getInstance() {
        if (instance == null) {
            synchronized (GlideUtil.class) {
                if (instance == null) {
                    instance = new GlideUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 加载普通图片
     *
     * @param context
     * @param obj       Glide支持加载的类型
     * @param imageView
     */
    public void loadNormalImage(Context context, Object obj, ImageView imageView) {
        if (obj != null) {
            Glide.with(context).load(obj).error(R.mipmap.image_def).placeholder(R.mipmap
                    .image_def).centerCrop().into(imageView);
        }
    }

    /**
     * 加载圆形图片
     *
     * @param context
     * @param obj       Glide支持加载的类型
     * @param imageView
     */
    public void loadCircleImage(Context context, Object obj, ImageView imageView) {
        if (obj != null) {
            RequestManager glideRequest;
            glideRequest = Glide.with(context);
            glideRequest.load(obj).
                    error(R.mipmap.default_user).placeholder(R.mipmap.default_user).transform
                    (new GlideCircleTransform(context)).into(imageView);
        }
    }

    /**
     * 加载圆角图片
     *
     * @param context
     * @param obj       Glide支持加载的类型
     * @param imageView
     */
    public void loadRoundCornerImage(Context context, Object obj, ImageView imageView) {
        if (obj != null) {
            RequestManager glideRequest;
            glideRequest = Glide.with(context);
            glideRequest.load(obj).
                    error(R.mipmap.image_def).placeholder(R.mipmap.image_def).transform
                    (new GlideRoundTransform(context)).into(imageView);
        }
    }

    /**
     * 加载(不需要占位图片、不需要错误图片)图片
     *
     * @param context
     * @param obj       Glide支持加载的类型
     * @param imageView
     */
    public void loadNoPlaceAndErrorImage(Context context, Object obj, ImageView imageView) {
        if (obj != null) {
            Glide.with(context).load(obj).centerCrop().into(imageView);
        }
    }

    /**
     * 加载GIF图片
     *
     * @param context
     * @param obj       Glide支持加载的类型
     * @param imageView
     */
    public void loadGifImage(Context context, Object obj, ImageView imageView) {
        Glide.with(context).load(obj).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.mipmap.image_def).error(R.mipmap.image_def).into(imageView);
    }

    //========================================================


    //========================================================


}
