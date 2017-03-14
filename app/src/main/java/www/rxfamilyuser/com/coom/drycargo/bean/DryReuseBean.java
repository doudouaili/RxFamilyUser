package www.rxfamilyuser.com.coom.drycargo.bean;

import java.util.List;

/**
 * Created by ali on 2017/3/3.
 */

public class DryReuseBean {

    /**
     * code : 1
     * msg : 查询成功
     * result : [{"commenNum":0,"html":"http://120.27.33.15:3000/nes.html","id":1,"img":"http://c.hiphotos.baidu.com/image/h%3D200/sign=0545b39aa9345982da8ae2923cf5310b/d009b3de9c82d1585e277e5f840a19d8bd3e42b2.jpg","lookNum":1,"time":"2017-03-13 22:02:12.0","title":"这是一条测试数据","type":1},{"commenNum":0,"html":"http://120.27.33.15:3000/nes.html","id":4,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","lookNum":100,"time":"2017-03-02 22:05:01.0","title":"ni","type":1},{"commenNum":0,"html":"http://120.27.33.15:3000/nes.html","id":5,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","lookNum":100,"time":"2017-03-02 22:05:01.0","title":"测试数据","type":1},{"commenNum":0,"html":"http://120.27.33.15:3000/nes.html","id":6,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","lookNum":100,"time":"2017-03-02 22:05:01.0","title":"测试数据","type":1},{"commenNum":0,"html":"http://120.27.33.15:3000/nes.html","id":7,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","lookNum":100,"time":"2017-03-02 22:05:01.0","title":"测试数据","type":1},{"commenNum":0,"html":"http://120.27.33.15:3000/nes.html","id":8,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","lookNum":100,"time":"2017-03-02 22:05:01.0","title":"测试数据","type":1},{"commenNum":0,"html":"http://120.27.33.15:3000/nes.html","id":9,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","lookNum":100,"time":"2017-03-02 22:05:01.0","title":"测试数据","type":1},{"commenNum":0,"html":"http://120.27.33.15:3000/nes.html","id":10,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","lookNum":100,"time":"2017-03-02 22:05:01.0","title":"测试数据","type":1},{"commenNum":0,"html":"http://120.27.33.15:3000/nes.html","id":11,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","lookNum":100,"time":"2017-03-02 22:05:01.0","title":"测试数据","type":1},{"commenNum":0,"html":"http://120.27.33.15:3000/nes.html","id":12,"img":"https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=3dc39862a0c27d1eba263cc42bd7adaf/b21bb051f8198618df86c5424eed2e738ad4e637.jpg","lookNum":100,"time":"2017-03-02 22:05:01.0","title":"测试数据","type":1}]
     */

    private int code;
    private String msg;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commenNum : 0
         * html : http://120.27.33.15:3000/nes.html
         * id : 1
         * img : http://c.hiphotos.baidu.com/image/h%3D200/sign=0545b39aa9345982da8ae2923cf5310b/d009b3de9c82d1585e277e5f840a19d8bd3e42b2.jpg
         * lookNum : 1
         * time : 2017-03-13 22:02:12.0
         * title : 这是一条测试数据
         * type : 1
         */

        private String commenNum;
        private String html;
        private int id;
        private String img;
        private String lookNum;
        private String time;
        private String title;
        private int type;

        public String getCommenNum() {
            return commenNum;
        }

        public void setCommenNum(String commenNum) {
            this.commenNum = commenNum;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLookNum() {
            return lookNum;
        }

        public void setLookNum(String lookNum) {
            this.lookNum = lookNum;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
