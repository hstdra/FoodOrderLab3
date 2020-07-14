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

public class SignUpActivity extends AppCompatActivity {
    private UserService userService;
    private EditText phoneNumber;
    private EditText password;
    private EditText confirm;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userService = new UserService(this);
        phoneNumber = findViewById(R.id.phoneNumberText);
        password = findViewById(R.id.passwordText);
        confirm = findViewById(R.id.confirmText);
        signUpButton = findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = userService.getUserByPhoneNumber(phoneNumber.getText().toString());

                if (!password.getText().toString().equals(confirm.getText().toString())) {
                    Toast.makeText(SignUpActivity.this, "Password does not match!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (user != null) {
                    Toast.makeText(SignUpActivity.this, "This phone number is already existing!", Toast.LENGTH_SHORT).show();
                } else {
                    userService.addUser(phoneNumber.getText().toString(), password.getText().toString());
                    UserService.user = new User(phoneNumber.getText().toString(), password.getText().toString());
                    startActivity(new Intent(getBaseContext(), HomeActivity.class));
                }
            }
        });
    }
}