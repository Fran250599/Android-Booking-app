package com.una.bookingapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.una.bookingapp.R;
import com.una.bookingapp.controller.UserController;
import com.una.bookingapp.model.User;

import java.util.List;


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

                if(username.getText().toString().equals("") || password.getText().toString().equals("")){
                    if (username.getText().toString().equals("")) {
                        username.setError("Vacio");

                    }else if(password.getText().toString().equals("")){
                        password.setError("Vacio");
                    }
                }

                else{
                    String usernameStr = username.getText().toString();
                    String passwordStr = password.getText().toString();

                    User user = new User(usernameStr, passwordStr);

                    InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    new Thread( () -> {

                        try {
                            long n = System.currentTimeMillis();
                            synchronized (this) {

                                List<User> users = UserController.getInstance(getApplication()).getUsers();
                                boolean validUser= true;

                                for(User auxUser : users){

                                    if(auxUser.getUsername().equals(user.getUsername())){

                                        runOnUiThread( () -> {
                                            username.setError("Nombre de usuario ya existente. Por favor intente con otro.");
                                        });
                                        validUser = false;
                                    }
                                }

                                if(validUser == true){
                                    //UserController.getInstance(getApplication()).addUser(user);

                                    Snackbar snackbar = Snackbar.make(v, "Nuevo usuario agregado", Snackbar.LENGTH_SHORT);
                                    snackbar.show();

                                    System.out.println("waiting...");
                                    this.wait(3000); // change this to wait less, more, or indefinitely

                                    Intent intent = new Intent(this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                            System.out.println("waited for " + (System.currentTimeMillis() - n) + "ms");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            });
        });
    }

    EditText username;
    EditText password;
    Button registerButton;
}