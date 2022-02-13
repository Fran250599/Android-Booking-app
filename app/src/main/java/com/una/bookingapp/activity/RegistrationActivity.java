package com.una.bookingapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.una.bookingapp.R;
import com.una.bookingapp.controller.UserController;
import com.una.bookingapp.model.User;


public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        init();
    }

    public void init() {
        username = findViewById(R.id.editTextRegisterUsername);
        password = findViewById(R.id.editTextRegisterTextPassword);
        registerButton = findViewById(R.id.registerButtonConfirmation);

        registerButtonConfirmation();

    }

    public void registerButtonConfirmation() {
        registerButton.setOnClickListener((View v) -> {

            runOnUiThread(() -> {
                if (username.getText().toString().equals("") && password.getText().toString().equals("")) {
                    username.setError("Vacio");
                    password.setError("Vacio");
                } else {
                    String usernameStr = username.getText().toString();
                    String passwordStr = password.getText().toString();

                    User user = new User(usernameStr, passwordStr);

                    /*new Thread( () -> {
                        UserController.getInstance(getApplication()).addUser(user);
                    }).start();
*/

                }


            });


        });

    }

    EditText username;
    EditText password;
    Button registerButton;
}