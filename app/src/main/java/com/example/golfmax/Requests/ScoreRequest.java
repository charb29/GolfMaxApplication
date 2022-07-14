package com.example.golfmax.Requests;

import com.example.golfmax.Models.Course;
import com.example.golfmax.Models.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScoreRequest {

    @SerializedName("course")
    @Expose
    private Course course;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("userScore")
    private String userScore;


    public ScoreRequest(Course course, String userScore, User user) {
        this.userScore = userScore;
        this.course = course;
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getUserScore() {
        return userScore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Scores(" +
                "courseName='" + course + '\'' +
                "userScore='" + userScore + '\'' +
                "username='" + user + '\'' +
                ')';
    }
}
