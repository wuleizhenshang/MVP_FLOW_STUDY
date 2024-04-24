package com.example.androidmvptest.url.responseBean;

import java.util.List;

/**
 * @Author: wuleizhenshang
 * @Email: wuleizhenshang@163.com
 * @Date: 2024/03/12
 * @Discribe:
 */
public class HomepageBannerResponseBean {
    private List<HomepageBannerResponseDataBean> data;
    private Integer errorCode;
    private String errorMsg;

    public List<HomepageBannerResponseDataBean> getData() {
        return data;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}


