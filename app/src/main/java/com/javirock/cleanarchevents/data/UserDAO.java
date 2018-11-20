package com.javirock.cleanarchevents.data;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.javirock.cleanarchevents.businesslayer.models.UserModel;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM user WHERE user_id LIKE :user_id LIMIT 1")
    UserModel getUser(String user_id);

    @Insert(onConflict = REPLACE)
    void insertUser(UserModel user);

    @Delete
    void deleteUser(UserModel user);

}
