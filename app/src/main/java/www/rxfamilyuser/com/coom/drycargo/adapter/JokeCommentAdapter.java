package www.rxfamilyuser.com.coom.drycargo.adapter;

import android.databinding.ViewDataBinding;

import www.rxfamilyuser.com.base.BaseRecyclerViewAdapter;
import www.rxfamilyuser.com.coom.drycargo.bean.JokeListBean;
import www.rxfamilyuser.com.databinding.ItemJokeCommentBinding;

/**
 * Created by ali on 2017/3/29.
 */

public class JokeCommentAdapter extends BaseRecyclerViewAdapter<JokeListBean.DataBean.ComBeanBean> {

    @Override
    public void fillData(ViewDataBinding vdBinding, int position) {
        ItemJokeCommentBinding binding = (ItemJokeCommentBinding) vdBinding;
        binding.setBean(mDataList.get(position));
    }
}
