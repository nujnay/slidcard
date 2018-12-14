package com.nujnay.slidcard;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;


import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CoordinatorLayout cl_main;
    TestView observer;
    TestView behavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //跟随者 注册行动
        cl_main = findViewById(R.id.cl_main);
        observer = findViewById(R.id.observer);
        FollowBehavior followBehavior = new FollowBehavior();
        CoordinatorLayout.LayoutParams params =
                (CoordinatorLayout.LayoutParams) observer.getLayoutParams();
        params.setBehavior(followBehavior);


        behavior = findViewById(R.id.behavior);
        CoordinatorLayout.LayoutParams params2 =
                (CoordinatorLayout.LayoutParams) observer.getLayoutParams();
        params2.setBehavior(followBehavior);


    }

    public void swichPostion(View v1, View v2) {
        cl_main.removeAllViews();
        cl_main.addView(v1);
        cl_main.addView(v2);
    }
}
