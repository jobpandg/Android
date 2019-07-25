package com.lifi.jobhelper.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lifi.jobhelper.fragment.MeFragment;
import com.lifi.jobhelper.fragment.MessageFragment;
import com.lifi.jobhelper.fragment.OrderPublishFragment;
import com.lifi.jobhelper.fragment.OrderReceiveFragment;

public class MainTabFragmentAdapter extends FragmentPagerAdapter {
    public MainTabFragmentAdapter(FragmentManager fm) {
        super(fm);
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

}