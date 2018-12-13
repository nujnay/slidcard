package com.nujnay.slidcard;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FollowBehavior extends CoordinatorLayout.Behavior<View> {

    public FollowBehavior() {

    }
    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d("onDependcdd", "222");
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        Log.d("onDependcdd", "333");
        return dependency instanceof TestView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Log.d("onDependcdd", "1111111");
        child.setX(dependency.getX());
        child.setY(dependency.getY() + 100);
        return true;
    }
}
