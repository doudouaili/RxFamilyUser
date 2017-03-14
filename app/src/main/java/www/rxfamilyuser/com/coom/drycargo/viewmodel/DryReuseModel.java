package www.rxfamilyuser.com.coom.drycargo.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;

import com.blankj.utilcode.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.drycargo.adapter.DryReuseAdapter;
import www.rxfamilyuser.com.coom.drycargo.bean.DryReuseBean;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.impl.DryReuseControlImpl;
import www.rxfamilyuser.com.coom.drycargo.view.DryReuseFragment;
import www.rxfamilyuser.com.databinding.FragmentDryReuseBinding;

/**
 * Created by ali on 2017/3/2.
 */

public class DryReuseModel extends BaseModel<FragmentDryReuseBinding, DryReuseControlImpl> {
    public ObservableArrayList<DryReuseBean.ResultBean> mDataList = new ObservableArrayList();
    public ObservableInt mLayoutId = new ObservableInt(R.layout.reuse_item);
    public DryReuseAdapter mReuseAdapter = new DryReuseAdapter();
    private DryReuseFragment dryReuseFragment;

    @Override
    public void onCreate() {
        super.onCreate();
        dryReuseFragment = (DryReuseFragment) UI;
    }

    @Override
    public void onBeforeRequest(int tag) {

    }

    @Override
    public void onSuccess(Object bean, int tag) {
        DryReuseBean dryReuseBean = (DryReuseBean) bean;
        if (dryReuseBean.getCode() == 1) {
            if (dryReuseFragment.getmPage() == 1) {
                mDataList.clear();
            }
            mDataList.addAll(dryReuseBean.getResult());

        } else {
            ToastUtils.showShortToast(dryReuseBean.getMsg());

        }
        mReuseAdapter.notifyDataSetChanged();
        mBinder.xrView.loadMoreComplete();
        mBinder.srLayout.setRefreshing(false);
    }

    @Override
    public void onError(String errorMsg) {

        mBinder.xrView.loadMoreComplete();
        mBinder.srLayout.setRefreshing(false);
    }

    /**
     * 获取数据
     *
     * @param type 资讯类型
     * @param page 页数
     */
    public void getDryData(int type, int page) {
        Map<String, Integer> map = new HashMap<>();
        map.put("type", type);
        map.put("page", page);
        mControl.getDryData(this, map, 1);
    }
}
