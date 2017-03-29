package www.rxfamilyuser.com.coom.drycargo.bean;

import java.util.List;

import www.rxfamilyuser.com.base.BaseBean;

/**
 * Created by ali on 2017/3/14.
 */

public class TitleBean extends BaseBean {

    /**
     * code : 1
     * message : 数据查找成功~~
     * data : ["Retrofit2","RxJava2系列","Android框架","Android源码","Android架构","自定义View"]
     */

    private int code;
    private String message;
    private List<String> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
