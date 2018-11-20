package com.javirock.cleanarchevents.businesslayer.interactors;

import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;
import com.javirock.cleanarchevents.businesslayer.repositories.RegistrationRepository;


public class RegistrationInteractor implements RegistrationInterface {
    CallBack callBack;
    RegistrationRepository registrationRepository;
    public RegistrationInteractor(CallBack callBack, RegistrationRepository registrationRepository){
        this.callBack = callBack;
        this.registrationRepository = registrationRepository;
    }
    public void requestRegistration(RegistrationModel data){
        final String user_id = registrationRepository.registerUser(data);

        if(user_id == null){
            callBack.onRegistrationFailed("Registration failed");
            return;
        }
        callBack.onRegistration(user_id);

    }
}

