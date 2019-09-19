package com.qinjie.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTabText;
    private Button mBtnTabIcon;
    private Button mBtnTabIconText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initClicks();
    }

    private void initViews() {
        mBtnTabText = findViewById(R.id.btn_tab_text);
        mBtnTabIcon = findViewById(R.id.btn_tab_icon);
        mBtnTabIconText = findViewById(R.id.btn_tab_icon_text);
    }

    private void initClicks() {
        mBtnTabText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabTextActivity.class);
                startActivity(intent);
            }
        });
        mBtnTabIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabIconActivity.class);
                startActivity(intent);
            }
        });
        mBtnTabIconText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabIconTextActivity.class);
                startActivity(intent);
            }
        });
    }

}
