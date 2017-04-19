package www.rxfamilyuser.com.coom.Login.bean;

import java.util.List;

/**
 * Created by ali on 2017/2/16.
 */

public class UserBean {


    /**
     * code : 1
     * message : 登录成功~~
     * data : [{"user_id":1,"user_phone":"18911790470","user_password":"123456","user_photo":"http://47.93.50.208:8080/con_image/image/image2.jpg","user_name":"杨颖","user_code":"789123"}]
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
         * user_id : 1
         * user_phone : 18911790470
         * user_password : 123456
         * user_photo : http://47.93.50.208:8080/con_image/image/image2.jpg
         * user_name : 杨颖
         * user_code : 789123
         */

        private int user_id;
        private String user_phone;
        private String user_password;
        private String user_photo;
        private String user_name;
        private String user_code;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

        public String getUser_password() {
            return user_password;
        }

        public void setUser_password(String user_password) {
            this.user_password = user_password;
        }

        public String getUser_photo() {
            return user_photo;
        }

        public void setUser_photo(String user_photo) {
            this.user_photo = user_photo;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_code() {
            return user_code;
        }

        public void setUser_code(String user_code) {
            this.user_code = user_code;
        }
    }
}
