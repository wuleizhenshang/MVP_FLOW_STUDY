package com.example.androidmvptest.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Author: wuleizhenshang
 * @Email: wuleizhenshang@163.com
 * @Date: 2024/03/12
 * @Discribe: BaseActivity进行绑定和解绑等等操作，这只是一个模板
 */
public abstract class BaseActivity<T extends BasePresenter,V extends IBaseView> extends AppCompatActivity {

    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //选择自己的表示层
        presenter = createPresenter();
        presenter.attachView((V)this);
        registerSDK();
        init();
    }

    /**
     * 这里就要求用户去自己createPresenter选择一个Presenter
     * SDK初始化。。。操作也而已定义在Base类中
     */
    protected abstract T createPresenter();

    protected void registerSDK(){};

    protected void unRegisterSDK(){};

    protected void init(){};

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deatchView();
        unRegisterSDK();
    }
}
