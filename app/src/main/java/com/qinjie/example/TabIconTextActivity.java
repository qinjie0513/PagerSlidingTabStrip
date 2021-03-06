package com.qinjie.example;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.qinjie.pagerslidingtabstrip.PagerSlidingTabStrip;
import com.qinjie.pagerslidingtabstrip.adapter.TabIconPagerAdapter;
import com.qinjie.pagerslidingtabstrip.adapter.TabIconTextPagerAdapter;

public class TabIconTextActivity extends AppCompatActivity implements TabIconTextPagerAdapter.TabPagerListener {

    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;

    private TabIconTextPagerAdapter mAdapter;

    private final String[] mTitles = {"Tab0", "Tab1", "Tab2", "Tab3"};
    private final int[] mIconDefault = {R.mipmap.icon_home, R.mipmap.icon_financing, R.mipmap.icon_study, R.mipmap.icon_person};
    private final int[] mIconChoosed = {R.mipmap.icon_home_pre, R.mipmap.icon_financing_pre, R.mipmap.icon_study_pre, R.mipmap.icon_person_pre};

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

        //设置布局样式
        mPagerSlidingTabStrip.setIconAndText(PagerSlidingTabStrip.TABICONTEXT);
        //设置文本
        mPagerSlidingTabStrip.setTabTexts(mTitles);
        //设置未选择的图标
        mPagerSlidingTabStrip.setNormalIconRes(mIconDefault);
        //设置已选择的图标
        mPagerSlidingTabStrip.setLightIconRes(mIconChoosed);
    }

    private void initViewPager() {
        mAdapter = new TabIconTextPagerAdapter(this, getSupportFragmentManager(), 4, R.layout.view_tab_icon_text);
        mAdapter.setListener(this);
        mViewPager.setAdapter(mAdapter);
        mPagerSlidingTabStrip.setViewPager(mViewPager);
    }

    @Override
    public Fragment getFragment(int position) {
        return ExampleFragment.newInstance(position);
    }

}
