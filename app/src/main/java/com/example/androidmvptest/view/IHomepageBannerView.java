package com.example.androidmvptest.view;

import com.example.androidmvptest.base.IBaseView;
import com.example.androidmvptest.url.responseBean.HomepageBannerResponseBean;

import java.util.List;

/**
 * @Author: wuleizhenshang
 * @Email: wuleizhenshang@163.com
 * @Date: 2024/03/12
 * @Discribe:
 */
public interface IHomepageBannerView extends IBaseView {


    /**
     * 加载Banner图片成功
     */
    void showBannerPic(List<String> data);
}
