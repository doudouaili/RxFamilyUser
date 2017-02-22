package www.rxfamilyuser.com.util;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;

import www.rxfamilyuser.com.R;

/**
 * Created by ali on 2017/2/21.
 */

public class DialogUtil {
    private Dialog pd; //Dialog对象


    public DialogUtil(Activity context) {
        pd = new Dialog(context, R.style.dialog);
        View view = LayoutInflater.from(context).inflate(
                R.layout.progressbar, null);
        pd.setContentView(view);
    }

    /**
     * 显示进度条
     */
    public void show() {
        if (pd != null) {
            pd.show();
        }

    }

    /**
     * 关闭进度条
     */
    public void dismiss() {
        if (pd != null) {
            pd.dismiss();
        }
    }

}
