package www.rxfamilyuser.com.network;

/**
 * Created by ali on 2017/2/16.
 */

public interface RequestCallBack {

    void beforeRequest(int tag);

    void success(Object data, int tag);

    void error(String errorMsg);
}
