package www.rxfamilyuser.com.coom.drycargo.adapter;

import android.databinding.ViewDataBinding;

import www.rxfamilyuser.com.base.BaseRecyclerViewAdapter;
import www.rxfamilyuser.com.coom.drycargo.bean.DryReuseBean;
import www.rxfamilyuser.com.databinding.ReuseItemBinding;

/**
 * Created by ali on 2017/3/3.
 */

public class DryReuseAdapter extends BaseRecyclerViewAdapter<DryReuseBean.ResultBean> {

    @Override
    public void fillData(ViewDataBinding vdBinding, int position) {
        ReuseItemBinding binding = (ReuseItemBinding) vdBinding;
        binding.setResultBean(mDataList.get(position));
    }
}
