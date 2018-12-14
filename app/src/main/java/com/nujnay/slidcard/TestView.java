package com.nujnay.slidcard;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class TestView extends FrameLayout {
    private Context context;
    private int lastY = 0;

    private int leftTop_Y_Max = ScreenTools.dp2px(Myapplication.myapplication, 32);
    private int RightBottom_Y_Min = ScreenTools.dp2px(Myapplication.myapplication, 134);
    private int yChangeTotalLength = ScreenTools.dp2px(Myapplication.myapplication, 20);
    private int yLengthMix = ScreenTools.dp2px(Myapplication.myapplication, 134);
    private int yLengthMax = ScreenTools.dp2px(Myapplication.myapplication, 154);
    private int RightBottom_Y_Max = ScreenTools.dp2px(Myapplication.myapplication, 186);

    private int leftTop_X_Max = ScreenTools.dp2px(Myapplication.myapplication, 23);
    private int xChangeTotalLength = ScreenTools.dp2px(Myapplication.myapplication, 23);

    private int parentWith = ScreenTools.getScreenWidth() - ScreenTools.dp2px(Myapplication.myapplication, 13) * 2;

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
                if (getTop() + offsetY <= 0) {//最上
                    layout(leftTop_X_Max, 0, parentWith - xChangeTotalLength, RightBottom_Y_Min);
                } else if (getBottom() + offsetY >= RightBottom_Y_Max) {//最下
                    layout(0, leftTop_Y_Max, parentWith, RightBottom_Y_Max);
                } else {
                    int leftTopCurrent = getTop() + offsetY;
                    double currentChangeRate = (double) leftTopCurrent / (double) leftTop_Y_Max;

                    double currentChangeLengthY = currentChangeRate * yChangeTotalLength;
                    double currentLengthY = currentChangeLengthY + yLengthMix;
                    double rightBottom_Y_Current = currentLengthY + leftTopCurrent;

                    double currentChangeLengX = (double) xChangeTotalLength * (1d - currentChangeRate);

                    layout((int) currentChangeLengX, getTop() + offsetY, (int) (parentWith - currentChangeLengX), (int) rightBottom_Y_Current);

                    for (int i = 0; i < getChildCount(); i++) {
                        View view = getChildAt(i);
                        view.setScaleX((float) currentLengthY / (float) yLengthMax);
                        view.setScaleY((float) currentLengthY / (float) yLengthMax);
                        view.setAlpha((float) (0.2d + (0.8d * currentChangeRate)));
                    }
                }
                break;
        }
        return true;
    }

}