package www.rxfamilyuser.com.coom.drycargo.view;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;

import www.rxfamilyuser.com.R;
import www.rxfamilyuser.com.base.BaseActivity;
import www.rxfamilyuser.com.coom.drycargo.bean.HomeBean;
import www.rxfamilyuser.com.coom.drycargo.viewmodel.InforModel;
import www.rxfamilyuser.com.databinding.ActivityInforBinding;
import www.rxfamilyuser.com.util.AnimationUtil;

public class InforActivity extends BaseActivity<ActivityInforBinding, InforModel> {

    private static final int SANIMATION_TIME = 500;

    @Override
    public int getLayoutId() {
        return R.layout.activity_infor;
    }

    @Override
    public void initView() {
        HomeBean.DataBean.InforBeanBean infor = (HomeBean.DataBean.InforBeanBean) getIntent().getSerializableExtra("infor");
        mModel.getExpert(infor.getInfor_id());
        //设置ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(infor.getInfor_title());
        setSupportActionBar(toolbar);//替换系统的actionBar

        toolbar.setOnMenuItemClickListener(onMenuItemClick);


        WebSettings webSettings = mBinder.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mBinder.webview.loadUrl(infor.getInfor_html());

        mBinder.nestedScroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (scrollY > oldScrollY) {//下滑
                    AnimationUtil.with().moveToViewBottom(mBinder.linearBottom, SANIMATION_TIME);
                } else {
                    AnimationUtil.with().bottomMoveToViewLocation(mBinder.linearBottom, SANIMATION_TIME);
                }
            }
        });
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {

                case R.id.action_share:

                    break;

                case R.id.action_settings:

                    break;
            }

            return true;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
