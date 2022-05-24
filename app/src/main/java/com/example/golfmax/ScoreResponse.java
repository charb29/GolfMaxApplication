package com.example.golfmax;

public class ScoreResponse {

    private String courseName;
    private long userId;
    private int score;
    private double courseRating, slopeRating;

    public String getCourseName() {
        return courseName;
    }

    private long getUserId() {
        return userId;
    }

    public int getScore() {
        return score;
    }

    public double getCourseRating() {
        return courseRating;
    }

    public double getSlopeRating() {
        return slopeRating;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCourseRating(double courseRating) {
        this.courseRating = courseRating;
    }

    public void setSlopeRating(double slopeRating) {
        this.slopeRating = slopeRating;
    }
}
