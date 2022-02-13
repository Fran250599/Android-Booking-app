package com.una.bookingapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.una.bookingapp.R;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        init();
    }

    public void init(){
        username = findViewById(R.id.editTextRegisterUsername);
        password = findViewById(R.id.editTextRegisterTextPassword);
        registerButton = findViewById(R.id.registerButtonConfirmation);

    }

    EditText username;
    EditText password;
    Button registerButton;
}