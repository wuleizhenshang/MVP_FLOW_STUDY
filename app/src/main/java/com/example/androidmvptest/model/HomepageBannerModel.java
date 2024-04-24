package com.example.androidmvptest.model;

import android.util.Log;

import com.example.androidmvptest.presenter.IHomepageBannerPresenter;
import com.example.androidmvptest.url.impl.IWanAndroid;
import com.example.androidmvptest.url.responseBean.HomepageBannerResponseBean;
import com.example.androidmvptest.url.responseBean.HomepageBannerResponseDataBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author: wuleizhenshang
 * @Email: wuleizhenshang@163.com
 * @Date: 2024/03/12
 * @Discribe:
 */
public class HomepageBannerModel implements IHomepageBannerModel{

    private IHomepageBannerPresenter mIHomepageBannerPresenter;//告诉Presenter加载数据完成

    public HomepageBannerModel(IHomepageBannerPresenter IHomepageBannerPresenter) {
        mIHomepageBannerPresenter = IHomepageBannerPresenter;
    }

    @Override
    public void getBanner() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IWanAndroid wanAndroid = retrofit.create(IWanAndroid.class);
        Call<HomepageBannerResponseBean> call = wanAndroid.getHomePagerBanner();
        call.enqueue(new Callback<HomepageBannerResponseBean>() {
            @Override
            public void onResponse(Call<HomepageBannerResponseBean> call, Response<HomepageBannerResponseBean> response) {
                HomepageBannerResponseBean responseBean = response.body();
                if (responseBean!=null){
                    Log.i("TAGG",responseBean.getData().toString());
                    List<HomepageBannerResponseDataBean> beanData = responseBean.getData();
                    List<String>list = new ArrayList<>();
                    for (HomepageBannerResponseDataBean bean:beanData) {
                        list.add(bean.getImagePath());
                    }
                    mIHomepageBannerPresenter.loadBannerPicSuccess(list);//告诉Presenter数据加载完成
                }
            }

            @Override
            public void onFailure(Call<HomepageBannerResponseBean> call, Throwable t) {
                Log.i("TAGG",t.toString());
            }
        });

    }
}
