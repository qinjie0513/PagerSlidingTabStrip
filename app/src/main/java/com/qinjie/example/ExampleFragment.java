package com.qinjie.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ExampleFragment extends Fragment {

    protected View mView;

    private TextView mTextView;

    public static ExampleFragment newInstance(int position) {
        ExampleFragment fragment = new ExampleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("PARAM_POSITION", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_example, null);
        mTextView = mView.findViewById(R.id.textview);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTextView.setText("fragment" + getArguments().getInt("PARAM_POSITION"));
    }

}
