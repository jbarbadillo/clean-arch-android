package com.javirock.cleanarchevents.storage.api;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserApiService {
    @GET("/users")
    Observable<List<UserModel>> getUsers();

    //With Rx Java
    @GET("/user/{id}")
    Observable<UserModel> getUser(@Path("id") String user_id);

    @POST("/user")
    Observable<String> postUser(UserModel user);

}
