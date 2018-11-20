package com.javirock.cleanarchevents.businesslayer.interactors;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.businesslayer.repositories.UserRepository;

public class UserInteractor implements UserInterface {
    CallBack callBack;
    UserRepository userRepository;

    public UserInteractor(CallBack callBack, UserRepository userRepository){
        this.callBack = callBack;
        this.userRepository = userRepository;
    }
    public void getUser(String user_id){
        UserModel user = userRepository.getUser(user_id);

        if(user == null){
            callBack.onUserRetrievedFailed("Registration failed");
            return;
        }
        callBack.onUserRetrieved(user);
    }

}
