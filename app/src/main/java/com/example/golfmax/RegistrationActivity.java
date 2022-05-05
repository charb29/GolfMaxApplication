package com.example.golfmax;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends AppCompatActivity {

    TextInputLayout textInputUsername, textInputEmail, textInputPassword;
    Button registerButton, returningMemberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registration);

        textInputUsername = findViewById(R.id.enterUsername);
        textInputPassword = findViewById(R.id.enterPassword);
        textInputEmail = findViewById(R.id.enterEmail);
        registerButton = findViewById(R.id.btnRegister);
        returningMemberButton = findViewById(R.id.btnAlreadyMember);
        DBHelper db = new DBHelper(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = textInputUsername.getEditText().getText().toString();
                String password = textInputPassword.getEditText().getText().toString();
                String email = textInputEmail.getEditText().getText().toString();

                if (TextUtils.isEmpty(username)) {
                    textInputUsername.setError("Do not leave empty");
                }
                else if (TextUtils.isEmpty(password)) {
                    textInputPassword.setError("Do not leave empty");
                }
                else if (TextUtils.isEmpty(email)) {
                    textInputEmail.setError("Do not leave empty");
                }

                Boolean validateEmail = db.validateEmail(email);
                if (!validateEmail) {
                    boolean insert = db.registerUser(username, password, email);
                    if (insert) {
                        Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);

                        textInputUsername.getEditText().setText("");
                        textInputPassword.getEditText().setText("");
                        textInputEmail.getEditText().setText("");
                    }
                    else {
                        Toast.makeText(RegistrationActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(RegistrationActivity.this, "Existing user, please sign in", Toast.LENGTH_SHORT).show();
                    textInputEmail.setError("Existing user");
                }
            }
        });

        returningMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}