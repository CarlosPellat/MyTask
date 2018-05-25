package com.campe.mytask.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.campe.mytask.models.Task;
import com.campe.mytask.models.User;

import java.util.List;

/**
 * Created by campe on 21/04/18.
 */

@Dao
public interface TaskDao {
    @Query("SELECT * FROM task")
    List<Task> getAll();

    @Insert
    void insertAll(Task... tasks);

    @Delete
    void delete(Task task);
}