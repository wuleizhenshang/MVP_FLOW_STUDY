package com.example.androidmvptest.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import java.lang.ref.WeakReference;

/**
 * @Author: wuleizhenshang
 * @Email: wuleizhenshang@163.com
 * @Date: 2024/03/12
 * @Discribe: 每个Presenter都需要弱引用、绑定和解绑，那么就可以抽一个父类来完成
 */
public class BasePresenter<T extends IBaseView> implements DefaultLifecycleObserver {
//这里就是实现观察者的接口，可以是任何的类，而被观察者就是Activity/Fragment，通过add将观察者和被观察者绑定到一起

    /**
     * 生命周期执行，那么对应的方法就会被调用，使用注解的方式同，这里举个例子将方法放在这里，并没有执行什么业务逻辑
     * @param owner the component, whose state was changed
     */
    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onPause(owner);
    }

    /**
     * 可以使用注解的方式进行生命周期的监听的，但是这种方式需要使用代码生成或反射，会造成很大的性能开销，
     * 官方建议使用DefaultLifecycleObserver或LifecycleEventObserver来代替
     */
/*    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void create(LifecycleOwner owner){

    }*/



    public WeakReference<T> mView;

    /**
     * 绑定
     */
    public void attachView(T view){
        mView = new WeakReference<>(view);
    }

    /**
     * 解绑
     */
    public void deatchView(){
        if (mView!=null){
            mView.clear();
            mView = null;
        }
    }
}
