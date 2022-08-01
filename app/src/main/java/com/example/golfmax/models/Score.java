package com.example.golfmax.models;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Score extends BaseObservable {

    @SerializedName("course")
    @Expose
    private Course course;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("userScore")
    private String userScore;
    private int rank;
    private String hole1;
    private String hole2;
    private String hole3;
    private String hole4;
    private String hole5;
    private String hole6;
    private String hole7;
    private String hole8;
    private String hole9;
    private String front9Score;
    private int courseRating;
    private int slopeRating;

    public Score() {}

    public Score(Course course, User user, String userScore, int rank) {
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

    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Bindable
    public String getHole1() {
        return hole1;
    }

    public void setHole1(String hole1) {
        this.hole1 = hole1;
        notifyPropertyChanged(BR.hole1);
    }

    @Bindable
    public String getHole2() {
        return hole2;
    }

    public void setHole2(String hole2) {
        this.hole2 = hole2;
        notifyPropertyChanged(BR.hole2);
    }

    @Bindable
    public String getHole3() {
        return hole3;
    }

    public void setHole3(String hole3) {
        this.hole3 = hole3;
        notifyPropertyChanged(BR.hole3);
    }

    @Bindable
    public String getHole4() {
        return hole4;
    }

    public void setHole4(String hole4) {
        this.hole4 = hole4;
        notifyPropertyChanged(BR.hole4);
    }

    @Bindable
    public String getHole5() {
        return hole5;
    }

    public void setHole5(String hole5) {
        this.hole5 = hole5;
        notifyPropertyChanged(BR.hole5);
    }

    @Bindable
    public String getHole6() {
        return hole6;
    }

    public void setHole6(String hole6) {
        this.hole6 = hole6;
        notifyPropertyChanged(BR.hole6);
    }

    @Bindable
    public String getHole7() {
        return hole7;
    }

    public void setHole7(String hole7) {
        this.hole7 = hole7;
        notifyPropertyChanged(BR.hole7);
    }

    @Bindable
    public String getHole8() {
        return hole8;
    }

    public void setHole8(String hole8) {
        this.hole8 = hole8;
        notifyPropertyChanged(BR.hole8);
    }

    @Bindable
    public String getHole9() {
        return hole9;
    }

    public void setHole9(String hole9) {
        this.hole9 = hole9;
        notifyPropertyChanged(BR.hole9);
    }

    @Bindable
    public String getFront9Score() {
        return front9Score;
    }

    public void setFront9Score(String front9Score) {
        this.front9Score = front9Score;
        notifyPropertyChanged(BR.front9Score);
    }

    public int getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(int courseRating) {
        this.courseRating = courseRating;
    }

    public int getSlopeRating() {
        return slopeRating;
    }

    public void setSlopeRating(int slopeRating) {
        this.slopeRating = slopeRating;
    }

    public List<String> getListOfEnteredScores() {
        List<String> userScores = new ArrayList<>();
        userScores.add(getHole1());
        userScores.add(getHole2());
        userScores.add(getHole3());
        userScores.add(getHole4());
        userScores.add(getHole5());
        userScores.add(getHole6());
        userScores.add(getHole7());
        userScores.add(getHole8());
        userScores.add(getHole9());

        return userScores;
    }

}
