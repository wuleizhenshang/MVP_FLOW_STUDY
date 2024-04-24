package com.example.androidmvptest.url.impl;

import com.example.androidmvptest.url.responseBean.HomepageBannerResponseBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @Author: wuleizhenshang
 * @Email: wuleizhenshang@163.com
 * @Date: 2024/03/12
 * @Discribe:
 */
public interface IWanAndroid {
    @GET("banner/json")
    Call<HomepageBannerResponseBean> getHomePagerBanner();
}
