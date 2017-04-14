package www.rxfamilyuser.com.coom.drycargo.bean;

import java.util.List;

import www.rxfamilyuser.com.base.BaseBean;

/**
 * Created by ali on 2017/3/30.
 */

public class JokeListBean extends BaseBean{
    /**
     * code : 1
     * message : 数据查询成功~~
     * data : [{"joke_id":2,"joke_from":"360dco","joke_content":"调css是这样的","joke_img":"http://112.74.104.213:8080/gif/78790641_1.gif","joke_title":"调css是这样的","joke_type":"1","joke_html":"http://112.74.104.213:8080/www.concentration.com/html/img/zjq.jpg/html/joke.html","comBean":[{"jokeCom_id":5,"joke_id":2,"user_id":1,"jokeCom_type":1,"jokeCom_time":"2017-03-30 15:56:21","jokeCom_content":"按实际了大家圣诞节阿拉斯加的喀斯大林圣诞节","userBean":{"user_id":1,"user_phone":"18911790470","user_password":"123456","user_photo":"http://112.74.104.213:8080/www.concentration.com/html/img/image2.jpg","user_name":"杨颖","user_code":"789123"}},{"jokeCom_id":6,"joke_id":2,"user_id":1,"jokeCom_type":1,"jokeCom_time":"2017-03-30 15:56:21","jokeCom_content":"阿斯达,是的,z.xc.mzxmcm,,xc","userBean":{"user_id":1,"user_phone":"18911790470","user_password":"123456","user_photo":"http://112.74.104.213:8080/www.concentration.com/html/img/image2.jpg","user_name":"杨颖","user_code":"789123"}}]}]
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
         * joke_id : 2
         * joke_from : 360dco
         * joke_content : 调css是这样的
         * joke_img : http://112.74.104.213:8080/gif/78790641_1.gif
         * joke_title : 调css是这样的
         * joke_type : 1
         * joke_html : http://112.74.104.213:8080/www.concentration.com/html/img/zjq.jpg/html/joke.html
         * comBean : [{"jokeCom_id":5,"joke_id":2,"user_id":1,"jokeCom_type":1,"jokeCom_time":"2017-03-30 15:56:21","jokeCom_content":"按实际了大家圣诞节阿拉斯加的喀斯大林圣诞节","userBean":{"user_id":1,"user_phone":"18911790470","user_password":"123456","user_photo":"http://112.74.104.213:8080/www.concentration.com/html/img/image2.jpg","user_name":"杨颖","user_code":"789123"}},{"jokeCom_id":6,"joke_id":2,"user_id":1,"jokeCom_type":1,"jokeCom_time":"2017-03-30 15:56:21","jokeCom_content":"阿斯达,是的,z.xc.mzxmcm,,xc","userBean":{"user_id":1,"user_phone":"18911790470","user_password":"123456","user_photo":"http://112.74.104.213:8080/www.concentration.com/html/img/image2.jpg","user_name":"杨颖","user_code":"789123"}}]
         */

        private int joke_id;
        private String joke_from;
        private String joke_content;
        private String joke_img;
        private String joke_title;
        private String joke_type;
        private String joke_html;
        private List<ComBeanBean> comBean;

        public int getJoke_id() {
            return joke_id;
        }

        public void setJoke_id(int joke_id) {
            this.joke_id = joke_id;
        }

        public String getJoke_from() {
            return joke_from;
        }

        public void setJoke_from(String joke_from) {
            this.joke_from = joke_from;
        }

        public String getJoke_content() {
            return joke_content;
        }

        public void setJoke_content(String joke_content) {
            this.joke_content = joke_content;
        }

        public String getJoke_img() {
            return joke_img;
        }

        public void setJoke_img(String joke_img) {
            this.joke_img = joke_img;
        }

        public String getJoke_title() {
            return joke_title;
        }

        public void setJoke_title(String joke_title) {
            this.joke_title = joke_title;
        }

        public String getJoke_type() {
            return joke_type;
        }

        public void setJoke_type(String joke_type) {
            this.joke_type = joke_type;
        }

        public String getJoke_html() {
            return joke_html;
        }

        public void setJoke_html(String joke_html) {
            this.joke_html = joke_html;
        }

        public List<ComBeanBean> getComBean() {
            return comBean;
        }

        public void setComBean(List<ComBeanBean> comBean) {
            this.comBean = comBean;
        }

        public static class ComBeanBean extends BaseBean{
            /**
             * jokeCom_id : 5
             * joke_id : 2
             * user_id : 1
             * jokeCom_type : 1
             * jokeCom_time : 2017-03-30 15:56:21
             * jokeCom_content : 按实际了大家圣诞节阿拉斯加的喀斯大林圣诞节
             * userBean : {"user_id":1,"user_phone":"18911790470","user_password":"123456","user_photo":"http://112.74.104.213:8080/www.concentration.com/html/img/image2.jpg","user_name":"杨颖","user_code":"789123"}
             */

            private int jokeCom_id;
            private int joke_id;
            private int user_id;
            private int jokeCom_type;
            private String jokeCom_time;
            private String jokeCom_content;
            private UserBeanBean userBean;

            public int getJokeCom_id() {
                return jokeCom_id;
            }

            public void setJokeCom_id(int jokeCom_id) {
                this.jokeCom_id = jokeCom_id;
            }

            public int getJoke_id() {
                return joke_id;
            }

            public void setJoke_id(int joke_id) {
                this.joke_id = joke_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getJokeCom_type() {
                return jokeCom_type;
            }

            public void setJokeCom_type(int jokeCom_type) {
                this.jokeCom_type = jokeCom_type;
            }

            public String getJokeCom_time() {
                return jokeCom_time;
            }

            public void setJokeCom_time(String jokeCom_time) {
                this.jokeCom_time = jokeCom_time;
            }

            public String getJokeCom_content() {
                return jokeCom_content;
            }

            public void setJokeCom_content(String jokeCom_content) {
                this.jokeCom_content = jokeCom_content;
            }

            public UserBeanBean getUserBean() {
                return userBean;
            }

            public void setUserBean(UserBeanBean userBean) {
                this.userBean = userBean;
            }

            public static class UserBeanBean extends BaseBean{
                /**
                 * user_id : 1
                 * user_phone : 18911790470
                 * user_password : 123456
                 * user_photo : http://112.74.104.213:8080/www.concentration.com/html/img/image2.jpg
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
    }
}
