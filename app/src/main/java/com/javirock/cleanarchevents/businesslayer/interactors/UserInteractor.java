package com.javirock.cleanarchevents.businesslayer.interactors;


import android.util.Log;

import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.businesslayer.repositories.UserRepository;
import com.javirock.cleanarchevents.storage.UserRepositoryInteractor;

import java.util.List;

public class UserInteractor implements UserInterface, UserRepositoryInteractor {
    CallBack callBack;
    UserRepository userRepository;

    public UserInteractor(CallBack callBack, UserRepository userRepository){
        this.callBack = callBack;
        this.userRepository = userRepository;
    }
    public void getUsers(){
        userRepository.getUserListing(this);
    }
    @Override
    public void onError(String error) {

    }
    @Override
    public void onUserCreated(String user_id) {

    }
    @Override
    public void onUsersRetrieved(List<UserModel> userList) {
        if(userList == null){
            callBack.onUsersRetrievedFailed("Registration failed");
            return;
        }
        Log.i("clean", "on users retrieved " + userList.size());
        callBack.onUsersRetrieved(userList);
    }
}
