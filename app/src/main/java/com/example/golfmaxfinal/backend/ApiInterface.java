package com.example.golfmaxfinal.backend;

import com.example.golfmaxfinal.models.PlayerStatistics;
import com.example.golfmaxfinal.requests.LoginRequest;
import com.example.golfmaxfinal.requests.RegistrationRequest;
import com.example.golfmaxfinal.responses.LoginResponse;
import com.example.golfmaxfinal.responses.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("users/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("users/account")
    Call<RegistrationResponse> registerUser(@Body RegistrationRequest registrationRequest);

    @GET("stats/user/{id}")
    Call<PlayerStatistics> getStatsByUserId(@Path("id") long id);
}
