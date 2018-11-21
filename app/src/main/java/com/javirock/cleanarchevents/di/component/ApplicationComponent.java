package com.javirock.cleanarchevents.di.component;

import android.content.Context;

import com.javirock.cleanarchevents.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = NetworkModule.class)
public interface ApplicationComponent {
    Retrofit exposeRetrofit();
    Context exposeContext();

}
