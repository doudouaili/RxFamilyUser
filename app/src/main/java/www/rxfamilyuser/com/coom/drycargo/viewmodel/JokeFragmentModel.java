package www.rxfamilyuser.com.coom.drycargo.viewmodel;

import java.util.HashMap;
import java.util.Map;

import www.rxfamilyuser.com.base.BaseModel;
import www.rxfamilyuser.com.coom.drycargo.netcontrol.impl.JokeFragmentControlImpl;
import www.rxfamilyuser.com.databinding.FragmentJokeBinding;

/**
 * Created by ali on 2017/3/30.
 */

public class JokeFragmentModel extends BaseModel<FragmentJokeBinding, JokeFragmentControlImpl> {
    @Override
    public void onBeforeRequest(int tag) {

    }

    @Override
    public void onSuccess(Object bean, int tag) {

    }

    @Override
    public void onError(String errorMsg) {

    }

    public void getJokeList(int jokeId) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("jokeId", jokeId);
        mControl.getJokeList(this, map, 1);

    }
}
