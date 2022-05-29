package com.example.golfmax;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {

    TextInputLayout textInputUsername, textInputEmail, textInputPassword;
    Button buttonRegister, buttonReturningMember;
    RegistrationRequest registrationRequest = new RegistrationRequest();
    public static String username;

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

        buttonRegister = findViewById(R.id.btnRegister);
        buttonReturningMember = findViewById(R.id.btnAlreadyMember);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = textInputUsername.getEditText().getText().toString();
                String password = textInputPassword.getEditText().getText().toString();
                String email = textInputEmail.getEditText().getText().toString();

                if (TextUtils.isEmpty(username)) {
                    textInputUsername.setError("Do not leave empty.");
                }
                if (TextUtils.isEmpty(password)) {
                    textInputPassword.setError("Do not leave empty.");
                }
                if (TextUtils.isEmpty(email)) {
                    textInputEmail.setError("Do not leave empty.");
                }
                else {

                    registrationRequest.setUsername(username);
                    registrationRequest.setPassword(password);
                    registrationRequest.setEmail(email);

                    registrationRequest.getUsername();
                    registrationRequest.getPassword();
                    registrationRequest.getEmail();
                    registerUser(registrationRequest);
                }
            }
        });

        buttonReturningMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void registerUser(RegistrationRequest registrationRequest) {
        Call<RegistrationResponse> registrationResponseCall = ApiClient.getUserService().registerUser(registrationRequest);
        registrationResponseCall.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(RegistrationActivity.this, "Registration successful.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(RegistrationActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Toast.makeText(RegistrationActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}