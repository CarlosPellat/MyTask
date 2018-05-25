package com.campe.mytask.utils;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.campe.mytask.daos.TaskDao;
import com.campe.mytask.daos.UserDao;
import com.campe.mytask.models.Task;
import com.campe.mytask.models.User;

/**
 * Created by campe on 21/04/18.
 */

@Database(entities = {User.class, Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String databaseName = "my_tasks_app";

    private static AppDatabase instance;
    public abstract UserDao userDao();
    public abstract TaskDao taskDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null || !instance.isOpen()) {
            instance = Room.databaseBuilder(context, AppDatabase.class, databaseName)
                    .build();
        }
        return instance;
    }
}