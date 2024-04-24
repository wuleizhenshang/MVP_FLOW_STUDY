package com.example.androidmvptest.ui.activity;

import android.os.Bundle;

import com.example.androidmvptest.R;
import com.example.androidmvptest.adapter.HomepageBannerAdapter;
import com.example.androidmvptest.base.BaseActivity;
import com.example.androidmvptest.presenter.HomepageBannerPresenter;
import com.example.androidmvptest.view.IHomepageBannerView;
import com.zhpan.bannerview.BannerViewPager;

import java.util.List;

public class MainActivity extends BaseActivity<HomepageBannerPresenter,IHomepageBannerView> implements IHomepageBannerView {

    private BannerViewPager bvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter.fetch();//执行presenter的业务逻辑
    }

    @Override
    protected HomepageBannerPresenter createPresenter() {
        return new HomepageBannerPresenter();
    }

    @Override
    public void showBannerPic(List<String> data) {
        bvp.refreshData(data);
    }

    private void initView() {
        bvp = findViewById(R.id.bvp);
        //异步同步
        bvp.setLifecycleRegistry(getLifecycle())
                .setAdapter(new HomepageBannerAdapter())
                .create();
    }

    @Override
    protected void init() {
        super.init();
        getLifecycle().addObserver(presenter);//添加观察者，ComponentActivity本身就实现了LifecycleOwner被观察者接口
        //AppCompatActivity继承FragmentActivity，FragmentActivity继承ComponentActivity
    }
}