package com.javirock.cleanarchevents.data;


import android.content.Context;

import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;
import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.businesslayer.repositories.RegistrationRepository;

public class RegistrationRepositoryDatabase implements RegistrationRepository {
    Context context;
    public RegistrationRepositoryDatabase(Context context){
        this.context = context;
    }
    @Override
    public String registerUser(RegistrationModel data) {
        UserModel user = new UserModel();
        user.setUserName(data.getUserName());
        user.setPassword(data.getPassword());
        user.setEmail(data.getEmail());
        user.setUser_id(1);

        createUser(user);
        return "1";
    }

    @Override
    public void cancelUser(String user_id) {

    }

    @Override
    public void updateUser(String user_id, RegistrationModel data) {

    }
    private void createUser(UserModel user){
        UserDatabase database = UserDatabase.getUserDatabaseInstance(context);
        database.userDAO().insertUser(user);
    }

}
