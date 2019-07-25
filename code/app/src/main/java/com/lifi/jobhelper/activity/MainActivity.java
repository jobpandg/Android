package com.lifi.jobhelper.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.lifi.jobhelper.R;
import com.lifi.jobhelper.adpter.MainTabFragmentAdapter;

public class MainActivity extends BaseActivity {

    private final int []TAB_TITLES = new int[]{R.string.mainTab_orderPublish,
                                                R.string.mainTab_orderReceive,
                                                R.string.mainTab_message,
                                                R.string.mainTab_me};
    private final int []TAB_IMAGES = new int[]{R.drawable.selector_rocket,
                                                R.drawable.selector_sword,
                                                R.drawable.selector_message,
                                                R.drawable.selector_me};
    private ViewPager vp;
    private TabLayout tab_layout;
    private MainTabFragmentAdapter adapter;

    @Override
    public void initViews() {
        vp = findViewById(R.id.vp);
        tab_layout = findViewById(R.id.tab_layout);
    }

    @Override
    public void initDatas() {
        adapter = new MainTabFragmentAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
    }

    @Override
    public void initListener() {
        tab_layout.setupWithViewPager(vp);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition(), false);
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
