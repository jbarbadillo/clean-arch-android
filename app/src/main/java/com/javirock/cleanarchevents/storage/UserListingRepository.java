package com.javirock.cleanarchevents.storage;


import android.util.Log;

import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.businesslayer.repositories.UserRepository;
import com.javirock.cleanarchevents.storage.api.UserApiService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


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
        Log.i("clean", "getting users");
        userModelList.clear();
        Observable<List<UserModel>> userModelObservable = userApiService.getUsers();
        subscribe(userModelObservable, this);
    }
    protected <T> void subscribe(Observable<List<T>> observable, Observer<T> observer){
        observable.subscribeOn(Schedulers.newThread())
                .flatMapIterable(item -> item)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void cancelUser(String user_id) {

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
        Log.i("clean", "error observable " + e.getMessage().toString());
        userRepositoryInteractor.onError(e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.i("clean", "completed "+userModelList.size());
        userRepositoryInteractor.onUsersRetrieved(userModelList);
    }
}
