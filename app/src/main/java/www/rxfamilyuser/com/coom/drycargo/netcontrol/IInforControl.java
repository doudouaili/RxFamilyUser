package www.rxfamilyuser.com.coom.drycargo.netcontrol;

import java.util.Map;

import www.rxfamilyuser.com.network.RequestCallBack;

/**
 * Created by ali on 2017/3/15.
 */

public interface IInforControl {

    void findExpert(RequestCallBack callBack, Map<String, Integer> map, int tag,String name);

    void getCommentData(RequestCallBack callBack, Map<String, Integer> map, int i,String name);
}
