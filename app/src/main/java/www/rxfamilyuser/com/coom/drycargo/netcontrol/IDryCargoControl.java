package www.rxfamilyuser.com.coom.drycargo.netcontrol;

import java.util.Map;

import www.rxfamilyuser.com.network.RequestCallBack;

/**
 * Created by ali on 2017/2/23.
 */

public interface IDryCargoControl {

    void getTitile(RequestCallBack callBack, Map<String, Integer> map, int tag);
}
