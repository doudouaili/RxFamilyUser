package www.rxfamilyuser.com.coom.drycargo.viewmodel;

import java.util.HashMap;
import java.util.Map;

import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.drycargo.bean.HomeBean;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.impl.InforControlImpl;
import www.rxfamilyuser.com.databinding.ActivityInforBinding;

/**
 * Created by ali on 2017/3/15.
 */

public class InforModel extends BaseModel<ActivityInforBinding, InforControlImpl> {
    @Override
    public void onBeforeRequest(int tag) {

    }

    @Override
    public void onSuccess(Object bean, int tag) {
        switch (tag) {
            case 1:
                HomeBean.DataBean.ExpertBean expertBean = (HomeBean.DataBean.ExpertBean) bean;

                break;
        }
    }

    @Override
    public void onError(String errorMsg) {

    }

    /**
     * 获取专家详情
     *
     * @param exerptId
     */
    public void getExpert(int exerptId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("expertId", exerptId);
        mControl.findExpert(this, map, 1);

    }
}
