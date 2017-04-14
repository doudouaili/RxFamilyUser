package www.rxfamilyuser.com.coom.circle.Bean;

import java.util.List;

/**
 * Created by ali on 2017/4/13.
 */

public class CircleBean {
    /**
     * code : 1
     * message : 数据查询成功~~
     * data : [{"invitation_id":1,"invitation_userId":1,"invitation_title":"为JPanel添加滚动条需要刷新窗口才能显示","invitation_content":"但是JPanel内组件就不显示了","invitation_img":"http://112.74.104.213:8080/www.concentration.com/html/img/image2.jpg","invitation_time":"2017-03-30 15:56:21","invitation_number":"22","invitation_type":"1","user_photo":"http://112.74.104.213:8080/www.concentration.com/html/img/image2.jpg","user_name":"杨颖"},{"invitation_id":2,"invitation_userId":2,"invitation_title":"Employeer.xml文件，用来放置一些映射，删除了Sql语句了","invitation_content":"如果这块没有看你第二个案例，接口编程。则直接EmployeerMapper.xml的namespace中没有注册对应的接口，会以一直报错。Type interface com.it.service.EmployeeMapper is not known to the MapperRegistry.","invitation_img":"http://112.74.104.213:8080/www.concentration.com/html/img/image2.jpg","invitation_time":"2017-03-30 15:56:21","invitation_number":"21","invitation_type":"1","user_photo":"http://112.74.104.213:8080/www.concentration.com/html/img/image4.jpg","user_name":"刘亦菲"}]
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
         * invitation_id : 1
         * invitation_userId : 1
         * invitation_title : 为JPanel添加滚动条需要刷新窗口才能显示
         * invitation_content : 但是JPanel内组件就不显示了
         * invitation_img : http://112.74.104.213:8080/www.concentration.com/html/img/image2.jpg
         * invitation_time : 2017-03-30 15:56:21
         * invitation_number : 22
         * invitation_type : 1
         * user_photo : http://112.74.104.213:8080/www.concentration.com/html/img/image2.jpg
         * user_name : 杨颖
         */

        private int invitation_id;
        private int invitation_userId;
        private String invitation_title;
        private String invitation_content;
        private String invitation_img;
        private String invitation_time;
        private String invitation_number;
        private int invitation_type;
        private String user_photo;
        private String user_name;

        public int getInvitation_id() {
            return invitation_id;
        }

        public void setInvitation_id(int invitation_id) {
            this.invitation_id = invitation_id;
        }

        public int getInvitation_userId() {
            return invitation_userId;
        }

        public void setInvitation_userId(int invitation_userId) {
            this.invitation_userId = invitation_userId;
        }

        public String getInvitation_title() {
            return invitation_title;
        }

        public void setInvitation_title(String invitation_title) {
            this.invitation_title = invitation_title;
        }

        public String getInvitation_content() {
            return invitation_content;
        }

        public void setInvitation_content(String invitation_content) {
            this.invitation_content = invitation_content;
        }

        public String getInvitation_img() {
            return invitation_img;
        }

        public void setInvitation_img(String invitation_img) {
            this.invitation_img = invitation_img;
        }

        public String getInvitation_time() {
            return invitation_time;
        }

        public void setInvitation_time(String invitation_time) {
            this.invitation_time = invitation_time;
        }

        public String getInvitation_number() {
            return invitation_number;
        }

        public void setInvitation_number(String invitation_number) {
            this.invitation_number = invitation_number;
        }

        public int getInvitation_type() {
            return invitation_type;
        }

        public void setInvitation_type(int invitation_type) {
            this.invitation_type = invitation_type;
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
    }
}
