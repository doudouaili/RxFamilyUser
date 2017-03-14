package www.rxfamilyuser.com.coom.drycargo.bean;

import java.util.List;

import www.rxfamilyuser.com.base.BaseBean;

/**
 * Created by ali on 2017/3/14.
 */

public class TitleBean extends BaseBean {
    /**
     * code : 1
     * msg : 查询成功
     * result : ["Retrofit","RxJava2系列","Android框架","Android源码","Android架构","自定义View"]
     */

    private int code;
    private String msg;
    private List<String> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
