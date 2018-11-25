package com.javirock.cleanarchevents.businesslayer.interactors;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.businesslayer.repositories.UserRepository;
import com.javirock.cleanarchevents.storage.UserRepositoryInteractor;

public class UserInteractor implements UserInterface, UserRepositoryInteractor {
    CallBack callBack;
    UserRepository userRepository;
    UserRepositoryInteractor userRepositoryInteractor;

    public UserInteractor(CallBack callBack, UserRepository userRepository, UserRepositoryInteractor userRepositoryInteractor){
        this.callBack = callBack;
        this.userRepository = userRepository;
        this.userRepositoryInteractor = userRepositoryInteractor;
    }
    public void getUser(String user_id){
        userRepository.getUser(userRepositoryInteractor, user_id);
    }
    @Override
    public void onError(String error) {

    }

    @Override
    public void onUserCreated(String user_id) {

    }
    @Override
    public void onUserRetrieved(UserModel user) {
        if(user == null){
            callBack.onUserRetrievedFailed("Registration failed");
            return;
        }
        callBack.onUserRetrieved(user);
    }
}
