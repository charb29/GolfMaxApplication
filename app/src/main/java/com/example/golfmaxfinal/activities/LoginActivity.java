package com.example.golfmaxfinal.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.golfmaxfinal.R;
import com.example.golfmaxfinal.backend.ApiClient;
import com.example.golfmaxfinal.backend.DBHelper;
import com.example.golfmaxfinal.contracts.LoginContract;
import com.example.golfmaxfinal.databinding.ActivityLoginBinding;
import com.example.golfmaxfinal.models.User;
import com.example.golfmaxfinal.presenters.LoginPresenter;
import com.example.golfmaxfinal.requests.LoginRequest;
import com.example.golfmaxfinal.responses.LoginResponse;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity implements LoginContract.View {

    TextInputLayout tilUsername, tilPassword;
    public static String username;

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

        tilUsername = (TextInputLayout) findViewById(R.id.text_input_layout_username);
        tilPassword = (TextInputLayout) findViewById(R.id.text_input_layout_password);
    }

    @Override
    public void loginUser(@NonNull User user) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(user.getUsername());
        loginRequest.setPassword(user.getPassword());

        ApiCallLogin(loginRequest);
    }

    private void ApiCallLogin(LoginRequest loginRequest) {
        Call<LoginResponse> loginResponseCall = ApiClient.getApiInterface().loginUser(loginRequest);


        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call,
                                   @NonNull Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (response.isSuccessful()) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    DBHelper db = new DBHelper(getApplicationContext());

                    assert loginResponse != null;
                    Log.i("USER INFO FROM LOGIN > ", loginResponse.toString());

                    username = loginResponse.getUsername();
                    db.saveUser(loginResponse.getUsername(), loginResponse.getId());
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalid credentials.",
                            Toast.LENGTH_SHORT).show();

                    tilUsername.setError("Enter a valid username.");
                    tilPassword.setError("Enter a valid password.");
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call,
                                  @NonNull Throwable t) {
                Log.e("LOGIN ERROR > ", t.toString());
            }
        });
    }

    public void goToRegistrationActivity(View view) {
        Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }
}