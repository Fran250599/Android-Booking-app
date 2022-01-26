package com.una.bookingapp.controller;

import android.app.Application;

import androidx.room.Room;

import com.una.bookingapp.model.Hotel;

public class PrincipalController {

    public void addHotel(Hotel hotel){
        db.hotelDao().insert(hotel);
    }



    PrincipalController instance;
    HotelDatabase db;

    private PrincipalController getInstance(Application app){
        if(instance == null){
            instance = new PrincipalController();
            db = Room.databaseBuilder(app.getApplicationContext(),
                    HotelDatabase.class,
                    "hoteles-db")
                    .build();
            return instance;
        }
        return instance;
    }
}
