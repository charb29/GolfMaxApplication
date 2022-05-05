package com.example.golfmax;

import androidx.appcompat.app.AppCompatActivity;

public class UserScore extends AppCompatActivity {

    DBHelper db = new DBHelper(this);

    private String courseName;
    private int userScore;
    private double courseRating, slopeRating;

    public String getCourseName() {

        return courseName;
    }

    public void setCourseName(String courseName) {

        this.courseName = courseName;
    }

    public int getUserScore() {

        return userScore;
    }

    public void setUserScores(int userScore) {

        this.userScore = userScore;
    }

    public double getCourseRating() {

        return courseRating;
    }

    public void setCourseRating(double courseRating) {

        this.courseRating = courseRating;
    }

    public double getSlopeRating() {

        return slopeRating;
    }

    public void setSlopeRating(double slopeRating) {

        this.slopeRating = slopeRating;
    }

    public UserScore(String courseName, int userScore, double courseRating, double slopeRating) {
        this.courseName = courseName;
        this.userScore = userScore;
        this.courseRating = courseRating;
        this.slopeRating = slopeRating;
    }
}