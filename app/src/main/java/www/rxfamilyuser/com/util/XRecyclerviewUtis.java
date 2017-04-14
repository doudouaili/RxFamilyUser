package www.rxfamilyuser.com.util;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Created by ali on 2017/4/13.
 */

public class XRecyclerviewUtis {
    private XRecyclerView mXRecyclerView;
    private SwipeRefreshLayout mSwipeLayou;
    private Context mContext;

    public XRecyclerviewUtis(XRecyclerView xRecyclerView, SwipeRefreshLayout swipeRefreshLayout, Context context) {
        this.mXRecyclerView = xRecyclerView;
        this.mSwipeLayou = swipeRefreshLayout;
        this.mContext = context;
    }

    /**
     * 设置RecyclerView的LayoutManager
     * @param type =LinearLayoutManager.VERTICAL//LinearLayoutManager.HORIZONTAL
     * @return
     */
    public XRecyclerviewUtis setLayoutManager(int type) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(type);
        if (mXRecyclerView != null) {
            mXRecyclerView.setLayoutManager(linearLayoutManager);
        }
        return this;
    }

    /**
     * 设置是否允许下拉
     * @param enabled falase不允许
     * @return
     */
    public XRecyclerviewUtis setPullRefreshEnabled(boolean enabled) {
        if (mXRecyclerView != null) {
            mXRecyclerView.setPullRefreshEnabled(enabled);
        }
        return this;
    }

    /**
     * 是否允许上拉
     * @param enabled
     * @return
     */
    public XRecyclerviewUtis setLoadingMoreEnabled(boolean enabled) {
        if (mXRecyclerView != null) {
            mXRecyclerView.setLoadingMoreEnabled(enabled);
        }
        return this;
    }

    /**
     * 刷新监听
     * @param loadingListener
     * @return
     */
    public XRecyclerviewUtis setLoadingListener(XRecyclerView.LoadingListener loadingListener) {
        if (mXRecyclerView != null)
            mXRecyclerView.setLoadingListener(loadingListener);
        return this;
    }

    /**
     * 设置swipeLayou刷新颜色
     * @return
     */
    public XRecyclerviewUtis swipeLayouSetColorSchemeResources() {
        if (mSwipeLayou != null)
            mSwipeLayou.setColorSchemeResources(android.R.color.holo_blue_bright,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light);
        return this;
    }

    /**
     * swipeLayou第一次下拉
     * @param runnable
     * @return
     */
    public XRecyclerviewUtis swipeLayouPost(Runnable runnable) {
        if (mSwipeLayou != null)
            mSwipeLayou.post(runnable);
        return this;
    }

    /**
     * swipeLayou刷新监听
     * @param listener
     * @return
     */
    public XRecyclerviewUtis swipeLayouSetOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener) {
        if (mSwipeLayou != null)
            mSwipeLayou.setOnRefreshListener(listener);
        return this;
    }

}
