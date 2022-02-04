package com.una.bookingapp.controller;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.una.bookingapp.model.Hotel;

import java.util.List;


@Dao
public interface HotelsDao {
    @Query("SELECT * FROM hotel")
    List<Hotel> getAll();

    @Query("Select * from hotel where id=:id")
    Hotel getHotel(int id);

    @Insert
    void insert(Hotel... hotel);

    @Delete
    void delete(Hotel hotel);



}
