package www.rxfamilyuser.com.coom.drycargo.view;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseFragment;
import www.rxfamilyuser.com.coom.drycargo.viewmodel.DryReuseModel;
import www.rxfamilyuser.com.databinding.FragmentDryReuseBinding;
import www.rxfamilyuser.com.widget.OnRecyclerViewItemClickListener;

@SuppressLint("ValidFragment")
public class DryReuseFragment extends BaseFragment<FragmentDryReuseBinding, DryReuseModel> {
    private int mType = 1;

    private int mPage = 10;

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
        mBinder.xrView.setLoadingMoreEnabled(false);

        mBinder.srLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


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
                mModel.getDryData(mType, mPage);

            }
        });

        mBinder.srLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //网络请求
                mPage = 10;
                mModel.getDryData(mType, mPage);
            }
        });


        mModel.mReuseAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int itemViewType = mModel.mReuseAdapter.getItemViewType(position);
                switch (itemViewType) {
                    case 1:

                        mModel.intent2Infor(view,position);
                        /* Intent intent = new Intent(getContext(), InforActivity.class);
                        intent.putExtra("url", mModel.mDataList.get(position).getInforBean().getInfor_img());
                        startActivity(intent);
                       ActivityOptionsCompat options =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                                        viewById, "image_animation");
                        ActivityCompat.startActivity(getContext(), intent, options.toBundle());*/
                        break;
                    case 2:
                        mModel.intent2Joke();
                        break;
                    case 3:
                        mModel.intent2Expert();
                        break;
                    case 4:
                        mModel.intent2Welfare();
                        break;
                }
            }
        });
    }
}
