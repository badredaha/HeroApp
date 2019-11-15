package com.crea.heroapp;

import android.app.Application;

import com.crea.heroapp.workers.DBManager;

public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DBManager.getInstance().initDataBase(this);
    }
}
