package www.rxfamilyuser.com.coom.drycargo.viewmodel;

import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.view.View;

import com.blankj.utilcode.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.drycargo.adapter.DryReuseAdapter;
import www.rxfamilyuser.com.coom.drycargo.bean.HomeBean;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.impl.DryReuseControlImpl;
import www.rxfamilyuser.com.coom.drycargo.view.DryReuseFragment;
import www.rxfamilyuser.com.coom.drycargo.view.InforActivity;
import www.rxfamilyuser.com.coom.drycargo.view.JokeAvtivity;
import www.rxfamilyuser.com.databinding.FragmentDryReuseBinding;

/**
 * Created by ali on 2017/3/2.
 */

public class DryReuseModel extends BaseModel<FragmentDryReuseBinding, DryReuseControlImpl> {
    public ObservableArrayList<HomeBean.DataBean> mDataList = new ObservableArrayList();
    public ObservableInt mLayoutId = new ObservableInt(R.layout.reuse_item);
    public DryReuseAdapter mReuseAdapter = new DryReuseAdapter();

    private DryReuseFragment dryReuseFragment;

    @Override
    public void onCreate() {
        super.onCreate();
        dryReuseFragment = (DryReuseFragment) UI;

      /*  mReuseAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int itemViewType = mReuseAdapter.getItemViewType(position);
                switch (itemViewType) {
                    case 1:
                        Intent intent = new Intent(getContent(), InforActivity.class);
                        intent.putExtra("url", mDataList.get(position).getInforBean().getInfor_img());
                        ActivityOptionsCompat options =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(dryReuseFragment.getActivity(),
                                        view.findViewById(R.id.iv_photo), "image_animation");
                        ActivityCompat.startActivity(getContent(), intent, options.toBundle());
                        String name = Thread.currentThread().getName();
                        ToastUtils.showShortToast(name);
                        break;
                }
                ToastUtils.showShortToast("点击了");
            }
        });*/
    }

    @Override
    public void onBeforeRequest(int tag) {

    }

    @Override
    public void onSuccess(Object bean, int tag) {
        HomeBean homeBean = (HomeBean) bean;
        if (homeBean.getCode() == 1) {
            mDataList.clear();
            mDataList.addAll(homeBean.getData());

        } else {
            ToastUtils.showShortToast(homeBean.getMessage());
//            mBinder.xrView.setEmptyView(mNotWorkView);
        }
        mReuseAdapter.notifyDataSetChanged();
        mBinder.xrView.loadMoreComplete();
        mBinder.srLayout.setRefreshing(false);
    }

    @Override
    public void onError(String errorMsg) {
//        mBinder.frg.addView(mNotWorkView);
//        mBinder.xrView.setEmptyView(mNotWorkView);

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

    /**
     * 跳转到资讯详情
     *
     * @param view
     * @param position
     */
    public void intent2Infor(View view, int position) {
        Intent intent = new Intent();
        intent.setClass(getContent(), InforActivity.class);
        intent.putExtra("infor_html", mDataList.get(position).getInforBean().getInfor_html());
        intent.putExtra("infor_id", mDataList.get(position).getInforBean().getInfor_id());
        intent.putExtra("title", mDataList.get(position).getInforBean().getInfor_title());
        getContent().startActivity(intent);
    }

    /**
     * 跳转到笑话
     */
    public void intent2Joke() {
        Intent intent = new Intent();
        intent.setClass(getContent(), JokeAvtivity.class);
        getContent().startActivity(intent);
    }

    /**
     * 跳转到专家详情
     */
    public void intent2Expert() {

    }

    /**
     * 跳转到福利
     */
    public void intent2Welfare() {

    }
}
