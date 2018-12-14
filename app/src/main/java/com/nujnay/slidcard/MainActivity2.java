package com.nujnay.slidcard;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    CoordinatorLayout cl_main;
    TestView observer;
    TestView behavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
