package www.rxfamilyuser.com.coom.find.netcontrol;

import java.util.Map;

import www.rxfamilyuser.com.network.RequestCallBack;

/**
 * Created by ali on 2017/2/23.
 */

public interface IMessageControl {
    void getMessageData(RequestCallBack requestCallBack, Map<String, Integer> map, int tag,String name);
}
