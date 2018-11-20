package com.javirock.cleanarchevents.presentationlayer.presenters;


import com.javirock.cleanarchevents.businesslayer.models.UserModel;

public interface UserPresenter {
    void onCancelClicked();
    void onResume();
    interface View{
        void showProgress();
        void hideProgress();
        void showError(String error);
        void nextScreen();
        void renderUser(UserModel user);
    }

}
