package www.rxfamilyuser.com.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import www.rxfamilyuser.com.R;

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
    public void loadImage(Context context, Object obj, ImageView imageView) {
        if (obj != null) {
            Glide.with(context).load(obj).asBitmap().error(R.mipmap.image_def).placeholder(R.mipmap
                    .image_def).centerCrop().into(imageView);
        }
    }
    /**
     * 加载普通图片
     *
     * @param context
     * @param obj       Glide支持加载的类型
     * @param imageView
     */
    public void loadImage(Context context, Object obj, ImageView imageView,int def) {
        if (obj != null) {
            Glide.with(context).load(obj).asBitmap().error(def).placeholder(def).centerCrop().into(imageView);
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
