package com.qinjie.pagerslidingtabstrip;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class CommonTabPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private final int PAGE_COUNT;
    private List<String> mList;
    private TabPagerListener mListener;

    public interface TabPagerListener{
        Fragment getFragment(int position);
    }

    public void setListener(TabPagerListener listener) {
        this.mListener = listener;
    }

    public CommonTabPagerAdapter(FragmentManager fm, int count, List<String> list, Context context) {
        super(fm);
        if (list == null || list.isEmpty()){
            throw new ExceptionInInitializerError("list can't be null or empty");
        }
        if (count <= 0){
            throw new ExceptionInInitializerError("count value error");
        }
        this.PAGE_COUNT = count;
        this.mList = list;
        this.mContext = context;
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
        return mList.get(position);
    }

}
