package www.rxfamilyuser.com.coom.drycargo.bean;

import java.util.List;

import www.rxfamilyuser.com.base.BaseBean;

/**
 * Created by ali on 2017/3/26.
 */

public class HomeBean extends BaseBean {


    /**
     * code : 1
     * message : 水电费
     * data : [{"work_id":14,"work_type":1,"work_time":"2017 02-23 13:23","work_that":1,"expertBeanList":[{"expert_id":1,"expert_name":"张鸿洋","expert_img":"http://localhost:8080/image/zhy.jpg","expert_abstract":"精通JavaEE,Android,Javascript,HTML5,MySQL,Hadoop,Linux.","expert_from":"CSDN","wk_type":3},{"expert_id":2,"expert_name":"郭霖","expert_img":"http://localhost:8080/image/gl.jpg","expert_abstract":"Android软件开发工程师。从事Android开发工作四年，有着丰富的项目实战经验，负责及参与开发过多款移动应用与游戏，对Android系统架构及应用层开发有着深入的理解。2013年3月开始，在CSDN上发表Android技术相关博文，很快就获得了大量网友的好评。短短一年时间博客访问量超过50万次，评价近3000条。荣获CSDN认证专家，并被评选为2013年CSDN年度博客之星。2014年，他创作了《第一行代码\u2014\u2014Android》一书。郭霖现就职于蜗牛移动，继续从事Android开发工作。","expert_from":"CSDN","wk_type":3},{"expert_id":3,"expert_name":"罗东升","expert_img":"http://localhost:8080/image/lds.jpg","expert_abstract":"罗升阳（老罗），1984年出生，2007年毕业于浙江大学计算机系，取得学士学位，2010年毕业于上海交通大学计算机系，取得硕士学位。毕业后一直从事于互联网软件开发，并且致力于移动平台的研究，特别是对Android平台有深入的理解和研究。在国内知名IT技术社区CSDN上发表了一百多篇高质量的Android系统原创性文章，并且开设博客专栏\u2014\u2014《老罗的Android之旅》。积极与网友交流互动，深受大家喜爱，访问量一直居于前茅。同时，著有《Android系统源代码情景分析》一书。","expert_from":"CSDN","wk_type":3},{"expert_id":4,"expert_name":"马士兵","expert_img":"http://localhost:8080/image/msb.jpg","expert_abstract":"马士兵，河北辛集人，1999年毕业于清华大学，是知名的程序员和讲师。他先后在IBM、澳大利亚GoldenTech工作多年，历任程序员、TeamLeader、ProjectManager、CTO等职位，有过十几个大型项目的开发经验，并在中国科学院研究生院、北京交通大学、华中科技大学传授软件开发课程。他经验丰富，曾主持了多个软件项目的实施，开发和部署过多个中大型、软硬件结合的、集成性的项目，受到了社会各界的好评。","expert_from":"尚学堂","wk_type":3},{"expert_id":5,"expert_name":"赵洁琼","expert_img":"http://localhost:8080/image/zjq.jpg","expert_abstract":"1990年，赵洁琼出生于哈尔滨。2011年，赵洁琼通过人人校招，进入人人网实习，2012年从哈尔滨理工大学计算机科学与技术专业本科毕业后，赵洁琼直接留在公司，成为网站的前端工程师，从事网页界面的开发。参加工作后，在公司的摄影协会认识了男朋友李洋阳，李洋阳给她拍了很多生活照，每天在李洋阳的人人主页上发一张作为送给她的礼物，截至2013年，累积起来已经达到了260多张[1-2]  。","expert_from":"人人网","wk_type":3}],"inforBean":{"infor_id":1,"work_type":1,"infor_img":"http://localhost:8080/image/image1.jpg","infor_html":"https://www.jbtm.org//family//jthtml//20170323//article_4025.html","infor_commentNum":20,"infor_lookNum":12,"infor_like":1},"jokeBean":{"joke_id":1,"joke_from":"搜狐公众平台","joke_content":"从前，有一个程序员，他得到了一盏神灯。灯神答应实现他一个愿望。然后他向神灯许愿，希望在有生之年能写一个好项目。后来他得到了永生~","joke_img":"http://localhost:8080/image/zjq.jpg","joke_title":"永生话题"},"welfareBean":{"welfare_id":1,"welfare_img":"http://localhost:8080/image/image5.jpg","work_type":2}}]
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

    public static class DataBean  extends BaseBean {
        /**
         * work_id : 14
         * work_type : 1
         * work_time : 2017 02-23 13:23
         * work_that : 1
         * expertBeanList : [{"expert_id":1,"expert_name":"张鸿洋","expert_img":"http://localhost:8080/image/zhy.jpg","expert_abstract":"精通JavaEE,Android,Javascript,HTML5,MySQL,Hadoop,Linux.","expert_from":"CSDN","wk_type":3},{"expert_id":2,"expert_name":"郭霖","expert_img":"http://localhost:8080/image/gl.jpg","expert_abstract":"Android软件开发工程师。从事Android开发工作四年，有着丰富的项目实战经验，负责及参与开发过多款移动应用与游戏，对Android系统架构及应用层开发有着深入的理解。2013年3月开始，在CSDN上发表Android技术相关博文，很快就获得了大量网友的好评。短短一年时间博客访问量超过50万次，评价近3000条。荣获CSDN认证专家，并被评选为2013年CSDN年度博客之星。2014年，他创作了《第一行代码\u2014\u2014Android》一书。郭霖现就职于蜗牛移动，继续从事Android开发工作。","expert_from":"CSDN","wk_type":3},{"expert_id":3,"expert_name":"罗东升","expert_img":"http://localhost:8080/image/lds.jpg","expert_abstract":"罗升阳（老罗），1984年出生，2007年毕业于浙江大学计算机系，取得学士学位，2010年毕业于上海交通大学计算机系，取得硕士学位。毕业后一直从事于互联网软件开发，并且致力于移动平台的研究，特别是对Android平台有深入的理解和研究。在国内知名IT技术社区CSDN上发表了一百多篇高质量的Android系统原创性文章，并且开设博客专栏\u2014\u2014《老罗的Android之旅》。积极与网友交流互动，深受大家喜爱，访问量一直居于前茅。同时，著有《Android系统源代码情景分析》一书。","expert_from":"CSDN","wk_type":3},{"expert_id":4,"expert_name":"马士兵","expert_img":"http://localhost:8080/image/msb.jpg","expert_abstract":"马士兵，河北辛集人，1999年毕业于清华大学，是知名的程序员和讲师。他先后在IBM、澳大利亚GoldenTech工作多年，历任程序员、TeamLeader、ProjectManager、CTO等职位，有过十几个大型项目的开发经验，并在中国科学院研究生院、北京交通大学、华中科技大学传授软件开发课程。他经验丰富，曾主持了多个软件项目的实施，开发和部署过多个中大型、软硬件结合的、集成性的项目，受到了社会各界的好评。","expert_from":"尚学堂","wk_type":3},{"expert_id":5,"expert_name":"赵洁琼","expert_img":"http://localhost:8080/image/zjq.jpg","expert_abstract":"1990年，赵洁琼出生于哈尔滨。2011年，赵洁琼通过人人校招，进入人人网实习，2012年从哈尔滨理工大学计算机科学与技术专业本科毕业后，赵洁琼直接留在公司，成为网站的前端工程师，从事网页界面的开发。参加工作后，在公司的摄影协会认识了男朋友李洋阳，李洋阳给她拍了很多生活照，每天在李洋阳的人人主页上发一张作为送给她的礼物，截至2013年，累积起来已经达到了260多张[1-2]  。","expert_from":"人人网","wk_type":3}]
         * inforBean : {"infor_id":1,"work_type":1,"infor_img":"http://localhost:8080/image/image1.jpg","infor_html":"https://www.jbtm.org//family//jthtml//20170323//article_4025.html","infor_commentNum":20,"infor_lookNum":12,"infor_like":1}
         * jokeBean : {"joke_id":1,"joke_from":"搜狐公众平台","joke_content":"从前，有一个程序员，他得到了一盏神灯。灯神答应实现他一个愿望。然后他向神灯许愿，希望在有生之年能写一个好项目。后来他得到了永生~","joke_img":"http://localhost:8080/image/zjq.jpg","joke_title":"永生话题"}
         * welfareBean : {"welfare_id":1,"welfare_img":"http://localhost:8080/image/image5.jpg","work_type":2}
         */
        private int work_id;
        private int work_type;
        private String work_time;
        private int work_that;
        private InforBeanBean inforBean;
        private JokeBeanBean jokeBean;
        private WelfareBeanBean welfareBean;
        public ExpertBean expertBean;

