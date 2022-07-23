package com.example.golfmaxfinal.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Score {

    @SerializedName("course")
    @Expose
    private Course course;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("userScore")
    private int userScore;

    private int rank;

    public Score() {}

    public Score(Course course, User user, int userScore, int rank) {
        this.course = course;
        this.user = user;
        this.userScore = userScore;
        this.rank = rank;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserScore() {
        return userScore;
    }

    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String toString() {
        return "Score (" +
                " User = '" + user.getUsername() + '\'' +
                " User Score = '" + userScore + '\'' +
                " Rank = '" + rank + '\'' +
                ')';
    }
}
