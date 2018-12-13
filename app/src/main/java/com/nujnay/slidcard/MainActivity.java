package com.nujnay.slidcard;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.behavior).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    view.setX(motionEvent.getRawX() - view.getWidth() / 2);
                    view.setY(motionEvent.getRawY() - view.getHeight() / 2);
                }
                return true;
            }
        });

//        findViewById(R.id.right).setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
//                    view.setX(motionEvent.getRawX() - view.getWidth() / 2);
//                    view.setY(motionEvent.getRawY() - view.getHeight() / 2);
//                }
//                return true;
//            }
//        });
    }
}
