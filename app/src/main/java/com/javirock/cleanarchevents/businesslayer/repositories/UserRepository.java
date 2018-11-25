package com.javirock.cleanarchevents.businesslayer.repositories;

import com.javirock.cleanarchevents.businesslayer.models.RegistrationModel;
import com.javirock.cleanarchevents.storage.UserRepositoryInteractor;

public interface UserRepository {
    void getUser(UserRepositoryInteractor userRepositoryInteractor, String user_id);
    void cancelUser(String user_id);
    void updateUser(String user_id, RegistrationModel data);
}
