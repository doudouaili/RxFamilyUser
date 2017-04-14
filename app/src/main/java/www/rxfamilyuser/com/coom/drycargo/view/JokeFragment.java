package www.rxfamilyuser.com.coom.drycargo.view;

import android.annotation.SuppressLint;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.webkit.WebSettings;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseFragment;
import www.rxfamilyuser.com.coom.drycargo.viewmodel.JokeFragmentModel;
import www.rxfamilyuser.com.databinding.FragmentJokeBinding;
import www.rxfamilyuser.com.util.AnimationUtil;

/**
 * 乐趣fragment
 */
@SuppressLint("ValidFragment")
public class JokeFragment extends BaseFragment<FragmentJokeBinding, JokeFragmentModel> {
    private static final int SANIMATION_TIME = 500;//隐藏/显示动画时间
    private int jokeId = 0;//笑话id
    private int mPage = 1;//页数

    public JokeFragment(int i) {
        jokeId = i;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_joke;
    }

    @Override
    public void initView() {
        mBinder.setModel(mModel);
        mModel.getJokeList(jokeId, mPage);
        setListener();
        setRecyclerViewInit();
        WebSettings webSettings = mBinder.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    private void setRecyclerViewInit() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinder.xrView.setLayoutManager(linearLayoutManager);
        mBinder.xrView.setPullRefreshEnabled(false);
        mBinder.xrView.setLoadingMoreEnabled(true);

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
                mModel.getJokeList(jokeId, mPage);
            }
        });

        mBinder.srLayout.post(new Runnable() {
            @Override
            public void run() {
                mBinder.srLayout.setRefreshing(true);
                mModel.getJokeList(jokeId, mPage);
            }
        });

        mBinder.srLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //网络请求
                mPage = 1;
                mModel.getJokeList(jokeId, mPage);
            }
        });
    }

    private void setListener() {
        //滑动监听,设置底部隐藏
        mBinder.nestedScroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {//下滑
                    AnimationUtil.with().moveToViewBottom(mBinder.linearBottom, SANIMATION_TIME);//显示
                } else {
                    AnimationUtil.with().bottomMoveToViewLocation(mBinder.linearBottom, SANIMATION_TIME);
                }
            }
        });
    }

    public int getmPage() {
        return mPage;
    }

}
