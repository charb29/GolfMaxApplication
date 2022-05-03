package com.example.golfmax;

import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.view.menu.ShowableListMenu;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends AppCompatActivity {

    TextInputLayout username, email, password;
    Button register, returningMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registration);

        username = findViewById(R.id.enterUsername);
        password = findViewById(R.id.enterPassword);
        email = findViewById(R.id.enterEmail);
        register = findViewById(R.id.btnRegister);
        returningMember = findViewById(R.id.btnAlreadyMember);
        DBHelper db = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getEditText().getText().toString();
                String pass = password.getEditText().getText().toString();
                String userEmail = email.getEditText().getText().toString();

                if (TextUtils.isEmpty(user)) {
                    username.setError("Do not leave empty");
                }
                else if (TextUtils.isEmpty(pass)) {
                    password.setError("Do not leave empty");
                }
                else if (TextUtils.isEmpty(userEmail)) {
                    email.setError("Do not leave empty");
                }

                Boolean checkUser = db.checkUserEmail(userEmail);
                if (!checkUser) {
                    boolean insert = db.addUserInfo(user, pass, userEmail);
                    if (insert) {
                        Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        username.getEditText().setText("");
                        password.getEditText().setText("");
                        email.getEditText().setText("");
                    }
                    else {
                        Toast.makeText(RegistrationActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(RegistrationActivity.this, "Existing user, please sign in", Toast.LENGTH_SHORT).show();
                    email.setError("Existing user");
                }
            }
        });

        returningMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}