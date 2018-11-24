package com.javirock.cleanarchevents.data;


import android.content.Context;

import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;
import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.businesslayer.repositories.UserRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserRepositoryDatabase implements UserRepository, Observer<UserModel> {
    Context context;
    public UserRepositoryDatabase(Context context){
        this.context = context;
    }

    @Override
    public UserModel getUser(String user_id) {
        UserDatabase database = UserDatabase.getUserDatabaseInstance(context);
        UserModel user = database.userDAO().getUser(1);
        return user;
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

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
