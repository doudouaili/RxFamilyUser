package www.rxfamilyuser.com.coom.drycargo.viewmodel;

import android.support.v4.app.Fragment;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.Login.adapter.MainViewPagerAdapter;
import www.rxfamilyuser.com.coom.drycargo.bean.TitleBean;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.impl.DryCargoControlImpl;
import www.rxfamilyuser.com.coom.drycargo.view.DryCargoFragment;
import www.rxfamilyuser.com.coom.drycargo.view.DryReuseFragment;
import www.rxfamilyuser.com.databinding.FragmentDryCargoBinding;

/**
 * Created by ali on 2017/2/23.
 */

public class DryCargoModel extends BaseModel<FragmentDryCargoBinding, DryCargoControlImpl> {
    @Override
    public void onBeforeRequest(int tag) {

    }

    @Override
    public void onSuccess(Object bean, int tag) {
        TitleBean titleBean = (TitleBean) bean;
        ArrayList<Fragment> fragments = addListFragment(titleBean.getResult().size());
        setTabAdapter(fragments, titleBean.getResult());
    }

    @Override
    public void onError(String errorMsg) {
        //网络连接失败,从本地读取
        String json = "{\"code\":1,\"msg\":\"查询成功\",\"result\":[\"Retrofit\",\"RxJava2系列\",\"Android框架\",\"Android源码\",\"Android架构\",\"自定义View\"]}";
        TitleBean titleBean = new Gson().fromJson(json, TitleBean.class);
        ArrayList<Fragment> fragments = addListFragment(titleBean.getResult().size());
        setTabAdapter(fragments, titleBean.getResult());
    }

    /**
     * 获取标题
     */
    public void getTitle() {
        mControl.getTitile(this, 1);
    }

    /**
     * 添加fragment
     *
     * @return fragment集合
     */
    public ArrayList<Fragment> addListFragment(int size) {
        ArrayList<Fragment> fragments = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            fragments.add(new DryReuseFragment(i + 1));
        }
        return fragments;
    }

    private void setTabAdapter(ArrayList<Fragment> fragments, List<String> result) {
        DryCargoFragment fragment = (DryCargoFragment) UI;
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(fragment.getChildFragmentManager(), fragments);
        mBinder.vpView.setAdapter(mainViewPagerAdapter);
        mBinder.tabs.setupWithViewPager(mBinder.vpView);//将TabLayout和ViewPager关联起来。

        for (int i = 0; i < result.size(); i++) {
            mBinder.tabs.getTabAt(i).setText(result.get(i));
        }

    }

}
