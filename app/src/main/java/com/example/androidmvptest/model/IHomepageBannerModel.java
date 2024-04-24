package com.example.androidmvptest.model;

import com.example.androidmvptest.url.responseBean.HomepageBannerResponseBean;

/**
 * @Author: wuleizhenshang
 * @Email: wuleizhenshang@163.com
 * @Date: 2024/03/12
 * @Discribe:
 */
public interface IHomepageBannerModel {
    /**
     * 向服务器请求数据
     *
     */
    void getBanner();
}
