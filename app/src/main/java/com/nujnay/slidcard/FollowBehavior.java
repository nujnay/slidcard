package com.nujnay.slidcard;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FollowBehavior extends CoordinatorLayout.Behavior<TestView> {

    /**
     * 构造方法
     */
    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TestView child, View dependency) {
        return dependency instanceof TestView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TestView child, View dependency) {
        child.setX(dependency.getX());
        child.setY(dependency.getY() + 100);
        return true;
    }
}
