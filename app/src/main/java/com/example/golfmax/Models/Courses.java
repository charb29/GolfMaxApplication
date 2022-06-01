package com.example.golfmax.Models;

public class Courses {

    private String courseName;
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
}
