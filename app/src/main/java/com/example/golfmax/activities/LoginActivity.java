package com.example.golfmax.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.golfmax.backend.SharedPreferencesManager;
import com.example.golfmax.backend.UserRepository;
import com.example.golfmax.contracts.LoginContract;
import com.example.golfmax.applicationIntents.GolfMaxIntents;
import com.example.golfmax.models.User;
import com.example.golfmax.presenters.LoginPresenter;
import com.example.golfmax.requests.LoginRequest;
import com.example.golfmax.R;
import com.example.golfmax.databinding.ActivityLoginBinding;

public class LoginActivity extends Activity implements LoginContract.View {

    private ActivityLoginBinding binding;
    private GolfMaxIntents golfMaxIntents = new GolfMaxIntents(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeWindowFeature();

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_login);

        LoginPresenter presenter = new LoginPresenter(this);
        User user = new User();

        binding.setUser(user);
        binding.setPresenter(presenter);
    }

    private void removeWindowFeature() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void loginUser(@NonNull User user) {
        LoginRequest loginRequest = new LoginRequest();
        UserRepository userRepository = new UserRepository();
        loginRequest.setUsername(user.getUsername());
        loginRequest.setPassword(user.getPassword());
        SharedPreferencesManager
                .getInstance(LoginActivity.this)
                .setUsername(user.getUsername());
        String username = SharedPreferencesManager.getInstance(LoginActivity.this).getUsername();

        Log.i("SHARED PREF USERNAME > ", username);

        userRepository.loginUser(loginRequest,
                binding.textInputLayoutUsername,
                binding.textInputLayoutPassword,
                LoginActivity.this);
    }

    public void goToRegistrationActivity(View view) {
        golfMaxIntents.goToLoginActivity();
    }
}