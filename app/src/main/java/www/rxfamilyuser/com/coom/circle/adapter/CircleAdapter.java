package www.rxfamilyuser.com.coom.circle.adapter;

import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseRecyclerViewAdapter;
import www.rxfamilyuser.com.coom.circle.Bean.CircleBean;
import www.rxfamilyuser.com.databinding.ItemCircleTextBinding;
import www.rxfamilyuser.com.databinding.ItemCircleVideoBinding;
import www.rxfamilyuser.com.util.GlideUtil;
import www.rxfamilyuser.com.widget.OnRecyclerViewItemClickListener;

/**
 * Created by ali on 2017/4/13.
 */

public class CircleAdapter extends BaseRecyclerViewAdapter<CircleBean.DataBean> {

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    @Override
    public int getItemViewType(int position) {
        switch (mDataList.get(position).getInvitation_type()) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 4;
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 1:
            case 2:
                view = LayoutInflater.from(mContext).inflate(mItemLayout, parent, false);
                break;
            case 3:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_circle_video, parent, false);
                break;
        }
        return new BaseViewHolder(view);
    }

    @Override
    public void fillData(ViewDataBinding vdBinding, final int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 1:
            case 2:
                ItemCircleTextBinding textBinding = (ItemCircleTextBinding) vdBinding;
                textBinding.setModel(mDataList.get(position));
                if (itemViewType == 2) {
                    textBinding.ivPhtotCircle.setVisibility(View.VISIBLE);
                    GlideUtil.getInstance().loadImage(mContext,
                            mDataList.get(position).getInvitation_img(),
                            textBinding.ivPhtotCircle);
                } else {
                    textBinding.ivPhtotCircle.setVisibility(View.GONE);
                }
                break;
            case 3:
                ItemCircleVideoBinding videoBinding = (ItemCircleVideoBinding) vdBinding;
                videoBinding.setModel(mDataList.get(position));
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
