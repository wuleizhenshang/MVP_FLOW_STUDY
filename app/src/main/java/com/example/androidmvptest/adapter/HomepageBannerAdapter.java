package com.example.androidmvptest.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideExtension;
import com.example.androidmvptest.R;
import com.zhpan.bannerview.BaseBannerAdapter;
import com.zhpan.bannerview.BaseViewHolder;

/**
 * @Author: wuleizhenshang
 * @Email: wuleizhenshang@163.com
 * @Date: 2024/03/12
 * @Discribe:
 */
public class HomepageBannerAdapter extends BaseBannerAdapter<String> {
    @Override
    protected void bindData(BaseViewHolder<String> holder, String data, int position, int pageSize) {
        View view = holder.findViewById(R.id.img);
        Glide.with(holder.itemView).load(data).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into((ImageView) view);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_homepage_banner;
    }
}
