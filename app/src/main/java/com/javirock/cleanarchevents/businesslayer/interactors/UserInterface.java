package com.javirock.cleanarchevents.businesslayer.interactors;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;

import java.util.List;

public interface UserInterface {
    interface CallBack{
        void onUsersRetrieved(List<UserModel> userList);
        void onUsersRetrievedFailed(String error);
        void onUserCancelled();
        void onUserCancelledFailed(String error);
    }
}
