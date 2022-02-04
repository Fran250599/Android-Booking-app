package com.una.bookingapp.controller;

import android.app.Application;

import androidx.room.Room;

import com.una.bookingapp.model.User;

public class UserController {

    private UserController(Application app){
        userDB = Room.databaseBuilder(app.getApplicationContext(),
                UserDatabase.class, "users-db").build();
    }

    public void addUser(User user){
        userDB.userDao().insert(user);
    }


    private UserDatabase userDB;
    private static UserController instance;
    public static UserController getInstance(Application app){
        if(instance == null){
            instance = new UserController(app);
            return instance;
        }
        return instance;
    }
}