        public int getWork_id() {
            return work_id;
        }

        public void setWork_id(int work_id) {
            this.work_id = work_id;
        }

        public int getWork_type() {
            return work_type;
        }

        public void setWork_type(int work_type) {
            this.work_type = work_type;
        }

        public String getWork_time() {
            return work_time;
        }

        public void setWork_time(String work_time) {
            this.work_time = work_time;
        }

        public int getWork_that() {
            return work_that;
        }

        public void setWork_that(int work_that) {
            this.work_that = work_that;
        }

        public InforBeanBean getInforBean() {
            return inforBean;
        }

        public void setInforBean(InforBeanBean inforBean) {
            this.inforBean = inforBean;
        }

        public JokeBeanBean getJokeBean() {
            return jokeBean;
        }

        public void setJokeBean(JokeBeanBean jokeBean) {
            this.jokeBean = jokeBean;
        }

        public WelfareBeanBean getWelfareBean() {
            return welfareBean;
        }

        public void setWelfareBean(WelfareBeanBean welfareBean) {
            this.welfareBean = welfareBean;
        }

        public void setExpertBean(ExpertBean expertBean) {
            this.expertBean = expertBean;
        }

        public ExpertBean getExpertBean() {
            return expertBean;
        }

        public static class InforBeanBean  extends BaseBean{
            /**
             * infor_id : 1
             * work_type : 1
             * infor_img : http://localhost:8080/image/image1.jpg
             * infor_html : https://www.jbtm.org//family//jthtml//20170323//article_4025.html
             * infor_commentNum : 20
             * infor_lookNum : 12
             * infor_like : 1
             */

