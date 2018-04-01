package com.example.campe.mytask.utils;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.campe.mytask.models.User;
import com.example.campe.mytask.daos.UserDao;

/**
 * Created by campe on 21/03/2018.
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
}
