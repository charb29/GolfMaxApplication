package com.example.golfmax.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Score {

    @SerializedName("course")
    @Expose
    private Course course;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("courseName")
    private String courseName;

    @SerializedName("userScore")
    private String userScore;

    @SerializedName("username")
    private String username;

    public Score(Course course, String userScore, User user) {
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
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
