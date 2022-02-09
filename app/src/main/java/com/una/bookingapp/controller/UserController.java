package com.una.bookingapp.controller;

import android.app.Application;

import androidx.room.Room;

import com.una.bookingapp.model.User;

import java.util.List;

public class UserController {

    private UserController(Application app){
        userDB = Room.databaseBuilder(app.getApplicationContext(),
                UserDatabase.class, "users-db").build();
    }

    public void addUser(User user){
        userDB.userDao().insert(user);
    }


    public List<User> getUsers(){
        return userDB.userDao().getAll();
    }

    public User loginUser(User user){
        if(userDB.userDao().getUser(user.getId()) != null){
            return userDB.userDao().getUser(user.getId());
        }
        return null;
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
