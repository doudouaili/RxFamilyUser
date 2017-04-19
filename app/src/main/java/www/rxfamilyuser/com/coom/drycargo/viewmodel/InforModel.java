package www.rxfamilyuser.com.coom.drycargo.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;

import com.blankj.utilcode.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.drycargo.adapter.CommentAdapter;
import www.rxfamilyuser.com.coom.drycargo.bean.InforCommentBean;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.impl.InforControlImpl;
import www.rxfamilyuser.com.coom.drycargo.view.InforActivity;
import www.rxfamilyuser.com.databinding.ActivityInforBinding;

/**
 * Created by ali on 2017/3/15.
 */

public class InforModel extends BaseModel<ActivityInforBinding, InforControlImpl> {

    public CommentAdapter mCommAdapter = new CommentAdapter();
    public ObservableArrayList<InforCommentBean.DataBean> mCommList = new ObservableArrayList<>();
    public ObservableInt mCommLayout = new ObservableInt(R.layout.item_comment);
    private InforActivity inforActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        inforActivity = (InforActivity) UI;
    }

    @Override
    public void onBeforeRequest(int tag) {

    }

    @Override
    public void onSuccess(Object bean, int tag) {
        switch (tag) {
            case 1:
                InforCommentBean inforCommentBean = (InforCommentBean) bean;
                if (inforCommentBean.getCode() != 0) {
                    if (inforActivity.getmPage() == 1) {
                        mCommList.clear();
                    }
                    mCommList.addAll(inforCommentBean.getData());
                } else {
                    ToastUtils.showShortToast(inforCommentBean.getMessage());
                }
                mCommAdapter.notifyDataSetChanged();
                mBinder.xrView.loadMoreComplete();
                mBinder.srLayout.setRefreshing(false);
                break;
        }
    }

    @Override
    public void onError(String errorMsg) {

    }

    /**
     * 获取专家详情
     *
     * @param exerptId
     */
    public void getExpert(int exerptId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("expertId", exerptId);
        mControl.findExpert(this, map, 2,"findExertId");
    }

    /**
     * 获取资讯评论
     *
     * @param mInforId
     * @param mPage
     */
    public void getCommentData(int mInforId, int mPage) {
        Map<String, Integer> map = new HashMap<>();
        map.put("commentId", mInforId);
        map.put("page", mPage);
        mControl.getCommentData(this, map, 1,"getCommentData");

    }
}
