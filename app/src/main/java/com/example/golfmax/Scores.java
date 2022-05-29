package com.example.golfmax;

import com.google.gson.annotations.SerializedName;

public class Scores {

    @SerializedName("courseName")
    private String courseName;

    @SerializedName("userScore")
    private String userScore;

    @SerializedName("courseRating")
    private String courseRating;

    @SerializedName("slopeRating")
    private String slopeRating;

    public Scores(String courseName, String userScore, String courseRating, String slopeRating) {
        this.courseName = courseName;
        this.userScore = userScore;
        this.courseRating = courseRating;
        this.slopeRating = slopeRating;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getUserScore() {
        return userScore;
    }

    public String getCourseRating() {
        return courseRating;
    }

    public String getSlopeRating() {
        return slopeRating;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }

    public void setCourseRating(String courseRating) {
        this.courseRating = courseRating;
    }

    public void setSlopeRating(String slopeRating) {
        this.slopeRating = slopeRating;
    }

    @Override
    public String toString() {
        return "Scores(" +
                "courseName='" + courseName + '\'' +
                ", userScore='" + userScore + '\'' +
                ", courseRating='" + courseRating + '\'' +
                ", slopeRating='" + slopeRating + '\'' +
                ')';
    }
}
