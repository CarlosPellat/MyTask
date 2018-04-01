package com.example.campe.mytask.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by campe on 21/03/2018.
 */

@Entity
public class User  {
        @PrimaryKey
        private int uid;

        @ColumnInfo(name = "user_name")
        private String username;

        @ColumnInfo(name = "senha")
        private String senha;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    // Getters and setters are ignored for brevity,
        // but they're required for Room to work.
}
