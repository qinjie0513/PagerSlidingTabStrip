package com.qinjie.pagerslidingtabstrip.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import com.qinjie.pagerslidingtabstrip.PagerSlidingTabStrip;

public class TabIconTextPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.ViewTabProvider {

    private Context mContext;
    private final int PAGE_COUNT;
    private int mLayout;
    private TabPagerListener mListener;

    public interface TabPagerListener{
        Fragment getFragment(int position);
    }

    public void setListener(TabPagerListener listener) {
        this.mListener = listener;
    }

    public TabIconTextPagerAdapter(Context context, FragmentManager fm, int page_count, int layout) {
        super(fm);
        if (page_count <= 0){
            throw new ExceptionInInitializerError("page_count value error");
        }
        this.mContext = context;
        this.PAGE_COUNT = page_count;
        this.mLayout = layout;
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
    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(mLayout, null);
        return view;
    }

}
