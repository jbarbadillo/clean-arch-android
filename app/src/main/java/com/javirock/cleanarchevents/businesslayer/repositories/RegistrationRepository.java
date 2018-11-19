package com.javirock.cleanarchevents.businesslayer.repositories;


import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;

public interface RegistrationRepository {
    void registerUser(RegistrationModel data);
    void cancelUser();
    void updateUser();
}
