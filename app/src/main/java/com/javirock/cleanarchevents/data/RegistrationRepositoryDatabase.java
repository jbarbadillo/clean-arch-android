package com.javirock.cleanarchevents.data;


import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;
import com.javirock.cleanarchevents.businesslayer.models.UserModel;
import com.javirock.cleanarchevents.businesslayer.repositories.RegistrationRepository;

public class RegistrationRepositoryDatabase implements RegistrationRepository {
    @Override
    public String registerUser(RegistrationModel data) {
        // TODO create a real user registration
        // TODO return response?
        return "";
    }

    @Override
    public void cancelUser(String user_id) {

    }

    @Override
    public void updateUser(String user_id, RegistrationModel data) {

    }

    private static void populateUser(UserDatabase database){
        UserModel userModel = new UserModel();
        userModel.setEmail("email1");
        userModel.setPassword("pass");
        userModel.setUserName("monguer");
        addUser(database, userModel);
    }

    private static void addUser(UserDatabase database, UserModel userModel) {
        database.userDAO().insertUser(userModel);
    }
}
