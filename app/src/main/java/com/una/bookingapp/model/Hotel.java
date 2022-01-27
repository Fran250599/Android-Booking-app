package com.una.bookingapp.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Hotel {

    public Hotel(String name, String state, String address) {
        this.id = 0;
        this.name = name;
        this.state = state;
        this.address = address;
    }

    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    private String name;
    private String state;
    private String address;

}
