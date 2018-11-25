package com.javirock.cleanarchevents.application;


import android.app.Application;

import com.javirock.cleanarchevents.di.component.ApplicationComponent;
import com.javirock.cleanarchevents.di.component.DaggerApplicationComponent;
import com.javirock.cleanarchevents.di.module.NetworkModule;

public class MainApplication extends Application {
    private ApplicationComponent applicationComponent;
    private static String BASE_URL = "https://api.github.com";

    @Override
    public void onCreate() {
        super.onCreate();

        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule(this, BASE_URL))
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
