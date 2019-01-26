package com.javirock.cleanarchevents.presentationlayer.presenters.impl;


import com.javirock.cleanarchevents.businesslayer.interactors.UserInteractor;
import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.businesslayer.repositories.UserRepository;
import com.javirock.cleanarchevents.storage.UserRepositoryInteractor;
import com.javirock.cleanarchevents.presentationlayer.presenters.UserPresenter;

import java.util.List;

public class UserPresenterImpl implements UserPresenter, UserInteractor.CallBack{
    UserPresenter.View view;
    UserRepository userRepository;
    UserInteractor userInteractor;

    public UserPresenterImpl(View view, UserRepository userRepository){
        this.view = view;
        this.userRepository = userRepository;
        this.userInteractor = new UserInteractor(this, userRepository);
    }
    @Override
    public void onCancelClicked() {

    }
    @Override
    public void onResume() {
        userInteractor.getUsers();
    }

    @Override
    public void onUsersRetrieved(List<UserModel> userList) {
        view.renderUsers(userList);
    }
    @Override
    public void onUsersRetrievedFailed(String error) {
        view.showError(error);
    }

    @Override
    public void onUserCancelled() {

    }
    @Override
    public void onUserCancelledFailed(String error) {

    }
}
