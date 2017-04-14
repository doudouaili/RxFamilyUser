package www.rxfamilyuser.com.coom.find.bean;

import java.util.List;

/**
 * Created by ali on 2017/4/13.
 */

public class MessageBean {
    /**
     * code : 1
     * message : 数据查询成功~~
     * data : [{"mes_id":1,"mes_icon":"74.104.213:8080/www.concentration.com/html/img/reply_icon.png","mes_title":"回复我的","mes_newpm":"0","nes_number":"0"},{"mes_id":2,"mes_icon":"74.104.213:8080/www.concentration.com/html/img/box_icon.png","mes_title":"@我的","mes_newpm":"0","nes_number":"0"},{"mes_id":3,"mes_icon":"74.104.213:8080/www.concentration.com/html/img/broad_icon.png","mes_title":"系统广播","mes_newpm":"0","nes_number":"0"},{"mes_id":4,"mes_icon":"74.104.213:8080/www.concentration.com/html/img/stranger_icon.png","mes_title":"陌生人的消息","mes_newpm":"0","nes_number":"0"},{"mes_id":5,"mes_icon":"74.104.213:8080/www.concentration.com/html/img/bottle_icon.png","mes_title":"漂流瓶","mes_newpm":"0","nes_number":"0"}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * mes_id : 1
         * mes_icon : 74.104.213:8080/www.concentration.com/html/img/reply_icon.png
         * mes_title : 回复我的
         * mes_newpm : 0
         * nes_number : 0
         */

        private int mes_id;
        private String mes_icon;
        private String mes_title;
        private int mes_newpm;
        private String nes_number;

        public int getMes_id() {
            return mes_id;
        }

        public void setMes_id(int mes_id) {
            this.mes_id = mes_id;
        }

        public String getMes_icon() {
            return mes_icon;
        }

        public void setMes_icon(String mes_icon) {
            this.mes_icon = mes_icon;
        }

        public String getMes_title() {
            return mes_title;
        }

        public void setMes_title(String mes_title) {
            this.mes_title = mes_title;
        }

        public int getMes_newpm() {
            return mes_newpm;
        }

        public void setMes_newpm(int mes_newpm) {
            this.mes_newpm = mes_newpm;
        }

        public String getNes_number() {
            return nes_number;
        }

        public void setNes_number(String nes_number) {
            this.nes_number = nes_number;
        }
    }
}
