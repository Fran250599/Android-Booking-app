package com.una.bookingapp.controller;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.una.bookingapp.model.Hotel;

import com.una.bookingapp.model.HotelsDao;

@Database(entities = {Hotel.class}, version = 1)
public abstract class HotelDatabase extends RoomDatabase {
    public abstract HotelsDao hotelDao();
}