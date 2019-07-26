package com.lifi.jobhelper.adpter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lifi.jobhelper.R;
import com.lifi.jobhelper.fragment.MeFragment;
import com.lifi.jobhelper.fragment.MessageFragment;
import com.lifi.jobhelper.fragment.OrderPublishFragment;
import com.lifi.jobhelper.fragment.OrderReceiveFragment;

import java.util.ArrayList;
import java.util.List;

public class MainTabFragmentAdapter extends FragmentPagerAdapter {

    private Context context;

    private final int []TAB_TITLES = new int[]{R.string.mainTab_orderPublish,
            R.string.mainTab_orderReceive,
            R.string.mainTab_message,
            R.string.mainTab_me};
    private final int []TAB_IMAGES = new int[]{R.drawable.selector_rocket,
            R.drawable.selector_sword,
            R.drawable.selector_message,
            R.drawable.selector_me};

    public MainTabFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = new OrderPublishFragment();
                break;
            case 1:
                fragment = new OrderReceiveFragment();
                break;
            case 2:
                fragment = new MessageFragment();
                break;
            case 3:
                fragment = new MeFragment();
                break;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }


    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tab_main, null);
        ImageView iv_mainTab = view.findViewById(R.id.iv_mainTab);
        TextView tv_mainTab = view.findViewById(R.id.tv_mainTab);
        iv_mainTab.setBackgroundResource(TAB_IMAGES[position]);
        tv_mainTab.setText(context.getResources().getString(TAB_TITLES[position]));
        return view;
    }

}