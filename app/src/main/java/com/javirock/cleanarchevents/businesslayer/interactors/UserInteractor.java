package com.javirock.cleanarchevents.businesslayer.interactors;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.businesslayer.repositories.UserRepository;
import com.javirock.cleanarchevents.data.UserRepositoryInteractor;

public class UserInteractor implements UserInterface {
    CallBack callBack;
    UserRepository userRepository;
    UserRepositoryInteractor userRepositoryInteractor;

    public UserInteractor(CallBack callBack, UserRepository userRepository, UserRepositoryInteractor userRepositoryInteractor){
        this.callBack = callBack;
        this.userRepository = userRepository;
        this.userRepositoryInteractor = userRepositoryInteractor;
    }
    public void getUser(String user_id){
        UserModel user = userRepository.getUser(userRepositoryInteractor, user_id);

        if(user == null){
            callBack.onUserRetrievedFailed("Registration failed");
            return;
        }
        callBack.onUserRetrieved(user);
    }

}
