package com.javirock.cleanarchevents.application;


import android.app.Application;

import com.javirock.cleanarchevents.di.component.ApplicationComponent;

public class UserApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        applicationComponent = DaggerApplicationComponent().build
    }
}
