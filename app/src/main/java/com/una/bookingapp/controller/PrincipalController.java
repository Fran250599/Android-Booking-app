package com.una.bookingapp.controller;

import android.app.Application;

import androidx.room.Room;

import com.una.bookingapp.model.Hotel;

public class PrincipalController {

    private PrincipalController(Application app){
        db = Room.databaseBuilder(app.getApplicationContext(),
                HotelDatabase.class,
                "hoteles-db")
                .build();

    }

    public void addHotel(Hotel hotel){
        db.hotelDao().insert(hotel);
    }



    private static PrincipalController instance;
    private HotelDatabase db;

    public static PrincipalController getInstance(Application app){
        if(instance == null){
            instance = new PrincipalController(app);
            return instance;
        }
        return instance;
    }
}
