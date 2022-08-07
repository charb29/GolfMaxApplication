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
import com.example.golfmax.models.GolfMaxIntents;
import com.example.golfmax.models.User;
import com.example.golfmax.presenters.RegistrationPresenter;
import com.example.golfmax.requests.RegistrationRequest;
import com.example.golfmax.R;
import com.example.golfmax.databinding.ActivityRegistrationBinding;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends Activity implements RegistrationContract.View {

    private TextInputLayout textInputLayoutUsername, textInputLayoutEmail;
    private GolfMaxIntents golfMaxIntents = new GolfMaxIntents(this);
    private ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeWindowFeature();

        RegistrationPresenter presenter = new RegistrationPresenter(this);
        User user = new User();

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_registration);

        textInputLayoutUsername = findViewById(R.id.text_input_layout_username);
        textInputLayoutEmail = findViewById(R.id.text_input_layout_email);

        binding.setUser(user);
        binding.setPresenter(presenter);
    }

    private void removeWindowFeature() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void registerUser(@NonNull User user) {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        UserRepository userRepository = new UserRepository();

        registrationRequest.setUsername(user.getUsername());
        registrationRequest.setPassword(user.getPassword());
        registrationRequest.setEmail(user.getEmail());

        userRepository.registerUser(registrationRequest,
                binding.textInputLayoutUsername,
                binding.textInputLayoutEmail,
                RegistrationActivity.this);
    }

    public void goToLoginActivity(View view) {
        golfMaxIntents.goToLoginActivity();
    }
}