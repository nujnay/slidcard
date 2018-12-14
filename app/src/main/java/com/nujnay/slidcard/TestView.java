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

    int leftTopMax = ScreenTools.dp2px(Myapplication.myapplication, 32);
    int RightBottomMin = ScreenTools.dp2px(Myapplication.myapplication, 134);
    int yChangeTotalLength = ScreenTools.dp2px(Myapplication.myapplication, 20);
    int yLengthMix = ScreenTools.dp2px(Myapplication.myapplication, 134);

    int RightBottomMax = ScreenTools.dp2px(Myapplication.myapplication, 186);

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
                if (getTop() + offsetY <= 0) {
                    layout(getLeft(), 0, getRight(), RightBottomMin);
                } else if (getBottom() + offsetY >= RightBottomMax) {
                    layout(getLeft(), leftTopMax, getRight(), RightBottomMax);
                } else {
                    int leftTopCurrent = getTop() + offsetY;
                    double currentChangeRate = (double) leftTopCurrent / (double) leftTopMax;
                    double currentChangeLengthY = currentChangeRate * yChangeTotalLength;
                    double currentLengthY = currentChangeLengthY + yLengthMix;
                    double rightBottomcurrent = currentLengthY + leftTopCurrent;
                    layout(getLeft(), getTop() + offsetY, getRight(), (int) rightBottomcurrent);
                }
                break;
        }
        return true;
    }

}