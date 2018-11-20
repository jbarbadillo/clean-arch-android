package com.javirock.cleanarchevents.presentationlayer.presenters;


public interface RegistrationPresenter {
    void onRegisterClicked(String userName, String password, String email);
    interface View{
        void showProgress();
        void hideProgress();
        void showError(String error);
    }

}
