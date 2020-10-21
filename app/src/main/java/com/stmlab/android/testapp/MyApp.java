package com.stmlab.android.testapp;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

public class MyApp extends Application {

    public static final String STORAGE_NAME = "StorageName";
    public static final String COUNTER_TAG = "Counter";


    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences sharedPreferences = getSharedPreferences(STORAGE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int counter = 0;
        counter = sharedPreferences.getInt(COUNTER_TAG, 0);
        editor.putInt(COUNTER_TAG, ++counter);
        editor.commit();
        Log.d("testLog", "MyApp.onCreate "+ counter);
    }
}
