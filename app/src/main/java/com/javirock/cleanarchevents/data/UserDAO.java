package com.javirock.cleanarchevents.data;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.javirock.cleanarchevents.businesslayer.models.UserModel;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM user")
    UserModel getUser();

    @Insert
    void insertUser(UserModel user);

    @Delete
    void deleteUser(UserModel user);

}
