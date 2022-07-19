package com.example.golfmaxfinal.backend;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.golfmaxfinal.activities.HomeActivity;
import com.example.golfmaxfinal.activities.LoginActivity;
import com.example.golfmaxfinal.models.PlayerStatistics;
import com.example.golfmaxfinal.models.User;
import com.example.golfmaxfinal.requests.LoginRequest;
import com.example.golfmaxfinal.requests.RegistrationRequest;
import com.example.golfmaxfinal.responses.LoginResponse;
import com.example.golfmaxfinal.responses.RegistrationResponse;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCallMethods {

    public ApiCallMethods() {}

    @NonNull
    public PlayerStatistics displayStatsSummary(long userId) {
        Call<PlayerStatistics> call = ApiClient
                .getApiInterface()
                .getStatsByUserId(userId);

        PlayerStatistics playerStatistics = new PlayerStatistics();

        call.enqueue(new Callback<PlayerStatistics>() {
            @Override
            public void onResponse(@NonNull Call<PlayerStatistics> call,
                                   @NonNull Response<PlayerStatistics> response) {

                assert response.body() != null;

                playerStatistics.setAverageScore(response.body().getAverageScore());
                playerStatistics.setHandicapIndex(response.body().getHandicapIndex());

                Log.i("HANDICAP & AVG SCORE =>", playerStatistics.toString());
            }

            @Override
            public void onFailure(@NonNull Call<PlayerStatistics> call, @NonNull Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
        return playerStatistics;
    }

    public void loginUser(LoginRequest loginRequest, TextInputLayout tilUsername,
                          TextInputLayout tilPassword, Context context) {

        Call<LoginResponse> loginResponseCall = ApiClient
                .getApiInterface()
                .loginUser(loginRequest);

        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call,
                                   @NonNull Response<LoginResponse> response) {

                LoginResponse loginResponse = response.body();

                if (response.isSuccessful()) {
                    DBHelper db = new DBHelper(context);
                    Intent intent = new Intent(context.getApplicationContext(), HomeActivity.class);

                    assert loginResponse != null;

                    Log.i("LOGIN INFO ====> ", loginResponse.toString());

                    db.saveUser(loginResponse.getUsername(), loginResponse.getId());
                    context.startActivity(intent);
                }
                else {
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

        Call<RegistrationResponse> registrationResponseCall = ApiClient
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
                }
                else {
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

    @NonNull
    public User getUserInfoByUserId(long userId) {
        User user = new User();

        Call<User> userCall = ApiClient
                .getApiInterface()
                .getUserInfoById(userId);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {

                assert response.body() != null;

                user.setUsername(response.body().getUsername());
                user.setEmail(response.body().getEmail());
                user.setPassword(response.body().getPassword());
                user.setId(response.body().getId());

                Log.i("USER INFO === > ", user.toString());
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
        return user;
    }

    @NonNull
    public PlayerStatistics getRoundsPlayedByUserId(long userId) {
        PlayerStatistics playerStatistics = new PlayerStatistics();

        Call<PlayerStatistics> statsCall = ApiClient
                .getApiInterface()
                .getStatsByUserId(userId);

        statsCall.enqueue(new Callback<PlayerStatistics>() {
            @Override
            public void onResponse(@NonNull Call<PlayerStatistics> call,
                                   @NonNull Response<PlayerStatistics> response) {

                assert response.body() != null;
                playerStatistics.setRoundsPlayed(response.body().getRoundsPlayed());

                Log.i("ROUNDS PLAYED ====> ",
                        "rounds played: " +
                                playerStatistics.getRoundsPlayed());
            }

            @Override
            public void onFailure(@NonNull Call<PlayerStatistics> call, @NonNull Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
        return playerStatistics;
    }

    public void updateUserInfo(@NonNull User user, @NonNull Context context) {
        Call<User> userCall = ApiClient
                .getApiInterface()
                .updateUserInfo(user.getId(), user);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call,
                                   @NonNull Response<User> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(context.getApplicationContext(),
                            "User info updated successfully.",
                            Toast.LENGTH_SHORT).show();

                    Log.i("UPDATED USER INFO ===> ", user.toString());
                }
                else {
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
}
