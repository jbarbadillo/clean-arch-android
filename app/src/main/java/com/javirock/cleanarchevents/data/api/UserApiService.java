package com.javirock.cleanarchevents.data.api;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.di.module.UserModule;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserApiService {
    @GET("/users")
    public Call<List<UserModel>> getUsers(
            @Query("per_page") int per_page,
            @Query("page") int page
    );
    //With Rx Java
    @GET("/user/{id}")
    Observable<UserModel> getUser(@Path("id") String user_id);

    @POST("/user")
    Observable<String> postUser(UserModel user);

}
