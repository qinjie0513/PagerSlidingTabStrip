package com.qinjie.pagerslidingtabstrip.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qinjie.pagerslidingtabstrip.PagerSlidingTabStrip;

public class TabIconPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {

    private final int PAGE_COUNT;
    private int[] mIcons;
    private TabPagerListener mListener;

    public interface TabPagerListener{
        Fragment getFragment(int position);
    }

    public void setListener(TabPagerListener listener) {
        this.mListener = listener;
    }

    public TabIconPagerAdapter(FragmentManager fm, int page_count, int[] icons) {
        super(fm);
        if (icons == null || icons.length == 0){
            throw new ExceptionInInitializerError("icons can't be null or empty");
        }
        if (page_count <= 0){
            throw new ExceptionInInitializerError("page_count value error");
        }
        this.PAGE_COUNT = page_count;
        this.mIcons = icons;
    }

    @Override
    public Fragment getItem(int position) {
        return mListener.getFragment(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public int getPageIconResId(int position) {
        return mIcons[position];
    }

}
