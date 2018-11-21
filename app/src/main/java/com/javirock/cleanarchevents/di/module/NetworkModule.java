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
    OkHttpClient provideOkkHttpClient2(){
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }
    @Singleton
    @Provides
    Retrofit providesRetrofit(@Named("ok-1") OkHttpClient client,
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
    Context providesContext(){return context;}
}

