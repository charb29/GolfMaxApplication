package com.example.golfmax.Backend;

import com.example.golfmax.Models.Course;
import com.example.golfmax.Models.User;
import com.example.golfmax.Requests.LoginRequest;
import com.example.golfmax.Requests.UserRequest;
import com.example.golfmax.Responses.LoginResponse;
import com.example.golfmax.Requests.RegistrationRequest;
import com.example.golfmax.Responses.RegistrationResponse;
import com.example.golfmax.Models.Score;
import com.example.golfmax.Responses.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @POST("users/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("users/account")
    Call<RegistrationResponse> registerUser(@Body RegistrationRequest registrationRequest);

    @GET("/scores/user/{id}")
    Call<List<Score>> getScores(@Path("id") long id);

    @GET("/courses")
    Call<List<Course>> getCourseNames();

    @GET("/scores/course/{id}")
    Call<List<Score>> getScoresByCourseId(@Path("id") long id);

    @GET("users/{id}")
    Call<User> getUserInfoById(@Path("id") long id);

    @PUT("users/{id}/update")
    Call<UserResponse> updateUserInfo(@Path("id") long id, @Body User user);
}
