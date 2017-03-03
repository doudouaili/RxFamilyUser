package www.rxfamilyuser.com.coom.drycargo.view;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseFragment;
import www.rxfamilyuser.com.coom.drycargo.adapter.MyAdapter;
import www.rxfamilyuser.com.coom.drycargo.viewmodel.DryReuseModel;
import www.rxfamilyuser.com.databinding.FragmentDryReuseBinding;

public class DryReuseFragment extends BaseFragment<FragmentDryReuseBinding, DryReuseModel> {
    private MyAdapter mAdapter;


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
        listData = new ArrayList<String>();
        mBinder.xrView.setPullRefreshEnabled(false);
        mBinder.xrView.setLoadingMoreEnabled(true);
        mAdapter = new MyAdapter(listData);

        mBinder.xrView.setAdapter(mAdapter);


        mBinder.srLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        getData();
        mBinder.xrView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        listData.clear();
                        for (int i = 0; i < 15; i++) {
                            listData.add("item" + i + "after " + 22 + " times of refresh");
                        }
                        mAdapter.notifyDataSetChanged();
                        mBinder.xrView.refreshComplete();
                    }

                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        listData.clear();
                        for (int i = 0; i < 15; i++) {
                            listData.add("item" + i + "after " + 22 + " times of refresh");
                        }
                        mAdapter.notifyDataSetChanged();
                        mBinder.xrView.refreshComplete();
                    }

                }, 1000);            //refresh data here
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
                getData();
            }
        });
    }

    private Handler handler = new Handler();
    private ArrayList<String> listData;

    /**
     * 获取测试数据
     */
    private void getData() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listData.clear();
                for (int i = 0; i < 15; i++) {
                    listData.add("item" + i + "after " + 111 + " times of refresh");
                }
                mAdapter.notifyDataSetChanged();
                mBinder.srLayout.setRefreshing(false);
                mBinder.xrView.refreshComplete();
            }
        }, 2500);

    }
}
