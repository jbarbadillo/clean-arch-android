package com.javirock.cleanarchevents.data.api;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.di.module.UserModule;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApiService {

    //With Rx Java
    @GET("/user")
    Observable<UserModel> getUser();

    @POST("/user")
    Observable postUser(UserModel user);

}
