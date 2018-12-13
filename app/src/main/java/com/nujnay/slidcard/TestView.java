package com.nujnay.slidcard;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Scroller;
import android.widget.TextView;

public class TestView extends FrameLayout {
    Context context;
    int lastY = 0;
    int maxY = 200;

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //检测到触摸事件后 第一时间得到相对于父控件的触摸点坐标 并赋值给x,y
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            //触摸事件中绕不开的第一步，必然执行，将按下时的触摸点坐标赋值给 lastX 和 last Y
            case MotionEvent.ACTION_DOWN:
                lastY = y;
                break;
            //触摸事件的第二步，这时候的x,y已经随着滑动操作产生了变化，用变化后的坐标减去首次触摸时的坐标得到 相对的偏移量
            case MotionEvent.ACTION_MOVE:
                int offsetY = y - lastY;
                //使用 layout 进行重新定位
                Log.d("getTopgetTop", getTop() + "");
                if (getTop() + offsetY <= 0) {
                    layout(getLeft(), 0, getRight(), ScreenTools.dp2px(context, 145));
                } else if (getBottom() + offsetY >= ScreenTools.dp2px(context, 186)) {
                    layout(getLeft(), ScreenTools.dp2px(context, 41), getRight(), ScreenTools.dp2px(context, 186));
                } else {
                    layout(getLeft(), getTop() + offsetY, getRight(), getBottom() + offsetY);
                }

//                if (getBottom() + offsetY >= ScreenTools.dp2px(context, 186)) {
//                    layout(getLeft(), ScreenTools.dp2px(context, 41), getRight(), ScreenTools.dp2px(context, 186));
//                } else {
//                    layout(getLeft(), getTop() + offsetY, getRight(), getBottom() + offsetY);
//                }
                break;
        }
        return true;
    }

}