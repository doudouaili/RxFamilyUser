package www.rxfamilyuser.com.coom.personal.view;

import android.content.Intent;
import android.view.View;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseFragment;
import www.rxfamilyuser.com.coom.Login.view.LoginActivity;
import www.rxfamilyuser.com.coom.personal.viewmodel.PerCenterViewModel;
import www.rxfamilyuser.com.databinding.FragmentPerCenterBinding;

public class PerCenterFragment extends BaseFragment<FragmentPerCenterBinding, PerCenterViewModel> {


    @Override
    public int getLayoutId() {
        return R.layout.fragment_per_center;
    }

    @Override
    public void initView() {
        mBinder.setModel(mModel);
        mBinder.toolbar.setTitle(getString(R.string.rb_mycenter));

        mBinder.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });

    }
    private void setOnClickListener(){

    }

}
