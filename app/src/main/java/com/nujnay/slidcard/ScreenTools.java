package com.nujnay.slidcard;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.WindowManager;


public class ScreenTools {


    public static int dp2px(Context context, float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    public static int sp2px(int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                Resources.getSystem().getDisplayMetrics());
    }

    public static int getScreenWidth() {
        WindowManager wm = (WindowManager) Myapplication.myapplication
                .getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }
}
