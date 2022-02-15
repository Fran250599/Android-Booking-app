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
        registerButton = findViewById(R.id.registerButton);
        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);

        setLoginButton();
        setRegisterButton();
    }

    public void setLoginButton() {
        loginButton.setOnClickListener((View v) -> {

            String usernameStr = username.getText().toString();
            String passwordStr = password.getText().toString();

            new Thread(() -> {
                //Will get the whole list of Users to verify the input
                List<User> users = UserController.getInstance(getApplication()).getUsers();

                //Searching for credentials
                for (User user : users) {
                    //If there is any coincidence will enter the admin system
                    if (usernameStr.equals("admin") && passwordStr.equals("admin")) {
                        Intent intent = new Intent(this, MainAdminActivity.class);
                        startActivity(intent);
                    }
                    //If there is any coincidence will enter a user system
                    else if (user.getUsername().equals(usernameStr) && user.getPassword().equals(passwordStr)) {

                        Intent intent = new Intent(this, MainUserActivity.class);
                        startActivity(intent);
                    } else {
                        runOnUiThread(() -> {
                            username.setError("Invalido");
                            password.setError("Invalido");
                        });
                    }
                }
            }).start();
        });
    }

    public void setRegisterButton() {
        registerButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
        });
    }

    Button loginButton;
    Button registerButton;
    EditText username;
    EditText password;

}