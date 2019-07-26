package com.lifi.jobhelper.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.lifi.jobhelper.R;
import com.lifi.jobhelper.adpter.MainTabFragmentAdapter;

public class MainActivity extends BaseActivity {

    private ViewPager vp;
    private TabLayout tab_layout;
    private MainTabFragmentAdapter adapter;
    private LayoutInflater inflater;

    @Override
    public void initViews() {
        vp = findViewById(R.id.vp);
        tab_layout = findViewById(R.id.tab_layout);
    }

    @Override
    public void initDatas() {
        adapter = new MainTabFragmentAdapter(getApplicationContext(), getSupportFragmentManager());
        vp.setAdapter(adapter);
        vp.setCurrentItem(0);
        inflater = LayoutInflater.from(this);
        initTabs(tab_layout);
    }

    private void initTabs(TabLayout tabLayout) {
        tabLayout.setupWithViewPager(vp);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setCustomView(adapter.getTabView(i));
        }
    }

    @Override
    public void initListener() {
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                tab_layout.setScrollPosition(i, 0f, true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                vp.setCurrentItem(position, false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
