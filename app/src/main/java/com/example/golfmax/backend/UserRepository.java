package com.example.golfmax.backend;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.golfmax.activities.HomeActivity;
import com.example.golfmax.activities.LoginActivity;
import com.example.golfmax.models.User;
import com.example.golfmax.requests.LoginRequest;
import com.example.golfmax.requests.RegistrationRequest;
import com.example.golfmax.responses.LoginResponse;
import com.example.golfmax.responses.RegistrationResponse;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    public User getUserInfoById(long userId) {
        User user = new User();
        Call<User> userResponseCall = GolfMaxHttpClient
                .getApiInterface()
                .getUserInfoById(userId);

        userResponseCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call,
                                   @NonNull Response<User> response) {
                assert response.body() != null;

                user.setUsername(response.body().getUsername());
                user.setEmail(response.body().getEmail());
                user.setPassword(response.body().getPassword());

                Log.i("GET USER INFO BY ID => ", user.toStringUsername());
                Log.i("GET USER INFO BY ID => ", user.toStringEmail());
                Log.i("GET USER INFO BY ID => ", user.toStringPassword());
            }

            @Override
            public void onFailure(@NonNull Call<User> call,
                                  @NonNull Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
        return user;
    }

    public void updateUserInfo(@NonNull User user,
                               @NonNull Context context) {
        Call<User> userResponseCall = GolfMaxHttpClient
                .getApiInterface()
                .updateUserInfo(user.getId(), user);

        userResponseCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call,
                                   @NonNull Response<User> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context.getApplicationContext(),
                            "User info updated successfully.",
                            Toast.LENGTH_SHORT).show();

                    Log.i("UPDATED USER INFO ===> ", user.toStringUsername());
                    Log.i("UPDATED USER INFO ===> ", user.toStringEmail());
                    Log.i("UPDATED USER INFO ===> ", user.toStringPassword());
                } else {
                    Toast.makeText(context.getApplicationContext(),
                            "Update failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call,
                                  @NonNull Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
    }

    public void loginUser(LoginRequest loginRequest, TextInputLayout tilUsername,
                          TextInputLayout tilPassword, Context context) {
        Call<LoginResponse> loginResponseCall = GolfMaxHttpClient
                .getApiInterface()
                .loginUser(loginRequest);

        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call,
                                   @NonNull Response<LoginResponse> response) {

                LoginResponse loginResponse = response.body();

                if (response.isSuccessful()) {
                    GolfMaxLocalDatabase db = new GolfMaxLocalDatabase(context);
                    Intent intent = new Intent(context.getApplicationContext(), HomeActivity.class);

                    assert loginResponse != null;

                    Log.i("LOGIN INFO ====> ", loginResponse.toString());

                    db.saveUser(loginResponse.getUsername(), loginResponse.getId());
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context.getApplicationContext(),
                            "Invalid Credentials.",
                            Toast.LENGTH_SHORT).show();

                    tilUsername.setError("Invalid username.");
                    tilPassword.setError("Invalid password.");
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
    }

    public void registerUser(RegistrationRequest registrationRequest, TextInputLayout tilUsername,
                             TextInputLayout tilEmail, Context context) {
        Call<RegistrationResponse> registrationResponseCall = GolfMaxHttpClient
                .getApiInterface()
                .registerUser(registrationRequest);

        registrationResponseCall.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(@NonNull Call<RegistrationResponse> call,
                                   @NonNull Response<RegistrationResponse> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(context.getApplicationContext(),
                            "Registration successful.",
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
                    context.startActivity(intent);
                } else {
                    tilUsername.setError("Existing username.");
                    tilEmail.setError("Existing email.");

                    Toast.makeText(context.getApplicationContext(),
                            "Registration failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<RegistrationResponse> call, @NonNull Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
    }
}
