package com.una.bookingapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import com.una.bookingapp.R;
import com.una.bookingapp.controller.HotelController;
import com.una.bookingapp.model.Hotel;


public class NewHotelForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hotel_form);

        init();
    }

    public void init() {

        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener((View v) -> {
            name = findViewById(R.id.editTextHotelName);
            state = findViewById(R.id.editTextHotelState);
            address = findViewById(R.id.editTextHotelAddress);

            Hotel hotel = new Hotel(name.getText().toString(), state.getText().toString(), address.getText().toString());

            new Thread(() -> {
                HotelController.getInstance(getApplication()).addHotel(hotel);
            }).start();


        });


    }


    EditText name;
    EditText state;
    EditText address;


}