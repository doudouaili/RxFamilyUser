package www.rxfamilyuser.com.coom.drycargo.netcontrol.impl;

import java.util.Map;

import www.rxfamilyuser.com.base.BaseNetControl;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.IDryReuseControl;
import www.rxfamilyuser.com.network.RequestCallBack;

/**
 * Created by ali on 2017/3/2.
 */

public class DryReuseControlImpl extends BaseNetControl implements IDryReuseControl {
    @Override
    public void getDryData(final RequestCallBack callBack, Map<String, Integer> map, final int tag, String name) {
        postDataMap(callBack, map, tag, name);
    }
}
