package com.javirock.cleanarchevents.presentationlayer.presenters;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;

import java.util.List;

public interface UserPresenter {
    void onCancelClicked();
    void onResume();
    interface View{
        void showProgress();
        void hideProgress();
        void showError(String error);
        void nextScreen();
        void renderUsers(List<UserModel> userList);
    }

}
