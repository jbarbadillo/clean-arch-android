package com.javirock.cleanarchevents.entities;



public interface RegistrationRepository {
    void registerUser(RegistrationData data);
    void cancelUser();
    void updateUser();
}
