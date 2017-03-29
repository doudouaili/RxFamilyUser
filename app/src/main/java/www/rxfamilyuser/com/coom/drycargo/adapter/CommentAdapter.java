package www.rxfamilyuser.com.coom.drycargo.adapter;

import android.databinding.ViewDataBinding;

import www.rxfamilyuser.com.base.BaseRecyclerViewAdapter;
import www.rxfamilyuser.com.coom.drycargo.bean.InforCommentBean;
import www.rxfamilyuser.com.databinding.ItemCommentBinding;

/**
 * Created by ali on 2017/3/29.
 */

public class CommentAdapter extends BaseRecyclerViewAdapter<InforCommentBean.DataBean> {

    @Override
    public void fillData(ViewDataBinding vdBinding, int position) {
        ItemCommentBinding itemCommentBinding = (ItemCommentBinding) vdBinding;
        itemCommentBinding.setBean(mDataList.get(position));
    }
}
