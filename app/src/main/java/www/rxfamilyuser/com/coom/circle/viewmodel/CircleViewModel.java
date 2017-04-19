package www.rxfamilyuser.com.coom.circle.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;

import com.blankj.utilcode.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.circle.Bean.CircleBean;
import www.rxfamilyuser.com.coom.circle.adapter.CircleAdapter;
import www.rxfamilyuser.com.coom.circle.netcontrol.impl.CircleControlImpl;
import www.rxfamilyuser.com.coom.circle.view.CircleFragment;
import www.rxfamilyuser.com.databinding.FragmentCircleBinding;

/**
 * Created by ali on 2017/2/23.
 */

public class CircleViewModel extends BaseModel<FragmentCircleBinding, CircleControlImpl> {


    public ObservableInt mLayoutId = new ObservableInt(R.layout.item_circle_text);
    public ObservableArrayList<CircleBean.DataBean> mDataList = new ObservableArrayList<>();
    public CircleAdapter mAdapter = new CircleAdapter();

    private CircleFragment circleFragment;

    @Override
    public void onCreate() {
        super.onCreate();
        circleFragment = (CircleFragment) UI;
    }

    @Override
    public void onBeforeRequest(int tag) {

    }

    @Override
    public void onSuccess(Object bean, int tag) {
        switch (tag) {
            case 1:
                CircleBean circleBean = (CircleBean) bean;
                if (circleBean.getCode() != 0) {
                    if (circleFragment.getmPage() == 1) {
                        mDataList.clear();
                    }
                    mDataList.addAll(circleBean.getData());
                } else {
                    ToastUtils.showShortToast(circleBean.getMessage());
                }
                mAdapter.notifyDataSetChanged();
                mBinder.xrCircle.loadMoreComplete();
                mBinder.srCircle.setRefreshing(false);
                break;
        }
    }

    @Override
    public void onError(String errorMsg) {
        mBinder.xrCircle.loadMoreComplete();
        mBinder.srCircle.setRefreshing(false);
    }

    public void getInvitationListData(int page) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("page", page);
        mControl.getInvitationListData(this, map, 1, "getInvitationData");
    }
}
