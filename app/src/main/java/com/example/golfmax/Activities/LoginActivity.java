package com.example.golfmax.Activities;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.golfmax.Backend.ApiClient;
import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Requests.LoginRequest;
import com.example.golfmax.Responses.LoginResponse;
import com.example.golfmax.R;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout tiUsername, tiPassword;
    Button btnForgotPassword, btnLogin, btnRegister;
    LoginRequest loginRequest;
    DBHelper db;
    public static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        loginRequest = new LoginRequest();
        db = new DBHelper(LoginActivity.this);

        tiUsername = findViewById(R.id.text_input_username);
        tiPassword = findViewById(R.id.text_input_password);

        btnForgotPassword = findViewById(R.id.button_forgot_password);
        btnLogin = findViewById(R.id.button_sign_in);
        btnRegister = findViewById(R.id.button_create_Account);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = tiUsername.getEditText().getText().toString();
                String password = tiPassword.getEditText().getText().toString();

                if (TextUtils.isEmpty(username)) {
                    tiUsername.setError("Do not leave empty.");
                }
                if (TextUtils.isEmpty(password)) {
                    tiPassword.setError("Do not leave empty.");
                }
                else {
                    loginRequest.setUsername(username);
                    loginRequest.setPassword(password);
                    loginUser(loginRequest);
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser(LoginRequest loginRequest) {
        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class).putExtra("data", loginResponse));
                    db.saveUser(loginResponse.getUsername(), loginResponse.getId());
                    username = loginResponse.getUsername();
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