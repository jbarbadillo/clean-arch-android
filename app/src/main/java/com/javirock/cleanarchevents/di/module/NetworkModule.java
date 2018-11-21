package com.javirock.cleanarchevents.di.module;

import android.content.Context;

import dagger.Module;

@Module
public class NetworkModule {
    private String baseUrl;
    private Context context;

    public NetworkModule(Context context, String baseUrl){
        this.baseUrl = baseUrl;
        this.context = context;
    }
}

