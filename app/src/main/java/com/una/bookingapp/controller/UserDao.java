package com.una.bookingapp.controller;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.una.bookingapp.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    void insert(User ... users);



}
