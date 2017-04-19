package www.rxfamilyuser.com.coom.circle.netcontrol;

import java.util.Map;

import www.rxfamilyuser.com.network.RequestCallBack;

/**
 * Created by ali on 2017/2/23.
 */

public interface ICircleControl {

    void getInvitationListData(RequestCallBack callBack, Map<String, Integer> map, int i,String methodName);
}