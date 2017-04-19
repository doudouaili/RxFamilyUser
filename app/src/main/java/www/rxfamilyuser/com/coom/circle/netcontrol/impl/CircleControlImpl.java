package www.rxfamilyuser.com.coom.circle.netcontrol.impl;

import java.util.Map;

import www.rxfamilyuser.com.base.BaseNetControl;
import www.rxfamilyuser.com.coom.circle.netcontrol.ICircleControl;
import www.rxfamilyuser.com.network.RequestCallBack;

/**
 * Created by ali on 2017/223.
 */

public class CircleControlImpl extends BaseNetControl implements ICircleControl {
    @Override
    public void getInvitationListData(final RequestCallBack callBack, Map<String, Integer> map,  int tag,String methodName) {
        postDataMap(callBack, map, tag, methodName);
    }
}
