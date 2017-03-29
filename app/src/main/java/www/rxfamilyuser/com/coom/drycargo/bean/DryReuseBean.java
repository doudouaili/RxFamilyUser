package www.rxfamilyuser.com.coom.drycargo.bean;

import java.util.List;

/**
 * Created by ali on 2017/3/3.
 */

public class DryReuseBean {


    /**
     * code : 0
     * message : 数据查找成功~~
     * data : [{"id":1,"title":"这是一条测试数据","time":"2017-03-13 22:02:12.0","lookNum":1,"commenNum":0,"img":"http://c.hiphotos.baidu.com/image/h%3D200/sign=0545b39aa9345982da8ae2923cf5310b/d009b3de9c82d1585e277e5f840a19d8bd3e42b2.jpg","html":"http://120.27.33.15:3000/nes.html","type":1},{"id":4,"title":"ni","time":"2017-03-02 22:05:01.0","lookNum":100,"commenNum":0,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","html":"http://120.27.33.15:3000/nes.html","type":1},{"id":5,"title":"测试数据","time":"2017-03-02 22:05:01.0","lookNum":100,"commenNum":0,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","html":"http://120.27.33.15:3000/nes.html","type":1},{"id":6,"title":"测试数据","time":"2017-03-02 22:05:01.0","lookNum":100,"commenNum":0,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","html":"http://120.27.33.15:3000/nes.html","type":1},{"id":7,"title":"测试数据","time":"2017-03-02 22:05:01.0","lookNum":100,"commenNum":0,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","html":"http://120.27.33.15:3000/nes.html","type":1},{"id":8,"title":"测试数据","time":"2017-03-02 22:05:01.0","lookNum":100,"commenNum":0,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","html":"http://120.27.33.15:3000/nes.html","type":1},{"id":9,"title":"测试数据","time":"2017-03-02 22:05:01.0","lookNum":100,"commenNum":0,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","html":"http://120.27.33.15:3000/nes.html","type":1},{"id":10,"title":"测试数据","time":"2017-03-02 22:05:01.0","lookNum":100,"commenNum":0,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","html":"http://120.27.33.15:3000/nes.html","type":1},{"id":11,"title":"测试数据","time":"2017-03-02 22:05:01.0","lookNum":100,"commenNum":0,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","html":"http://120.27.33.15:3000/nes.html","type":1},{"id":12,"title":"测试数据","time":"2017-03-02 22:05:01.0","lookNum":100,"commenNum":0,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","html":"http://120.27.33.15:3000/nes.html","type":1}]
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
         * id : 1
         * title : 这是一条测试数据
         * time : 2017-03-13 22:02:12.0
         * lookNum : 1
         * commenNum : 0
         * img : http://c.hiphotos.baidu.com/image/h%3D200/sign=0545b39aa9345982da8ae2923cf5310b/d009b3de9c82d1585e277e5f840a19d8bd3e42b2.jpg
         * html : http://120.27.33.15:3000/nes.html
         * type : 1
         */

        private int id;
        private String title;
        private String time;
        private String lookNum;
        private String commenNum;
        private String img;
        private String html;
        private int type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getLookNum() {
            return lookNum;
        }

        public void setLookNum(String lookNum) {
            this.lookNum = lookNum;
        }

        public String getCommenNum() {
            return commenNum;
        }

        public void setCommenNum(String commenNum) {
            this.commenNum = commenNum;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
