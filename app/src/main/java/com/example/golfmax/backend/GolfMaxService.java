package com.example.golfmax.backend;


import com.example.golfmax.models.Course;
import com.example.golfmax.models.PlayerStatistics;
import com.example.golfmax.models.Score;
import com.example.golfmax.models.User;
import com.example.golfmax.requests.LoginRequest;
import com.example.golfmax.requests.RegistrationRequest;
import com.example.golfmax.responses.LoginResponse;
import com.example.golfmax.responses.RegistrationResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GolfMaxService {

    @POST("users/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("users/account")
    Call<RegistrationResponse> registerUser(@Body RegistrationRequest registrationRequest);

    @GET("stats/user/{id}")
    Call<PlayerStatistics> getStatsByUserId(@Path("id") long id);

    @GET("users/{id}")
    Call<User> getUserInfoById(@Path("id") long id);

    @PUT("users/{id}/update")
    Call<User> updateUserInfo(@Path("id") long id, @Body User user);

    @GET("/courses")
    Call<List<Course>> getCourseNames();

    @GET("/scores/course/{id}")
    Call<List<Score>> getScoresByCourseId(@Path("id") long courseId);

    @GET("/scores/user/{id}")
    Call<List<Score>> getScoresByUserId(@Path("id") long userId);

    @GET("/courses/{id}")
    Call<Course> getCourseById(@Path("id") long id);

    @POST("/scores/")
    Call<Score> saveScore(@Body Score score);
}
