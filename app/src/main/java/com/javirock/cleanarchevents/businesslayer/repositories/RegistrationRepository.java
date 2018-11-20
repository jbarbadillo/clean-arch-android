package com.javirock.cleanarchevents.businesslayer.repositories;


import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;

public interface RegistrationRepository {
    String registerUser(RegistrationModel data);
}
