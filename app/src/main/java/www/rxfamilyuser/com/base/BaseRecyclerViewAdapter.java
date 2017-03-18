package www.rxfamilyuser.com.base;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by ali on 2017/2/22.
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder> {
    public Context mContext;
    /**
     * 数据集合
     */
    public List<T> mDataList;
    /**
     * item布局
     */
    public int mItemLayout;

    @BindingAdapter({"app:adapter", "app:data", "app:item"})
    public static <T> void setListBinding(final XRecyclerView view, final BaseRecyclerViewAdapter<T> tTextadaap, final List<T> data, final int item) {
        if (view.getTag() == null) {
            view.setAdapter(tTextadaap);
            view.setTag(tTextadaap);
        } else {
            ((BaseRecyclerViewAdapter) (view.getTag())).notifyDataSetChanged();
            view.refreshComplete();
            view.loadMoreComplete();
        }
        tTextadaap.setData(data);
        tTextadaap.setContext(view.getContext());
        tTextadaap.setItem(item);
    }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).asBitmap().fitCenter().into(view);

//        Picasso.with(view.getContext()).load(url).into(view);
    }

    public void setData(List<T> datas) {
        this.mDataList = datas;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setItem(int item) {
        this.mItemLayout = item;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mItemLayout, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ViewDataBinding binding = holder.getBinding();
        fillData(binding, position);
    }

    @Override
    public int getItemCount() {
        if (mDataList == null) {
            return 0;
        }
        return mDataList.size();
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding b;

        public BaseViewHolder(View itemView) {
            super(itemView);
            b = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return b;
        }
    }

    /**
     * @param vdBinding item布局
     * @param position  下标
     */
    public abstract void fillData(ViewDataBinding vdBinding, int position);

}
