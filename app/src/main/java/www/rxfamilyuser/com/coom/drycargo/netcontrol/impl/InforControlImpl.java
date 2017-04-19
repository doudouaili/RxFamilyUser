package www.rxfamilyuser.com.coom.drycargo.netcontrol.impl;

import java.util.Map;

import www.rxfamilyuser.com.base.BaseNetControl;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.IInforControl;
import www.rxfamilyuser.com.network.RequestCallBack;

/**
 * Created by ali on 2017/3/15.
 */

public class InforControlImpl extends BaseNetControl implements IInforControl {
    @Override
    public void findExpert(final RequestCallBack callBack, Map<String, Integer> map, final int tag, String name) {
        postDataMap(callBack, map, tag, name);
    }

    @Override
    public void getCommentData(final RequestCallBack callBack, Map<String, Integer> map, final int tag, String name) {
        postDataMap(callBack, map, tag, name);
    }
}
