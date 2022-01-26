package com.una.bookingapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.una.bookingapp.R;

public class NewHotelForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hotel_form);

        init();
    }
    public void init(){

        name = findViewById(R.id.editTextHotelName);






    }





    EditText name;
    EditText state;
    EditText address;
    int star;


}