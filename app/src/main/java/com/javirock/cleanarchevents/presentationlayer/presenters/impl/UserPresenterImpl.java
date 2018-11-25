package com.javirock.cleanarchevents.presentationlayer.presenters.impl;


import com.javirock.cleanarchevents.businesslayer.interactors.UserInteractor;
import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.businesslayer.repositories.UserRepository;
import com.javirock.cleanarchevents.storage.UserRepositoryInteractor;
import com.javirock.cleanarchevents.presentationlayer.presenters.UserPresenter;

public class UserPresenterImpl implements UserPresenter, UserInteractor.CallBack{
    UserPresenter.View view;
    UserRepository userRepository;
    UserInteractor userInteractor;

    public UserPresenterImpl(View view, UserRepository userRepository, UserRepositoryInteractor userRepositoryInteractor){
        this.view = view;
        this.userRepository = userRepository;
        this.userInteractor = new UserInteractor(this, userRepository, userRepositoryInteractor);
    }
    @Override
    public void onCancelClicked() {

    }

    @Override
    public void onResume() {
        userInteractor.getUser("1");
    }

    @Override
    public void onUserRetrieved(UserModel user) {
        view.renderUser(user);
    }

    @Override
    public void onUserRetrievedFailed(String error) {
        view.showError(error);
    }

    @Override
    public void onUserCancelled() {

    }

    @Override
    public void onUserCancelledFailed(String error) {

    }
}
