package com.una.bookingapp.controller;

import android.app.Application;

import androidx.room.Room;

import com.una.bookingapp.model.Hotel;

import java.util.List;

public class HotelController {

    private HotelController(Application app) {
        hotelDB = Room.databaseBuilder(app.getApplicationContext(),
                HotelDatabase.class,
                "hoteles-db")
                .build();
    }

    public void addHotel(Hotel hotel) {
        hotelDB.hotelDao().insert(hotel);
    }

    public List<Hotel> getHotels(){
        return hotelDB.hotelDao().getAll();
    }

    private static HotelController instance;
    private HotelDatabase hotelDB;

    public static HotelController getInstance(Application app) {
        if (instance == null) {
            instance = new HotelController(app);
            return instance;
        }
        return instance;
    }
}
