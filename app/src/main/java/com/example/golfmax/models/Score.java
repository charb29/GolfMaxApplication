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
    private int userScore;
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
    private String hole10;
    private String hole11;
    private String hole12;
    private String hole13;
    private String hole14;
    private String hole15;
    private String hole16;
    private String hole17;
    private String hole18;
    private String front9Score;
    private String back9Score;
    private double courseRating;
    private double slopeRating;

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
    public String getHole10() {
        return hole10;
    }

    public void setHole10(String hole10) {
        this.hole10 = hole10;
        notifyPropertyChanged(BR.hole10);
    }

    @Bindable
    public String getHole11() {
        return hole11;
    }

    public void setHole11(String hole11) {
        this.hole11 = hole11;
        notifyPropertyChanged(BR.hole11);
    }

    @Bindable
    public String getHole12() {
        return hole12;
    }

    public void setHole12(String hole12) {
        this.hole12 = hole12;
        notifyPropertyChanged(BR.hole12);
    }

    @Bindable
    public String getHole13() {
        return hole13;
    }

    public void setHole13(String hole13) {
        this.hole13 = hole13;
        notifyPropertyChanged(BR.hole13);
    }

    @Bindable
    public String getHole14() {
        return hole14;
    }

    public void setHole14(String hole14) {
        this.hole14 = hole14;
        notifyPropertyChanged(BR.hole14);
    }

    @Bindable
    public String getHole15() {
        return hole15;
    }

    public void setHole15(String hole15) {
        this.hole15 = hole15;
        notifyPropertyChanged(BR.hole15);
    }

    @Bindable
    public String getHole16() {
        return hole16;
    }

    public void setHole16(String hole16) {
        this.hole16 = hole16;
        notifyPropertyChanged(BR.hole16);
    }

    @Bindable
    public String getHole17() {
        return hole17;
    }

    public void setHole17(String hole17) {
        this.hole17 = hole17;
        notifyPropertyChanged(BR.hole17);
    }

    @Bindable
    public String getHole18() {
        return hole18;
    }

    public void setHole18(String hole18) {
        this.hole18 = hole18;
        notifyPropertyChanged(BR.hole18);
    }

    @Bindable
    public String getFront9Score() {
        return front9Score;
    }

    public void setFront9Score(String front9Score) {
        this.front9Score = front9Score;
        notifyPropertyChanged(BR.front9Score);
    }

    @Bindable
    public String getBack9Score() {
        return front9Score;
    }

    public void setBack9Score(String back9Score) {
        this.back9Score = back9Score;
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

    public List<String> getListOfEnteredFront9Scores() {
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

    public List<String> getListOFEnteredBack9Scores() {
        List<String> userScores = new ArrayList<>();
        userScores.add(getHole10());
        userScores.add(getHole11());
        userScores.add(getHole12());
        userScores.add(getHole13());
        userScores.add(getHole14());
        userScores.add(getHole15());
        userScores.add(getHole16());
        userScores.add(getHole17());
        userScores.add(getHole18());

        return userScores;
    }
}
