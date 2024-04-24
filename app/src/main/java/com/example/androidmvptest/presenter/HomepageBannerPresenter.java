package com.example.androidmvptest.presenter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

import com.example.androidmvptest.base.BasePresenter;
import com.example.androidmvptest.base.IBaseView;
import com.example.androidmvptest.model.HomepageBannerModel;
import com.example.androidmvptest.model.IHomepageBannerModel;
import com.example.androidmvptest.url.responseBean.HomepageBannerResponseBean;
import com.example.androidmvptest.view.IHomepageBannerView;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @Author: wuleizhenshang
 * @Email: wuleizhenshang@163.com
 * @Date: 2024/03/12
 * @Discribe:
 */
public class HomepageBannerPresenter extends BasePresenter<IHomepageBannerView> implements IHomepageBannerPresenter {

    private IHomepageBannerModel mIHomepageBannerModel;

    public HomepageBannerPresenter() {
        mIHomepageBannerModel = new HomepageBannerModel(this);
    }

    /**
     * 执行业务逻辑
     * 一般会把业务逻辑统一放在fetch方法中
     */
    public void fetch() {
        if (mView != null && mIHomepageBannerModel != null) {
            loadBannerPic();
        }
    }


    @Override
    public void loadBannerPic() {
        mIHomepageBannerModel.getBanner();
    }

    @Override
    public void loadBannerPicSuccess(List<String> data) {
        mView.get().showBannerPic(data);
    }

    /**
     * 那么HomepageBannerPresenter继承BasePresenter，就可以使用生命周期的回调了，这里简单打印一下
     *
     * @param owner the component, whose state was changed
     */
    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        super.onCreate(owner);
        Log.i("TAGG", "onCreate!");
    }
}
