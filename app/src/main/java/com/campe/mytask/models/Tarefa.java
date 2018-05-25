package com.campe.mytask.models;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by campe on 21/04/18.
 */

public class Tarefa {
    private String description;

    private Boolean done;

    public Tarefa(String name, Boolean status) {
        this.description = name;
        this.done = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}