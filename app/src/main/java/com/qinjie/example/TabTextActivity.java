package com.qinjie.example;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.qinjie.pagerslidingtabstrip.adapter.TabTextPagerAdapter;
import com.qinjie.pagerslidingtabstrip.PagerSlidingTabStrip;

public class TabTextActivity extends AppCompatActivity implements TabTextPagerAdapter.TabPagerListener {

    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;

    private TabTextPagerAdapter mAdapter;

    private final String[] mTitles = {"Tab0", "Tab1", "Tab2", "Tab3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initViews();
        setTabsValue();
        initViewPager();
    }

    private void initViews() {
        mPagerSlidingTabStrip = findViewById(R.id.pagerSlidingTabStrip);
        mViewPager = findViewById(R.id.viewPager);
    }

    private void setTabsValue() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        // 设置文字类型
        mPagerSlidingTabStrip.setTypeface(null, Typeface.NORMAL);
        // 设置Tab底部选中的指示器的颜色
        mPagerSlidingTabStrip.setIndicatorColor(getResources().getColor(R.color.color_1897F2));
        // 设置Tab底部指示器的颜色
        mPagerSlidingTabStrip.setUnderlineColor(Color.TRANSPARENT);
        // 设置Tab间的分割线的颜色
        mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT);
        // 设置Tab选中的文字的颜色
        mPagerSlidingTabStrip.setSelectedTextColor(getResources().getColor(R.color.color_1897F2));
        // 设置Tab文字的颜色
        mPagerSlidingTabStrip.setTextColor(getResources().getColor(R.color.color_313131));
        // 设置指示点的颜色
        mPagerSlidingTabStrip.setDotColor(getResources().getColor(R.color.color_FF3300));
        // 设置Tab的背景色
        mPagerSlidingTabStrip.setTabBackground(Color.TRANSPARENT);
        // 设置Tab底部选中的指示器的高度
        mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2.0f, dm));
        // 设置Tab底部指示器的高度
        mPagerSlidingTabStrip.setUnderlineHeight(0);
        // 设置Tab间的分割线的上下padding
        mPagerSlidingTabStrip.setDividerPadding(0);
        // 设置Tab间的分割线的宽度
        mPagerSlidingTabStrip.setDividerWidth(0);
        // 设置Tab的左右padding
        mPagerSlidingTabStrip.setTabPaddingLeftRight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20.0f, dm));
        // 设置Tab底部指示器相对被选中的标签的偏移
        mPagerSlidingTabStrip.setScrollOffset(0);
        // 设置Tab的文字大小
        mPagerSlidingTabStrip.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab是否自动填充满屏幕
        mPagerSlidingTabStrip.setShouldExpand(true);
        // Tab文字大小写
        mPagerSlidingTabStrip.setAllCaps(false);
        // 设置Tab底部指示器是否跟文字宽度一致
        mPagerSlidingTabStrip.setIndicatorinFollower(true);
    }

    private void initViewPager() {
        mAdapter = new TabTextPagerAdapter(getSupportFragmentManager(), 4, mTitles);
        mAdapter.setListener(this);
        mViewPager.setAdapter(mAdapter);
        mPagerSlidingTabStrip.setViewPager(mViewPager);

        mPagerSlidingTabStrip.setDot(0, true);
        mPagerSlidingTabStrip.setDot(2, true);
        //mPagerSlidingTabStrip.clearAllDots();
    }

    @Override
    public Fragment getFragment(int position) {
        return ExampleFragment.newInstance(position);
    }

}
