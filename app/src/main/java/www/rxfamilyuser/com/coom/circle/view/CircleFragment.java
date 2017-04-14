package www.rxfamilyuser.com.coom.circle.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseFragment;
import www.rxfamilyuser.com.coom.circle.viewmodel.CircleViewModel;
import www.rxfamilyuser.com.databinding.FragmentCircleBinding;
import www.rxfamilyuser.com.util.XRecyclerviewUtis;

/**
 * 互动中心
 */
public class CircleFragment extends BaseFragment<FragmentCircleBinding, CircleViewModel> {
    private int mPage = 1;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_circle;
    }

    @Override
    public void initView() {
        mBinder.setModel(mModel);
        mBinder.toolbar.setTitle(getString(R.string.rb_live));

        new XRecyclerviewUtis(mBinder.xrCircle, mBinder.srCircle, getContext())
                .setLayoutManager(LinearLayoutManager.VERTICAL)
                .setPullRefreshEnabled(false)
                .setLoadingMoreEnabled(true)
                .swipeLayouSetColorSchemeResources()
                .setLoadingListener(new XRecyclerView.LoadingListener() {
                    @Override
                    public void onRefresh() {

                    }

                    @Override
                    public void onLoadMore() {
                        mPage++;
                        mModel.getInvitationListData(mPage);
                    }
                })
                .swipeLayouPost(new Runnable() {
                    @Override
                    public void run() {
                        mBinder.srCircle.setRefreshing(true);
                        mModel.getInvitationListData(mPage);
                    }
                })
                .swipeLayouSetOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        //网络请求
                        mPage = mPage + 1;
                        mModel.getInvitationListData(mPage);
                    }
                });

    }

    public int getmPage() {
        return mPage;
    }
}
