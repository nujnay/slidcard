package com.nujnay.slidcard;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FollowBehavior extends CoordinatorLayout.Behavior<View> {
    private int leftTop_Y_Max = ScreenTools.dp2px(Myapplication.myapplication, 32);
    private int leftTop_X_Max = ScreenTools.dp2px(Myapplication.myapplication, 23);
    private int parentWith = ScreenTools.getScreenWidth() - ScreenTools.dp2px(Myapplication.myapplication, 13) * 2;
    private int yLengthMix = ScreenTools.dp2px(Myapplication.myapplication, 134);
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

        float childRightBottomY = yLengthMix + ((yLengthMix -dependencyHeight ))+(yChangeTotalLength-(dependencyY-dependencyHeight));
        float childRightBottomX = parentWith - (leftTop_X_Max - dependencyX);

        child.layout((int) childLeftTopX, (int) childLeftTopY, (int) childRightBottomX, (int) childRightBottomY);

        Log.d("dependencyXdd", dependencyX + "||"
                + dependencyY + "||"
                + dependencyWidth + "||"
                + dependencyHeight + "||"
        );
        return true;
    }
}
