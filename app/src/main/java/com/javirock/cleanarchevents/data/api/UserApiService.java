package com.javirock.cleanarchevents.data.api;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserApiService {

    //With Rx Java
    @GET("/user")
    Observable<UserModel> getUser();

}
