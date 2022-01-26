package com.una.bookingapp.controller;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.una.bookingapp.model.Hotel;
import com.una.bookingapp.model.HotelDao;

@Database(entities = {Hotel.class}, version = 1)
public abstract class HotelDatabase extends RoomDatabase {
    public abstract HotelDao hotelDao();
}