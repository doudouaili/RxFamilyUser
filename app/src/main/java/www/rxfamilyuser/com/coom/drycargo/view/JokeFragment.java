package www.rxfamilyuser.com.coom.drycargo.view;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseFragment;
import www.rxfamilyuser.com.coom.drycargo.viewmodel.JokeFragmentModel;
import www.rxfamilyuser.com.databinding.FragmentJokeBinding;

/**
 * 笑话fragment
 */
public class JokeFragment extends BaseFragment<FragmentJokeBinding, JokeFragmentModel> {

    private int jokeId = 0;//笑话id

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

        mModel.getJokeList(jokeId);
    }

}
