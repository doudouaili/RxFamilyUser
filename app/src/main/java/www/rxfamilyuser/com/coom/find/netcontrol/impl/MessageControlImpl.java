package www.rxfamilyuser.com.coom.find.netcontrol.impl;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import www.rxfamilyuser.com.base.BaseNetControl;
import www.rxfamilyuser.com.coom.find.bean.MessageBean;
import www.rxfamilyuser.com.coom.find.netcontrol.IMessageControl;
import www.rxfamilyuser.com.network.RequestCallBack;
import www.rxfamilyuser.com.network.request.HttpRequestImpl;

/**
 * Created by ali on 2017/2/23.
 */

public class MessageControlImpl extends BaseNetControl implements IMessageControl {

    @Override
    public void getMessageData(final RequestCallBack callBack, Map<String, Integer> map, final int tag,String name) {
        postDataMap(callBack, map, tag, name);

    }
}
