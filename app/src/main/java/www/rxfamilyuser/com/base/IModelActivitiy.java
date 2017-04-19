package www.rxfamilyuser.com.base;

import android.content.Context;
import android.databinding.ViewDataBinding;

/**
 * Created by ali on 2017/2/23.
 */

public interface IModelActivitiy<T extends ViewDataBinding> {

    T getBinder();

    /**
     * 获取content
     *
     * @return content上下文
     */
    Context getConText();

    /**
     * 加载ProgressDialog
     */
     void showWaitDialog();

    /**
     * 隐藏ProgressDialog
     */
     void hideWaitDialog();

}
