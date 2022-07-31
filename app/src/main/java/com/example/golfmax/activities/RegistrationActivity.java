package com.example.golfmax.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.golfmax.backend.UserRepository;
import com.example.golfmax.contracts.RegistrationContract;
import com.example.golfmax.models.User;
import com.example.golfmax.presenters.RegistrationPresenter;
import com.example.golfmax.requests.RegistrationRequest;
import com.example.golfmaxfinal.R;
import com.example.golfmaxfinal.databinding.ActivityRegistrationBinding;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends Activity implements RegistrationContract.View {

    TextInputLayout textInputLayoutUsername, textInputLayoutEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActivityRegistrationBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_registration);

        RegistrationPresenter presenter = new RegistrationPresenter(this);

        User user = new User();
        binding.setUser(user);
        binding.setPresenter(presenter);

        textInputLayoutUsername = findViewById(R.id.text_input_layout_username);
        textInputLayoutEmail = findViewById(R.id.text_input_layout_email);
    }

    @Override
    public void registerUser(@NonNull User user) {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setUsername(user.getUsername());
        registrationRequest.setPassword(user.getPassword());
        registrationRequest.setEmail(user.getEmail());

        UserRepository userRepository = new UserRepository();
        userRepository.registerUser(registrationRequest, textInputLayoutUsername,
                textInputLayoutEmail, RegistrationActivity.this);
    }

    public void goToLoginActivity(View view) {
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}