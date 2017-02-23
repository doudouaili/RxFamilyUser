package www.rxfamilyuser.com.base;

import io.reactivex.disposables.Disposable;

/**
 * Created by ali on 2017/2/17.
 */

public class BaseNetControl implements IBaseControl {
    public Disposable mDisposable = null;

    /**
     * 销毁
     */
    @Override
    public void disposableCancel() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}
