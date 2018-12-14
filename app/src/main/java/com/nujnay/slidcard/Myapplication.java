package com.nujnay.slidcard;

import android.app.Application;

public class Myapplication extends Application {
    public static Myapplication myapplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myapplication = this;
    }
}
