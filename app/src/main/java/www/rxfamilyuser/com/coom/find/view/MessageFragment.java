package www.rxfamilyuser.com.coom.find.view;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseFragment;
import www.rxfamilyuser.com.coom.find.viewmodel.MessageViewModel;
import www.rxfamilyuser.com.databinding.FragmentMessageBinding;
import www.rxfamilyuser.com.util.XRecyclerviewUtis;

/**
 * 消息
 */
public class MessageFragment extends BaseFragment<FragmentMessageBinding, MessageViewModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    public void initView() {
        mBinder.setModel(mModel);
        mBinder.toolbar.setTitle(getString(R.string.rb_center));

        new XRecyclerviewUtis(mBinder.xrFind, mBinder.srFind, getContext())
                .setLayoutManager(LinearLayoutManager.VERTICAL)
                .setPullRefreshEnabled(false)
                .setLoadingMoreEnabled(true)
                .swipeLayouSetColorSchemeResources()
                .swipeLayouPost(new Runnable() {
                    @Override
                    public void run() {
                        mBinder.srFind.setRefreshing(true);
                        mModel.getMessageData();
                    }
                })
                .swipeLayouSetOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        //网络请求
                        mModel.getMessageData();
                    }
                });
    }
}
