package com.example.golfmaxfinal.activities;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


import com.example.golfmaxfinal.R;
import com.example.golfmaxfinal.backend.ApiClient;
import com.example.golfmaxfinal.contracts.RegistrationContract;
import com.example.golfmaxfinal.databinding.ActivityRegistrationBinding;
import com.example.golfmaxfinal.models.User;
import com.example.golfmaxfinal.presenters.RegistrationPresenter;
import com.example.golfmaxfinal.requests.RegistrationRequest;
import com.example.golfmaxfinal.responses.RegistrationResponse;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends Activity implements RegistrationContract.View {

    TextInputLayout tilUsername, tilEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActivityRegistrationBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);
        RegistrationPresenter presenter = new RegistrationPresenter(this, getApplicationContext());
        User user = new User("", "", "");
        binding.setUser(user);
        binding.setPresenter(presenter);

        tilUsername = (TextInputLayout) findViewById(R.id.text_input_layout_username);
        tilEmail = (TextInputLayout) findViewById(R.id.text_input_layout_email);
    }

    @Override
    public void registerUser(@NonNull User user) {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setUsername(user.getUsername());
        registrationRequest.setPassword(user.getPassword());
        registrationRequest.setEmail(user.getEmail());

        Log.i("REGISTRATION REQUEST > ", registrationRequest.toString());

        ApiCallRegisterUser(registrationRequest);
    }

    private void ApiCallRegisterUser(RegistrationRequest registrationRequest) {
        Call<RegistrationResponse> registrationResponseCall = ApiClient.getApiInterface().registerUser(registrationRequest);

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
                    tilUsername.setError("Existing username.");
                    tilEmail.setError("Existing email.");
                    Toast.makeText(RegistrationActivity.this, "Registration failed.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Toast.makeText(RegistrationActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goToLoginActivity(View view) {
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}