package com.javirock.cleanarchevents.businesslayer.repositories;

import com.javirock.cleanarchevents.storage.UserRepositoryInteractor;

public interface UserRepository {
    void getUserListing(UserRepositoryInteractor userRepositoryInteractor);
    void cancelUser(String user_id);
}
