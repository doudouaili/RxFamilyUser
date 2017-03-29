package www.rxfamilyuser.com.coom.drycargo.bean;

import java.util.List;

import www.rxfamilyuser.com.base.BaseBean;

/**
 * Created by ali on 2017/3/29.
 */

public class InforCommentBean extends BaseBean{


    /**
     * code : 1
     * message : 数据查询成功~~
     * data : [{"com_id":1,"infor_id":1,"com_content":"阿萨德京津冀阿斯蒂","user_id":2,"com_type":1,"userBean":{"user_id":2,"user_phone":"18911790470","user_password":"123456","user_photo":null,"user_name":"Ali","user_code":"9282"}},{"com_id":3,"infor_id":1,"com_content":"水电费是否连接","user_id":1,"com_type":1,"userBean":{"user_id":1,"user_phone":"18911790470","user_password":"132","user_photo":null,"user_name":"ALIIL","user_code":"213"}},{"com_id":4,"infor_id":1,"com_content":"阿浪的老是连","user_id":2,"com_type":1,"userBean":{"user_id":2,"user_phone":"18911790470","user_password":"123456","user_photo":null,"user_name":"Ali","user_code":"9282"}}]
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

    public static class DataBean extends BaseBean{
        /**
         * com_id : 1
         * infor_id : 1
         * com_content : 阿萨德京津冀阿斯蒂
         * user_id : 2
         * com_type : 1
         * userBean : {"user_id":2,"user_phone":"18911790470","user_password":"123456","user_photo":null,"user_name":"Ali","user_code":"9282"}
         */

        private int com_id;
        private int infor_id;
        private String com_content;
        private int user_id;
        private int com_type;

        private UserBeanBean userBean;
        private String com_time;
        public String getCom_time() {
            return com_time;
        }

        public void setCom_time(String com_time) {
            this.com_time = com_time;
        }

        public int getCom_id() {
            return com_id;
        }

        public void setCom_id(int com_id) {
            this.com_id = com_id;
        }

        public int getInfor_id() {
            return infor_id;
        }

        public void setInfor_id(int infor_id) {
            this.infor_id = infor_id;
        }

        public String getCom_content() {
            return com_content;
        }

        public void setCom_content(String com_content) {
            this.com_content = com_content;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getCom_type() {
            return com_type;
        }

        public void setCom_type(int com_type) {
            this.com_type = com_type;
        }

        public UserBeanBean getUserBean() {
            return userBean;
        }

        public void setUserBean(UserBeanBean userBean) {
            this.userBean = userBean;
        }

        public static class UserBeanBean extends BaseBean{
            /**
             * user_id : 2
             * user_phone : 18911790470
             * user_password : 123456
             * user_photo : null
             * user_name : Ali
             * user_code : 9282
             */

            private int user_id;
            private String user_phone;
            private String user_password;
            private Object user_photo;
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

            public Object getUser_photo() {
                return user_photo;
            }

            public void setUser_photo(Object user_photo) {
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
}
