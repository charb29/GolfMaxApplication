package com.example.golfmax;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @POST("login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("account")
    Call<RegistrationResponse> registerUser(@Body RegistrationRequest registrationRequest);

    @POST("/scores")
    Call<ScoreResponse> addScore(@Body ScoreRequest scoreRequest);

    @GET("/scores/user/{id}")
    Call<List<Scores>> getScores(@Path("id") long id);

}
