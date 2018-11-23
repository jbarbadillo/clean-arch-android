package com.javirock.cleanarchevents.application;


import android.app.Application;

import com.javirock.cleanarchevents.di.component.ApplicationComponent;
import com.javirock.cleanarchevents.di.module.NetworkModule;

public class UserApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule(this, ""))
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return this.applicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
