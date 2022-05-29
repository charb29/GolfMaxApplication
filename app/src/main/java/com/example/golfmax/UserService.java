package com.example.golfmax;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @POST("login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("account")
    Call<RegistrationResponse> registerUser(@Body RegistrationRequest registrationRequest);

    @POST("/scores")
    Call<ScoreResponse> addScore(@Body ScoreRequest scoreRequest);

    @GET("/scores")
    Call<List<Scores>> getScores();

}
