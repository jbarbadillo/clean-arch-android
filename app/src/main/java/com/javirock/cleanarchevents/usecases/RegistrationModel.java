package com.javirock.cleanarchevents.usecases;

import com.javirock.cleanarchevents.entities.RegistrationData;
import com.javirock.cleanarchevents.entities.RegistrationRepository;

public class RegistrationModel {
    public void requestRegistration(RegistrationData data, RegistrationRepository registrationRepository){
        registrationRepository.registerUser(data);
    }
}

