package com.nujnay.slidcard;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int lastX, lastY;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView behavior = findViewById(R.id.behavior);
        behavior.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        //将点下的点的坐标保存
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        //计算出需要移动的距离
                        int dx = (int) event.getRawX() - lastX;
                        int dy = (int) event.getRawY() - lastY;
                        //将移动距离加上，现在本身距离边框的位置
                        int left = view.getLeft() + dx;
                        int top = view.getTop() + dy;
                        //获取到layoutParams然后改变属性，在设置回去
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view
                                .getLayoutParams();
                        layoutParams.height = view.getHeight();
                        layoutParams.width = view.getWidth();
                        layoutParams.leftMargin = left;
                        layoutParams.topMargin = top;
                        view.setLayoutParams(layoutParams);
                        //记录最后一次移动的位置
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                        break;
                }
            }
        });
    }
}
