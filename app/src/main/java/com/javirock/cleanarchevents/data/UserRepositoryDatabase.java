package com.javirock.cleanarchevents.data;


import android.content.Context;

import com.javirock.cleanarchevents.businesslayer.interactors.UserInteractor;
import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;
import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.businesslayer.repositories.UserRepository;
import com.javirock.cleanarchevents.data.api.UserApiService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static io.reactivex.internal.operators.observable.ObservableBlockingSubscribe.subscribe;

public class UserRepositoryDatabase implements UserRepository, Observer<UserModel> {
    UserRepositoryInteractor userRepositoryInteractor;
    UserModel user;

    @Inject
    protected UserApiService userApiService;

    @Inject
    public UserRepositoryDatabase(){

    }
    @Override
    public void getUser(UserRepositoryInteractor userRepositoryInteractor, String user_id) {
        this.userRepositoryInteractor = userRepositoryInteractor;
        Observable<UserModel> userModelObservable = userApiService.getUser(user_id);
        subscribe(userModelObservable, this);
        //UserDatabase database = UserDatabase.getUserDatabaseInstance(context);
        //UserModel user = database.userDAO().getUser(1);
    }


    @Override
    public void cancelUser(String user_id) {

    }

    @Override
    public void updateUser(String user_id, RegistrationModel data) {

    }

    //reactivex methods
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(UserModel userModel) {
        user = userModel;
    }

    @Override
    public void onError(Throwable e) {
        userRepositoryInteractor.onError(e.getMessage());
    }

    @Override
    public void onComplete() {
        userRepositoryInteractor.onUserRetrieved(user);
    }
}
