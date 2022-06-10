package com.example.golfmax.Models;

import com.google.gson.annotations.SerializedName;

public class Course {

    @SerializedName("courseName")
    private String courseName;

    @SerializedName("id")
    private long id;

    private double courseRating;
    private double slopeRating;

    public String getCourseName() {
        return courseName;
    }

    public long getId() {
        return id;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setCourseRating(double courseRating) {
        this.courseRating = courseRating;
    }

    public void setSlopeRating(double slopeRating) {
        this.slopeRating = slopeRating;
    }

    @Override
    public String toString() {
        return "Course(" +
                "courseName='" + courseName + '\'' +
                ')';
    }
}
