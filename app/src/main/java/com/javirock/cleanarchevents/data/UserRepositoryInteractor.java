package com.javirock.cleanarchevents.data;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;

public interface UserRepositoryInteractor {
    void onError(String error);
    void onUserCreated(String user_id);
    void onUserRetrieved(UserModel user);
}
