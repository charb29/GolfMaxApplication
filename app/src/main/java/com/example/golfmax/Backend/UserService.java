package com.example.golfmax.Backend;

import com.example.golfmax.Requests.LoginRequest;
import com.example.golfmax.Responses.LoginResponse;
import com.example.golfmax.Requests.RegistrationRequest;
import com.example.golfmax.Responses.RegistrationResponse;
import com.example.golfmax.Requests.ScoreRequest;
import com.example.golfmax.Responses.ScoreResponse;
import com.example.golfmax.Models.Scores;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @POST("users/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("users/account")
    Call<RegistrationResponse> registerUser(@Body RegistrationRequest registrationRequest);

    @GET("/scores/user/{id}")
    Call<List<Scores>> getScores(@Path("id") long id);
}
