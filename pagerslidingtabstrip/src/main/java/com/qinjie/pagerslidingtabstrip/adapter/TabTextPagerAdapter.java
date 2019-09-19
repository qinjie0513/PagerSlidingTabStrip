package com.qinjie.pagerslidingtabstrip.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabTextPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT;
    private String[] mTitles;
    private TabPagerListener mListener;

    public interface TabPagerListener{
        Fragment getFragment(int position);
    }

    public void setListener(TabPagerListener listener) {
        this.mListener = listener;
    }

    public TabTextPagerAdapter(FragmentManager fm, int page_count, String[] titles) {
        super(fm);
        if (titles == null || titles.length == 0){
            throw new ExceptionInInitializerError("titles can't be null or empty");
        }
        if (page_count <= 0){
            throw new ExceptionInInitializerError("page_count value error");
        }
        this.PAGE_COUNT = page_count;
        this.mTitles = titles;
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
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

}
