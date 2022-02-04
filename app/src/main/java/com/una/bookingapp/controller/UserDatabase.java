package com.una.bookingapp.controller;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.una.bookingapp.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
