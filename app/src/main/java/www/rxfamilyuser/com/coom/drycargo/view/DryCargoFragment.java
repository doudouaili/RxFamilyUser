package www.rxfamilyuser.com.coom.drycargo.view;

import android.transition.Explode;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseFragment;
import www.rxfamilyuser.com.coom.drycargo.viewmodel.DryCargoModel;
import www.rxfamilyuser.com.databinding.FragmentDryCargoBinding;

/**
 * 干货集中营
 */
public class DryCargoFragment extends BaseFragment<FragmentDryCargoBinding, DryCargoModel> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_dry_cargo;
    }

    @Override
    public void initView() {

        mModel.getTitle();
        mBinder.toolbar.setTitle(getString(R.string.rb_home));
        showEnterAnimation();
    }

    private void showEnterAnimation() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Explode explode = new Explode();
            explode.setDuration(1000);
            getActivity().getWindow().setEnterTransition(explode);
        }
    }
}
