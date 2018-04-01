package com.example.campe.mytask.activities;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.campe.mytask.utils.AppDatabase;

/**
 * Created by campe on 21/03/2018.
 */

public class MinhaApplicacao extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
    }
}
