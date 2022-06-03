package com.example.golfmax.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scores {

    @SerializedName("course")
    @Expose
    private Courses course;

    @SerializedName("courseName")
    private String courseName;

    @SerializedName("userScore")
    private String userScore;

    public Scores(Courses course, String userScore) {
        this.userScore = userScore;
        this.course = course;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
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

    @Override
    public String toString() {
        return "Scores(" +
                "courseName='" + course + '\'' +
                ')';
    }
}
