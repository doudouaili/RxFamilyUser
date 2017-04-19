package www.rxfamilyuser.com.coom.drycargo.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;

import java.util.HashMap;
import java.util.Map;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.drycargo.adapter.JokeCommentAdapter;
import www.rxfamilyuser.com.coom.drycargo.bean.JokeListBean;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.impl.JokeFragmentControlImpl;
import www.rxfamilyuser.com.coom.drycargo.view.JokeFragment;
import www.rxfamilyuser.com.databinding.FragmentJokeBinding;

/**
 * Created by ali on 2017/3/30.
 */

public class JokeFragmentModel extends BaseModel<FragmentJokeBinding, JokeFragmentControlImpl> {

    public JokeCommentAdapter mCommAdapter = new JokeCommentAdapter();
    public ObservableArrayList<JokeListBean.DataBean.ComBeanBean> mCommList = new ObservableArrayList<>();
    public ObservableInt mCommLayout = new ObservableInt(R.layout.item_joke_comment);

    private JokeFragment fragment;

    @Override
    public void onCreate() {
        super.onCreate();
        fragment = (JokeFragment) UI;
    }

    @Override
    public void onBeforeRequest(int tag) {
    }

    @Override
    public void onSuccess(Object bean, int tag) {
        switch (tag) {
            case 1:
                JokeListBean jokeListBean = (JokeListBean) bean;
                if (jokeListBean.getCode() != 0) {
                    if (fragment.getmPage() == 1) {
                        mCommList.clear();
                    }
                    JokeListBean.DataBean dataBean = jokeListBean.getData().get(0);
                    mCommList.addAll(dataBean.getComBean());
                    int joke_type = Integer.parseInt(dataBean.getJoke_type());
                    if (joke_type == 1) {
                        mBinder.webview.loadUrl(dataBean.getJoke_html());
                    }
                }
                mBinder.xrView.loadMoreComplete();
                mBinder.srLayout.setRefreshing(false);
                mCommAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onError(String errorMsg) {
        mBinder.xrView.loadMoreComplete();
        mBinder.srLayout.setRefreshing(false);
    }

    public void getJokeList(int jokeId, int page) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("jokeId", jokeId);
        map.put("page", page);
        mControl.getJokeList(this, map, 1,"getJokeCommentData");
    }
}
