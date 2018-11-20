package com.javirock.cleanarchevents.presentationlayer.views;


public interface RegistrationView {
    void showProgress();
    void hideProgress();
    void showError(String error);
}
