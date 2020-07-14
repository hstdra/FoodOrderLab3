package com.example.lab3_hongocvinhhan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab3_hongocvinhhan.R;
import com.example.lab3_hongocvinhhan.cores.User;
import com.example.lab3_hongocvinhhan.databases.UserService;

public class LoginActivity extends AppCompatActivity {
    private UserService userService;
    private EditText phoneNumber;
    private EditText password;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userService = new UserService(this);
        phoneNumber = findViewById(R.id.phoneNumberText);
        password = findViewById(R.id.passwordText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = userService.getUserByPhoneNumber(phoneNumber.getText().toString());

                if (user != null && user.getPassword().equals(password.getText().toString())) {
                    UserService.user = user;
                    startActivity(new Intent(getBaseContext(), HomeActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Phone or password not correct!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}