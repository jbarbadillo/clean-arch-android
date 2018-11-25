package com.javirock.cleanarchevents.storage;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;

import java.util.List;

public interface UserRepositoryInteractor {
    void onError(String error);
    void onUserCreated(String user_id);
    void onUsersRetrieved(List<UserModel> userList);
}
