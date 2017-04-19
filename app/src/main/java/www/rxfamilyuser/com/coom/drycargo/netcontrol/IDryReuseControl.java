package www.rxfamilyuser.com.coom.drycargo.netcontrol;

import java.util.Map;

import www.rxfamilyuser.com.network.RequestCallBack;

/**
 * Created by ali on 2017/3/2.
 */

public interface IDryReuseControl {


    void getDryData(RequestCallBack callBack, Map<String, Integer> map, int tag,String name);
}
