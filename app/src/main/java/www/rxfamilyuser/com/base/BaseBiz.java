package www.rxfamilyuser.com.base;

import io.reactivex.disposables.Disposable;

/**
 * Created by ali on 2017/2/17.
 */

public class BaseBiz {
    public Disposable mDisposable = null;

    /**
     * 销毁
     */
    public void disposableCancel() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}
