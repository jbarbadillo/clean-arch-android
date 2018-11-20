package com.javirock.cleanarchevents.businesslayer.interactors;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;

public interface UserInterface {
    interface CallBack{
        void onUserRetrieved(UserModel user);
        void onUserRetrievedFailed(String error);
        void onUserCancelled();
        void onUserCancelledFailed(String error);
    }
}
