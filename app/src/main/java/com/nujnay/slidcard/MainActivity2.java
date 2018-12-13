package com.nujnay.slidcard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TestView behavior = findViewById(R.id.behavior);
        FollowBehavior followBehavior = new FollowBehavior();
        CoordinatorLayout.LayoutParams params =
                (CoordinatorLayout.LayoutParams) behavior.getLayoutParams();
        params.setBehavior(followBehavior);
    }
}
