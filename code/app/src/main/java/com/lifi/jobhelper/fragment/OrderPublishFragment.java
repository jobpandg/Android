package com.lifi.jobhelper.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lifi.jobhelper.R;
import com.lifi.jobhelper.utils.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class OrderPublishFragment extends Fragment {

    private List<String> banners = new ArrayList<>();
    private View view;
    private Banner banner;

    public OrderPublishFragment(){
        banners.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564581725521&di=ec3cb32a46309fd429c65513d81b885f&imgtype=0&src=http%3A%2F%2Fimg003.hc360.cn%2Fhb%2FMTQ1ODYzNTEwNDQ4NDE1MzM1MDU1Njc%3D.jpg");
        banners.add( "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565176523&di=18d1bf1bd7b5573d5f69be3baed3087d&imgtype=jpg&er=1&src=http%3A%2F%2Fimages.china.cn%2Fattachement%2Fjpg%2Fsite1000%2F20080114%2F0019b91ed6d208f50a2850.jpg");
        banners.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564581864905&di=83ccafe39681cc9914c3811f4242ee8e&imgtype=0&src=http%3A%2F%2Fimg011.hc360.cn%2Fk2%2FM04%2F66%2F52%2FwKhQxVffWlqEC7kQAAAAAJAqY0g574.jpg");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_order_publish, container, false);
        banner = view.findViewById(R.id.banner);
        banner.setImageLoader(new GlideImageLoader());   //设置图片加载器
        banner.setImages(banners);  //设置banner中显示图片
        banner.start();
        return view;
    }
}
