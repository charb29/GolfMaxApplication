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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    // implement forgot password //

    TextInputLayout textInputUsername, textInputPassword;
    Button buttonForgotPassword, buttonLogin, buttonRegister;
    LoginRequest loginRequest = new LoginRequest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        textInputUsername = findViewById(R.id.username);
        textInputPassword = findViewById(R.id.password);

        buttonForgotPassword = findViewById(R.id.btnForgotPassword);
        buttonLogin = findViewById(R.id.btnSignIn);
        buttonRegister = findViewById(R.id.btnCreateAccount);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = textInputUsername.getEditText().getText().toString();
                String password = textInputPassword.getEditText().getText().toString();

                if (TextUtils.isEmpty(username)) {
                    textInputUsername.setError("Do not leave empty.");
                }
                if (TextUtils.isEmpty(password)) {
                    textInputPassword.setError("Do not leave empty.");
                }
                else {
                    loginRequest.setUsername(username);
                    loginRequest.setPassword(password);
                    loginUser(loginRequest);
                }
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    public void loginUser(LoginRequest loginRequest) {
        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class).putExtra("data", loginResponse));
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Login failed. Invalid username or password.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}