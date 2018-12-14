package com.nujnay.slidcard;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

public class FollowBehavior extends CoordinatorLayout.Behavior<View> {
    private int leftTop_Y_Max = ScreenTools.dp2px(Myapplication.myapplication, 32);
    private int leftTop_X_Max = ScreenTools.dp2px(Myapplication.myapplication, 23);
    private int parentWith = ScreenTools.getScreenWidth() - ScreenTools.dp2px(Myapplication.myapplication, 13) * 2;
    private int yLengthMin = ScreenTools.dp2px(Myapplication.myapplication, 134);
    private int yChangeTotalLength = ScreenTools.dp2px(Myapplication.myapplication, 20);
    private int yLengthMax = ScreenTools.dp2px(Myapplication.myapplication, 154);

    public FollowBehavior() {

    }

    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof TestView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float dependencyX = dependency.getX();
        float dependencyY = dependency.getY();
        float dependencyWidth = dependency.getWidth();
        float dependencyHeight = dependency.getHeight();

        float childLeftTopY = leftTop_Y_Max - dependencyY;
        float childLeftTopX = leftTop_X_Max - dependencyX;

        float childRightBottomYBuffer = (((float) leftTop_Y_Max - dependencyY)) + ((float) yLengthMax - dependencyHeight);
        float childRightBottomY = (float) yLengthMin + childRightBottomYBuffer;
        float childRightBottomX = parentWith - (leftTop_X_Max - dependencyX);

        child.layout((int) childLeftTopX, (int) childLeftTopY, (int) childRightBottomX, (int) childRightBottomY);
        double currentChangeRate = childLeftTopX / leftTop_X_Max;
        double iamgeviewScaleRate = (childRightBottomY - childLeftTopY) / (float) yLengthMin;
        for (int i = 0; i < ((FrameLayout) child).getChildCount(); i++) {
            View view = ((FrameLayout) child).getChildAt(i);
            view.setScaleX((float) iamgeviewScaleRate);
            view.setScaleY((float) iamgeviewScaleRate);
            view.setAlpha((float) (0.2d + (0.8d * (1 - currentChangeRate))));
        }
        Log.d("dependencyXdd", dependencyX + "||"
                + dependencyY + "||"
                + dependencyWidth + "||"
                + dependencyHeight + "||"
                + currentChangeRate + "||"
        );
        return true;
    }
}
