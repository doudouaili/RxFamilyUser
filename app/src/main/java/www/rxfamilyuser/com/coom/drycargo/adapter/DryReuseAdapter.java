package www.rxfamilyuser.com.coom.drycargo.adapter;

import android.databinding.ViewDataBinding;
import android.view.View;

import www.rxfamilyuser.com.base.BaseRecyclerViewAdapter;
import www.rxfamilyuser.com.coom.drycargo.bean.DryReuseBean;
import www.rxfamilyuser.com.databinding.ReuseItemBinding;
import www.rxfamilyuser.com.widget.OnRecyclerViewItemClickListener;

/**
 * Created by ali on 2017/3/3.
 */

public class DryReuseAdapter extends BaseRecyclerViewAdapter<DryReuseBean.ResultBean> {
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;


    @Override
    public void fillData(ViewDataBinding vdBinding, final int position) {
        ReuseItemBinding binding = (ReuseItemBinding) vdBinding;
        binding.setResultBean(mDataList.get(position));

        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    //注意这里使用getTag方法获取数据
                    mOnItemClickListener.onItemClick(v,position);
                }
            }
        });
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
