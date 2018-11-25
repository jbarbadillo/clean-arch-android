package com.javirock.cleanarchevents.di.module;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/*
This module is for providing dependencies of network.
All @Provides must belong to a @Module
 */
@Module
public class NetworkModule {
    private String baseUrl;
    private Context context;

    public NetworkModule(Context context, String baseUrl){
        this.baseUrl = baseUrl;
        this.context = context;
    }

    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }
    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    @Named("ok-1")
    OkHttpClient provideOkkHttpClient1(){
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }


    @Singleton
    @Provides
    Retrofit provideRetrofit(@Named("ok-1") OkHttpClient client,
                              GsonConverterFactory gsonConverterFactory,
                              RxJavaCallAdapterFactory rxJavaCallAdapterFactory){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .client(client)
                .build();


    }
    @Singleton
    @Provides
    Context provideContext(){return context;}
}

