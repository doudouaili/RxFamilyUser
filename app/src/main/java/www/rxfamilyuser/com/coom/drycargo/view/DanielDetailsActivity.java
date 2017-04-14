package www.rxfamilyuser.com.coom.drycargo.view;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseActivity;
import www.rxfamilyuser.com.coom.drycargo.viewmodel.DanielDetailsModel;
import www.rxfamilyuser.com.databinding.ActivityDanielDetailsBinding;

public class DanielDetailsActivity extends BaseActivity<ActivityDanielDetailsBinding,DanielDetailsModel> {

    private  int exerptId;
    @Override
    public int getLayoutId() {
        return R.layout.activity_daniel_details;
    }

    @Override
    public void initView() {
         exerptId = getIntent().getIntExtra("exerptId", 0);
    }


    public int getExerptId() {
        return exerptId;
    }
}
