package www.rxfamilyuser.com.network.request;

import java.util.Map;

import io.reactivex.Observable;
import www.rxfamilyuser.com.coom.Login.bean.UserBean;
import www.rxfamilyuser.com.coom.circle.Bean.CircleBean;
import www.rxfamilyuser.com.coom.drycargo.bean.HomeBean;
import www.rxfamilyuser.com.coom.drycargo.bean.InforCommentBean;
import www.rxfamilyuser.com.coom.drycargo.bean.JokeListBean;
import www.rxfamilyuser.com.coom.drycargo.bean.TitleBean;
import www.rxfamilyuser.com.coom.find.bean.MessageBean;

/**
 * Created by ali on 2017/2/16.
 */

public interface IHttpRequest {
    /**
     * 注册接口
     *
     * @param map
     * @return
     */
    Observable<UserBean> register(Map<String, String> map);

    /**
     * 找回密码接口
     *
     * @param map
     * @return
     */
    Observable<UserBean> findPassWord(Map<String, String> map);

    /**
     * 注册接口
     *
     * @param map
     * @return
     */
    Observable<UserBean> login(Map<String, String> map);

    /**
     * 干货首页
     *
     * @param map
     * @return
     */
    Observable<HomeBean> infor(Map<String, Integer> map);


    /**
     * 获取干货标题
     *
     * @return
     */
    Observable<TitleBean> getTitle(Map<String, Integer> map);

    /**
     * 通过专家id查询专家
     *
     * @param map
     * @return
     */
    Observable<HomeBean.DataBean.ExpertBean> findExertId(Map<String, Integer> map);

    /**
     * 资讯评论
     *
     * @param map
     * @return
     */
    Observable<InforCommentBean> getCommentData(Map<String, Integer> map);

    /**
     * 获取单个乐趣和改评论
     *
     * @param map
     * @return
     */
    Observable<JokeListBean> getJokeCommentData(Map<String, Integer> map);

    /**
     * 互动中心
     *
     * @param map
     * @return
     */
    Observable<CircleBean> getInvitationData(Map<String, Integer> map);

    /**
     * 消息
     *
     * @param map
     * @return
     */
    Observable<MessageBean> getMessageData(Map<String, Integer> map);

}
