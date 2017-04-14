RxFamilyUser
===
注:本项目只是供大家学习交流,不做与商用,项目中有些引入的第三方资源如果引起您的不满,请及时给我联系,并在第一时间删除.
-----
* 作者：阿狸先生
* 邮箱：qq13611127543@163.com
* 扣扣：958028993
* 扣群：570278493
----
服务端传送门:https://github.com/doudouaili/AndroidConcentration<br>
特别鸣谢万里大屌<Github>:https://github.com/waddwaw<br>

应用截图:
-------
![显示错误](https://github.com/doudouaili/RxFamilyUser/raw/master/gif/rxfamily.gif)<br>
-------
PS:gif效果太差,项目中有apk,可自行安装.

项目库介绍:
-------
  * 仿Ios右滑界面消失-->com.jude:swipebackhelper:3.1.2<br>
  * 下拉刷新-->com.jcodecraeer:xrecyclerview:1.3.2<br>
  * Android5.0控件-->一系列<br>
  * 数据库-->未确定<br>
  * 网络请求 -->retrofit2+rxjava2<br>
  * Android屏幕适配-->com.zhy:autolayout:1.4.5<br>
  * 注册短信-->share短信服务<br>
  * Utils工具类-->com.blankj:utilcode:1.3.6<br>
  * 加载图片-->com.github.bumptech.glide:glide:3.7.0<br>
      

项目架构:
-------
框架:基于retrofit2+rxjava2+databing<br>
使用databing把赋值操作交给xml处理,activity不处理网络请求,只负责发出.ViewModel处理发出请求和接受.Control网络请求的控制者.<br>
View:<br>
```java
//Activity/fragment是view层,调用viewModel中业务方法,这里发起一个网络请求.
//viewmodel通过泛型的形式在BaseActivity获取
 mModel.getTitle();
 
 //Acitvity例子
 public class InforActivity extends BaseActivity<ActivityInforBinding, InforModel> implements View.OnClickListener {

    private static final int SANIMATION_TIME = 500;//隐藏/显示动画时间
    private int mPage = 1;
    private String mInforHtml = "";
    private int mInforId = 0;
    private String mTitle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_infor;
    }

    @Override
    public void initView() {

        mInforId = getIntent().getIntExtra("infor_id", 0);
        mInforHtml = getIntent().getStringExtra("infor_html");
        mTitle = getIntent().getStringExtra("title");
        mBinder.setModel(mModel);

        //设置ToolBar
        mBinder.toolbar.setTitle(mTitle);
        setSupportActionBar(mBinder.toolbar);//替换系统的actionBar
        mBinder.toolbar.setOnMenuItemClickListener(onMenuItemClick);

        WebSettings webSettings = mBinder.webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mBinder.webview.loadUrl(mInforHtml);

        setListener();
        setRecyclerViewInit();
    }
}
```
ViewModel:<br>
```java
    //viewModel调用Control调用Control中网络请求,并回调到ViewModel中做请求结束的操作.
    //Control通过泛型的形式在BaseViewModel中获取
     public void getTitle() {
            Map<String, Integer> map = new HashMap<>();
            mControl.getTitile(this, map, 1);
        }
    //==============================================================
    //ViewModel例子:
    public class DryCargoModel extends BaseModel<FragmentDryCargoBinding, DryCargoControlImpl> {
  
  //网络回调
    @Override
    public void onBeforeRequest(int tag) {

    }

    @Override
    public void onSuccess(Object bean, int tag) {
        TitleBean titleBean = (TitleBean) bean;
        ArrayList<Fragment> fragments = addListFragment(titleBean.getData().size());
        setTabAdapter(fragments, titleBean.getData());
    }

    @Override
    public void onError(String errorMsg) {
        //网络连接失败,从本地读取
       /* String json = "";
        TitleBean titleBean = new Gson().fromJson(json, TitleBean.class);
        ArrayList<Fragment> fragments = addListFragment(titleBean.getData().size());
        setTabAdapter(fragments, titleBean.getData());*/
    }
    
```
Control:<br>
```java
//调用网络请求,在这里做缓存,取消请求等等.
public class DryCargoControlImpl extends BaseNetControl implements IDryCargoControl {

    @Override
    public void getTitile(final RequestCallBack callBack, Map<String, Integer> map, final int tag) {
        callBack.beforeRequest(tag);
        HttpRequestImpl.getInstance()
                .getTitle(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TitleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                        TitleBean titleBean = (TitleBean) ACcheManager.getObjectBean(BaseApplication.getContext(), ConstantUtil.STITLE_KEY);
                        //判断缓存,存在就取消请求
                        if (titleBean != null) {
                            onNext(titleBean);
                            mDisposable.dispose();
                        }
                    }

                    @Override
                    public void onNext(TitleBean value) {
                        ACcheManager.putObjectBean(BaseApplication.getContext(), ConstantUtil.STITLE_KEY, value, ACache.TIME_DAY);
                        callBack.success(value, tag);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.error(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
```


