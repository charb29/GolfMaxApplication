package com.example.golfmax.Requests;

import com.example.golfmax.Models.User;

public class ScoreRequest {

    private long id;
    private String courseName;
    private int userScore;
    private double courseRating;
    private double slopeRating;
    private User user;

    public ScoreRequest() {}

    public ScoreRequest(long id, String courseName, int userScore, double courseRating, double slopeRating, User user) {
        this.id = id;
        this.courseName = courseName;
        this.userScore = userScore;
        this.courseRating = courseRating;
        this.slopeRating = slopeRating;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getUserScore() {
        return userScore;
    }

    public double getCourseRating() {
        return courseRating;
    }

    public double getSlopeRating() {
        return slopeRating;
    }

    public User getUser() {
        return user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public void setCourseRating(double courseRating) {
        this.courseRating = courseRating;
    }

    public void setSlopeRating(double slopeRating) {
        this.slopeRating = slopeRating;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
