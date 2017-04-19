package www.rxfamilyuser.com.coom.personal.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.utils.LogUtils;

import www.rxfamilyuser.com.R;

/**
 * 个人主页
 */
public class PersonalHomepageFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LogUtils.i("加载了");
        return inflater.inflate(R.layout.fragment_personal_homepage, container, false);
    }


}