            private int infor_id;
            private int work_type;
            private String infor_img;
            private String infor_html;
            private String infor_commentNum;
            private String infor_lookNum;
            private int infor_like;
            private String infor_title;
            private String infor_content;

            public String getInfor_content() {
                return infor_content;
            }

            public String getInfor_title() {
                return infor_title;
            }

            public void setInfor_content(String infor_content) {
                this.infor_content = infor_content;
            }

            public void setInfor_title(String infor_title) {
                this.infor_title = infor_title;
            }

            public int getInfor_id() {
                return infor_id;
            }

            public void setInfor_id(int infor_id) {
                this.infor_id = infor_id;
            }

            public int getWork_type() {
                return work_type;
            }

            public void setWork_type(int work_type) {
                this.work_type = work_type;
            }

            public String getInfor_img() {
                return infor_img;
            }

            public void setInfor_img(String infor_img) {
                this.infor_img = infor_img;
            }

            public String getInfor_html() {
                return infor_html;
            }

            public void setInfor_html(String infor_html) {
                this.infor_html = infor_html;
            }

            public String getInfor_commentNum() {
                return infor_commentNum;
            }

            public void setInfor_commentNum(String infor_commentNum) {
                this.infor_commentNum = infor_commentNum;
            }

            public String getInfor_lookNum() {
                return infor_lookNum;
            }

            public void setInfor_lookNum(String infor_lookNum) {
                this.infor_lookNum = infor_lookNum;
            }

            public int getInfor_like() {
                return infor_like;
            }

            public void setInfor_like(int infor_like) {
                this.infor_like = infor_like;
            }
        }

        public static class JokeBeanBean  extends BaseBean{
            /**
             * joke_id : 1
             * joke_from : 搜狐公众平台
             * joke_content : 从前，有一个程序员，他得到了一盏神灯。灯神答应实现他一个愿望。然后他向神灯许愿，希望在有生之年能写一个好项目。后来他得到了永生~
             * joke_img : http://localhost:8080/image/zjq.jpg
             * joke_title : 永生话题
             */

            private int joke_id;
            private String joke_from;
            private String joke_content;
            private String joke_img;
            private String joke_title;
            private String joke_type;
            private String joke_html;
            public String getJoke_html() {
                return joke_html;
            }

            public void setJoke_type(String joke_type) {
                this.joke_type = joke_type;
            }

            public String getJoke_type() {
                return joke_type;
            }

            public void setJoke_html(String joke_html) {
                this.joke_html = joke_html;
            }

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
        }

        public static class WelfareBeanBean  extends BaseBean{
            /**
             * welfare_id : 1
             * welfare_img : http://localhost:8080/image/image5.jpg
             * work_type : 2
             */

            private int welfare_id;
            private String welfare_img;
            private int work_type;


            public int getWelfare_id() {
                return welfare_id;
            }

            public void setWelfare_id(int welfare_id) {
                this.welfare_id = welfare_id;
            }

            public String getWelfare_img() {
                return welfare_img;
            }

            public void setWelfare_img(String welfare_img) {
                this.welfare_img = welfare_img;
            }

            public int getWork_type() {
                return work_type;
            }

            public void setWork_type(int work_type) {
                this.work_type = work_type;
            }
        }

        public static class ExpertBean  extends BaseBean{
            /**
             * expert_id : 1
             * expert_name : 张鸿洋
             * expert_img : http://localhost:8080/image/zhy.jpg
             * expert_abstract : 精通JavaEE,Android,Javascript,HTML5,MySQL,Hadoop,Linux.
             * expert_from : CSDN
             * wk_type : 3
             */

            private int expert_id;
            private String expert_name;
            private String expert_img;
            private String expert_abstract;
            private String expert_from;
            private int wk_type;

            public int getExpert_id() {
                return expert_id;
            }

            public void setExpert_id(int expert_id) {
                this.expert_id = expert_id;
            }

            public String getExpert_name() {
                return expert_name;
            }

            public void setExpert_name(String expert_name) {
                this.expert_name = expert_name;
            }

            public String getExpert_img() {
                return expert_img;
            }

            public void setExpert_img(String expert_img) {
                this.expert_img = expert_img;
            }

            public String getExpert_abstract() {
                return expert_abstract;
            }

            public void setExpert_abstract(String expert_abstract) {
                this.expert_abstract = expert_abstract;
            }

            public String getExpert_from() {
                return expert_from;
            }

            public void setExpert_from(String expert_from) {
                this.expert_from = expert_from;
            }

            public int getWk_type() {
                return wk_type;
            }

            public void setWk_type(int wk_type) {
                this.wk_type = wk_type;
            }
        }
    }
}
