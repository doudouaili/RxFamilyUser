package www.rxfamilyuser.com.coom.drycargo.view;

import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;

import com.blankj.utilcode.utils.ToastUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseActivity;
import www.rxfamilyuser.com.coom.drycargo.viewmodel.InforModel;
import www.rxfamilyuser.com.databinding.ActivityInforBinding;
import www.rxfamilyuser.com.util.AnimationUtil;

/**
 * 资讯详情页
 */
public class InforActivity extends BaseActivity<ActivityInforBinding, InforModel> implements View.OnClickListener {

    private static final int SANIMATION_TIME = 500;//隐藏/显示动画时间
    private int mPage = 1;
    private String mInforHtml = "";
    private int mInforId = 0;
    private String mTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_infor;
    }

    @Override
    public void initView() {

        mInforId = getIntent().getIntExtra("infor_id", 0);
        mInforHtml = getIntent().getStringExtra("infor_html");
        mTitle = getIntent().getStringExtra("title");
        mBinder.setModel(mModel);

        //设置ToolBar
        mBinder.toolbar.setTitle(mTitle);
        setSupportActionBar(mBinder.toolbar);//替换系统的actionBar
        mBinder.toolbar.setOnMenuItemClickListener(onMenuItemClick);

        WebSettings webSettings = mBinder.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mBinder.webview.loadUrl(mInforHtml);

        setListener();
        setRecyclerViewInit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_collect://收藏
                break;
            case R.id.iv_comm://跳转到评论
                break;
            case R.id.iv_playtour://打赏
                ToastUtils.showShortToast("分享功能还没添加,稍等稍等~~");
                break;
            case R.id.tv_write_comm://写评论
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void setRecyclerViewInit() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication());
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
                mModel.getCommentData(mInforId, mPage);
            }
        });

        mBinder.srLayout.post(new Runnable() {
            @Override
            public void run() {
                mBinder.srLayout.setRefreshing(true);
                mModel.getCommentData(mInforId, mPage);
            }
        });

        mBinder.srLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //网络请求
                mPage = 1;
                mModel.getCommentData(mInforId, mPage);
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

        mBinder.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBinder.ivCollect.setOnClickListener(this);
        mBinder.ivComm.setOnClickListener(this);
        mBinder.ivPlaytour.setOnClickListener(this);
        mBinder.tvWriteComm.setOnClickListener(this);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {

                case R.id.action_share:
                    ToastUtils.showShortToast("分享功能还没添加,稍等稍等~~");
                    break;

                case R.id.action_settings:
                    ToastUtils.showShortToast("此功能暂未实现,稍等稍等~~");
                    break;
            }
            return true;
        }
    };


    public int getmPage() {
        return mPage;
    }


}
