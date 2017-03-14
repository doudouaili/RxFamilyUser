package www.rxfamilyuser.com.coom.drycargo.view;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseFragment;
import www.rxfamilyuser.com.coom.drycargo.viewmodel.DryReuseModel;
import www.rxfamilyuser.com.databinding.FragmentDryReuseBinding;

@SuppressLint("ValidFragment")
public class DryReuseFragment extends BaseFragment<FragmentDryReuseBinding, DryReuseModel> {
    private int mType = 1;


    private int mPage = 1;

    public int getmPage() {
        return mPage;
    }

    public DryReuseFragment(int i) {
        mType = i;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_dry_reuse;
    }

    @Override
    public void initView() {
        mBinder.setModel(mModel);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mBinder.xrView.setLayoutManager(linearLayoutManager);
        mBinder.xrView.setPullRefreshEnabled(false);
        mBinder.xrView.setLoadingMoreEnabled(true);

        mBinder.srLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        mModel.getDryData(mType, mPage);

        mBinder.xrView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                mPage++;
                mModel.getDryData(mType, mPage);
            }
        });

        mBinder.srLayout.post(new Runnable() {
            @Override
            public void run() {
                mBinder.srLayout.setRefreshing(true);
            }
        });

        mBinder.srLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //网络请求
                mPage = 1;
                mModel.getDryData(mType, mPage);
            }
        });
    }
}
