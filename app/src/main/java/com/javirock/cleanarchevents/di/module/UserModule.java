package com.javirock.cleanarchevents.di.module;


import com.javirock.cleanarchevents.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class UserModule {

    public UserModule(){

    }

    @PerActivity
    @Provides
    UserApiService provideUserApiService(Retrofit retrofit){
        return retrofit.create(UserApiService.class);
    }
}
