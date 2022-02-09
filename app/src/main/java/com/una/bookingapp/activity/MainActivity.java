package com.una.bookingapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.una.bookingapp.R;
import com.una.bookingapp.controller.HotelController;
import com.una.bookingapp.controller.UserController;
import com.una.bookingapp.model.User;

import java.util.List;


//This will be a login screen
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
    }

    public void init() {
        loginButton = findViewById(R.id.loginButton);
        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);

        loginButton.setOnClickListener((View v) -> {

            String usernameStr = username.getText().toString();
            String passwordStr = password.getText().toString();

            new Thread(()->{

                List<User> users = UserController.getInstance(getApplication()).getUsers();

                for(User user : users){

                    if(user.getUsername().equals(usernameStr) && user.getPassword().equals(passwordStr)){
                        Intent intent = new Intent(this, MainPageActivity.class);

                        HotelController.getInstance(getApplication());
                        startActivity(intent);
                    }
                }
            }).start();
            //username.setError("Invalido");
            //password.setError("Invalido");
        });
    }

    Button loginButton;
    EditText username;
    EditText password;
}