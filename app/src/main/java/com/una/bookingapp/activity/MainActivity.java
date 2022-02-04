package com.una.bookingapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.una.bookingapp.R;
import com.una.bookingapp.controller.HotelController;
import com.una.bookingapp.controller.UserController;
import com.una.bookingapp.model.User;


//This will be a login screen
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
    }

    public void init() {
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, MainPageActivity.class);

            HotelController.getInstance(getApplication());
            startActivity(intent);
        });

    }
}