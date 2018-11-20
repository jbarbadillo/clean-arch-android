package com.javirock.cleanarchevents.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.javirock.cleanarchevents.businesslayer.models.UserModel;

@Database(entities = UserModel.class, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase INSTANCE;
    public abstract UserDAO userDAO();

    public static UserDatabase getUserDatabaseInstance(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(
                    context.getApplicationContext(),
                    UserDatabase.class,
                    "user").
                    allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

}
