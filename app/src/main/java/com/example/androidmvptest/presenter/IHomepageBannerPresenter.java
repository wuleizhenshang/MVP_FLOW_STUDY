package com.example.androidmvptest.presenter;

import com.example.androidmvptest.url.responseBean.HomepageBannerResponseBean;

import java.util.List;

/**
 * @Author: wuleizhenshang
 * @Email: wuleizhenshang@163.com
 * @Date: 2024/03/12
 * @Discribe:
 */
public interface IHomepageBannerPresenter {

    /**
     * 开始加载图片
     */
    void loadBannerPic();

    /**
     * 成功加载图片
     */
    void loadBannerPicSuccess(List<String> data);
}
