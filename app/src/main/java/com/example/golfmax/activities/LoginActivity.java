package com.example.golfmax.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.golfmax.R;
import com.example.golfmax.backend.UserRepository;
import com.example.golfmax.contracts.LoginContract;
import com.example.golfmax.databinding.ActivityLoginBinding;
import com.example.golfmax.models.User;
import com.example.golfmax.presenters.LoginPresenter;
import com.example.golfmax.requests.LoginRequest;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends Activity implements LoginContract.View {

    TextInputLayout tilUsername, tilPassword;
    public static String staticUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_login);

        LoginPresenter presenter = new LoginPresenter(this);
        User user = new User();

        binding.setUser(user);
        binding.setPresenter(presenter);

        tilUsername = findViewById(R.id.text_input_layout_username);
        tilPassword = findViewById(R.id.text_input_layout_password);
    }

    @Override
    public void loginUser(@NonNull User user) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(user.getUsername());
        loginRequest.setPassword(user.getPassword());

        staticUsername = user.getUsername();
        Log.i("STATIC USERNAME ====> ", staticUsername);

        UserRepository userRepository = new UserRepository();

        userRepository.loginUser(loginRequest, tilUsername,
                tilPassword, LoginActivity.this);
    }

    public void goToRegistrationActivity(View view) {
        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }
}