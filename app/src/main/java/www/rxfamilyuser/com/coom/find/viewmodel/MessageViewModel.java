package www.rxfamilyuser.com.coom.find.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.find.adapter.MessageAdapter;
import www.rxfamilyuser.com.coom.find.bean.MessageBean;
import www.rxfamilyuser.com.coom.find.netcontrol.impl.MessageControlImpl;
import www.rxfamilyuser.com.databinding.FragmentMessageBinding;

/**
 * Created by ali on 2017/2/23.
 */

public class MessageViewModel extends BaseModel<FragmentMessageBinding, MessageControlImpl> {
    public List<MessageBean.DataBean> mDataList = new ObservableArrayList<>();
    public MessageAdapter mAdapter = new MessageAdapter();
    public ObservableInt mLayoutId = new ObservableInt(R.layout.item_message);
    @Override
    public void onBeforeRequest(int tag) {

    }

    @Override
    public void onSuccess(Object bean, int tag) {
        switch (tag) {
            case 1:
                MessageBean messageBean = (MessageBean) bean;
                if (messageBean.getCode() != 0) {
                    mDataList.clear();
                    mDataList.addAll(messageBean.getData());
                }
                mAdapter.notifyDataSetChanged();
                mBinder.xrFind.loadMoreComplete();
                mBinder.srFind.setRefreshing(false);
                break;
        }
    }

    @Override
    public void onError(String errorMsg) {
        mBinder.xrFind.loadMoreComplete();
        mBinder.srFind.setRefreshing(false);
    }

    public void getMessageData() {
        Map<String, Integer> map = new HashMap<>();

        mControl.getMessageData(this, map, 1,"getMessageData");
    }
}
