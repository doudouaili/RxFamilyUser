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
import www.rxfamilyuser.com.util.XRecyclerviewUtis;
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

        new XRecyclerviewUtis(mBinder.xrView, mBinder.srLayout, getContext())
                .setLayoutManager(LinearLayoutManager.VERTICAL)
                .setPullRefreshEnabled(false)
                .setLoadingMoreEnabled(false)
                .swipeLayouSetColorSchemeResources()
                .setLoadingListener(new XRecyclerView.LoadingListener() {
                    @Override
                    public void onRefresh() {

                    }

                    @Override
                    public void onLoadMore() {
                        mPage++;
                        mModel.getDryData(mType, mPage);
                    }
                })
                .swipeLayouPost(new Runnable() {
                    @Override
                    public void run() {
                        mBinder.srLayout.setRefreshing(true);
                        mModel.getDryData(mType, mPage);
                    }
                })
                .swipeLayouSetOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
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

                        mModel.intent2Infor(position);
                        /* Intent intent = new Intent(getContext(), InforActivity.class);
                        intent.putExtra("url", mModel.mDataList.get(position).getInforBean().getInfor_img());
                        startActivity(intent);
                       ActivityOptionsCompat options =
                                ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                                        viewById, "image_animation");
                        ActivityCompat.startActivity(getContext(), intent, options.toBundle());*/
                        break;
                    case 2:
                        mModel.intent2Joke(position);
                        break;
                    case 3:
                        mModel.intent2Expert(position);
                        break;
                    case 4:
                        mModel.intent2Welfare(position);
                        break;
                }
            }
        });
    }
}
