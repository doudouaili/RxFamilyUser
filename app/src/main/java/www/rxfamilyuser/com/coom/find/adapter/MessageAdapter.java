package www.rxfamilyuser.com.coom.find.adapter;

import android.databinding.ViewDataBinding;
import android.view.View;

import www.rxfamilyuser.com.base.BaseRecyclerViewAdapter;
import www.rxfamilyuser.com.coom.find.bean.MessageBean;
import www.rxfamilyuser.com.databinding.ItemMessageBinding;
import www.rxfamilyuser.com.widget.OnRecyclerViewItemClickListener;

/**
 * Created by ali on 2017/4/13.
 */

public class MessageAdapter extends BaseRecyclerViewAdapter<MessageBean.DataBean> {

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    @Override
    public void fillData(ViewDataBinding vdBinding, final int position) {
        System.out.println(mDataList.get(position).getMes_icon());
        ItemMessageBinding binding = (ItemMessageBinding) vdBinding;
        binding.setModel(mDataList.get(position));

        //点击事件回调
        vdBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null)
                    mOnItemClickListener.onItemClick(v, position);
            }
        });

    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
