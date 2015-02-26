package com.theguardian.guardianquiz;

import android.app.Application;
import android.content.Context;

public class QuizApplication extends Application {
    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }
}
