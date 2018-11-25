package com.javirock.cleanarchevents.storage;


import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;
import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.businesslayer.repositories.UserRepository;
import com.javirock.cleanarchevents.storage.api.UserApiService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static io.reactivex.internal.operators.observable.ObservableBlockingSubscribe.subscribe;

public class UserListingRepository implements UserRepository, Observer<UserModel> {
    UserRepositoryInteractor userRepositoryInteractor;
    List<UserModel> userModelList = new ArrayList<>();

    @Inject
    protected UserApiService userApiService;

    @Inject
    public UserListingRepository(){

    }
    @Override
    public void getUserListing(UserRepositoryInteractor userRepositoryInteractor) {
        this.userRepositoryInteractor = userRepositoryInteractor;

        Observable<UserModel> userModelObservable = userApiService.getUsers(1, 1);
        subscribe(userModelObservable, this);

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
        userModelList.add(userModel);
    }

    @Override
    public void onError(Throwable e) {
        userRepositoryInteractor.onError(e.getMessage());
    }

    @Override
    public void onComplete() {
        userRepositoryInteractor.onUsersRetrieved(userModelList);
    }
}
