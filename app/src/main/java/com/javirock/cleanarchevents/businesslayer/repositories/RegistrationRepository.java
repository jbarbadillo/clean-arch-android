package com.javirock.cleanarchevents.businesslayer.repositories;


import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;

public interface RegistrationRepository {
    String registerUser(RegistrationModel data);
    void cancelUser(String user_id);
    void updateUser(String user_id, RegistrationModel data);
}
