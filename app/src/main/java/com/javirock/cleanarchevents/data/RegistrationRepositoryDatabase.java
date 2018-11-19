package com.javirock.cleanarchevents.data;


import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;
import com.javirock.cleanarchevents.businesslayer.repositories.RegistrationRepository;

public class RegistrationRepositoryDatabase implements RegistrationRepository {
    @Override
    public void registerUser(RegistrationModel data) {
        // TODO create areal user registration
        // TODO return response?
    }

    @Override
    public void cancelUser(String user_id) {

    }

    @Override
    public void updateUser(String user_id, RegistrationModel data) {

    }


}
