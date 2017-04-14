package www.rxfamilyuser.com.coom.drycargo.adapter;

import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseRecyclerViewAdapter;
import www.rxfamilyuser.com.coom.drycargo.bean.HomeBean;
import www.rxfamilyuser.com.databinding.ItemExpertReuseBinding;
import www.rxfamilyuser.com.databinding.ItemJokeReuseBinding;
import www.rxfamilyuser.com.databinding.ItemWelfareReuseBinding;
import www.rxfamilyuser.com.databinding.ReuseItemBinding;
import www.rxfamilyuser.com.util.GlideUtil;
import www.rxfamilyuser.com.widget.OnRecyclerViewItemClickListener;

import static www.rxfamilyuser.com.R.layout.item_expert_reuse;
import static www.rxfamilyuser.com.R.layout.item_welfare_reuse;

/**
 * Created by ali on 2017/3/3.
 */

public class DryReuseAdapter extends BaseRecyclerViewAdapter<HomeBean.DataBean> {

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    /**
     * 根据类型加载不同布局
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;
        switch (viewType) {
            case 1:
                view = LayoutInflater.from(mContext).inflate(mItemLayout, parent, false);
                break;
            case 2:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_joke_reuse, parent, false);
                break;
            case 3:
                view = LayoutInflater.from(mContext).inflate(item_expert_reuse, parent, false);
                break;
            case 4:
                view = LayoutInflater.from(mContext).inflate(item_welfare_reuse, parent, false);
                break;
        }
        return new BaseViewHolder(view);
    }

    /**
     * 判断类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        switch (mDataList.get(position).getWork_that()) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
        }
        return 1;
    }


    @Override
    public void fillData(ViewDataBinding vdBinding, final int position) {
        switch (getItemViewType(position)) {
            case 1:
                ReuseItemBinding itemBinding = (ReuseItemBinding) vdBinding;
                itemBinding.setDataBean(mDataList.get(position));
                break;
            case 2:
                ItemJokeReuseBinding itemJokeReuseBinding = (ItemJokeReuseBinding) vdBinding;
                itemJokeReuseBinding.setDataBean(mDataList.get(position));

                if (mDataList.get(position).getJokeBean().getJoke_img().contains(".gif")) {

                    GlideUtil.getInstance().loadGifImage(mContext,
                            mDataList.get(position).getJokeBean().getJoke_img(),
                            itemJokeReuseBinding.ivPhotoJoke);
                } else {
                    GlideUtil.getInstance().loadImage(mContext,
                            mDataList.get(position).getJokeBean().getJoke_img(),
                            itemJokeReuseBinding.ivPhotoJoke);
                }

                break;
            case 3:
                ItemExpertReuseBinding itemExpertReuseBinding = (ItemExpertReuseBinding) vdBinding;
                itemExpertReuseBinding.setData(mDataList.get(position).getExpertBean());

                break;
            case 4:
                ItemWelfareReuseBinding itemWelfareReuseBinding = (ItemWelfareReuseBinding) vdBinding;
                itemWelfareReuseBinding.setData(mDataList.get(position));
                break;
        }

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
