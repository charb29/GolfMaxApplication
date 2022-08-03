package com.example.golfmax.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.golfmax.BR;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Course extends BaseObservable {

    @SerializedName("courseName")
    private String courseName;
    @SerializedName("courseRating")
    private String courseRating;
    @SerializedName("slopeRating")
    private String slopeRating;
    @SerializedName("id")
    private long courseId;
    @SerializedName("hole1")
    private int hole1 = 0;
    @SerializedName("hole2")
    private int hole2 = 0;
    @SerializedName("hole3")
    private int hole3 = 0;
    @SerializedName("hole4")
    private int hole4 = 0;
    @SerializedName("hole5")
    private int hole5 = 0;
    @SerializedName("hole6")
    private int hole6 = 0;
    @SerializedName("hole7")
    private int hole7 = 0;
    @SerializedName("hole8")
    private int hole8 = 0;
    @SerializedName("hole9")
    private int hole9 = 0;
    @SerializedName("hole10")
    private int hole10;
    @SerializedName("hole11")
    private int hole11;
    @SerializedName("hole12")
    private int hole12;
    @SerializedName("hole13")
    private int hole13;
    @SerializedName("hole14")
    private int hole14;
    @SerializedName("hole15")
    private int hole15;
    @SerializedName("hole16")
    private int hole16;
    @SerializedName("hole17")
    private int hole17;
    @SerializedName("hole18")
    private int hole18;

    public Course() {}

    @Bindable
    public String getCourseName() { return courseName; }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
        notifyPropertyChanged(BR.courseName);
    }

    @Bindable
    public String getCourseRating() {
        return courseRating;
    }

    public void setCourseRating(String courseRating) {
        this.courseRating = courseRating;
        notifyPropertyChanged(BR.courseRating);
    }

    @Bindable
    public String getSlopeRating() {
        return slopeRating;
    }

    public void setSlopeRating(String slopeRating) {
        this.slopeRating = slopeRating;
        notifyPropertyChanged(BR.slopeRating);
    }

    public long getCourseId() { return courseId; }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    @Bindable
    public int getHole1() {
        return hole1;
    }

    public void setHole1(int hole1) {
        this.hole1 = hole1;
        notifyPropertyChanged(BR.hole1);
    }

    @Bindable
    public int getHole2() {
        return hole2;
    }

    public void setHole2(int hole2) {
        this.hole2 = hole2;
        notifyPropertyChanged(BR.hole2);
    }

    @Bindable
    public int getHole3() {
        return hole3;
    }

    public void setHole3(int hole3) {
        this.hole3 = hole3;
        notifyPropertyChanged(BR.hole3);
    }

    @Bindable
    public int getHole4() {
        return hole4;
    }

    public void setHole4(int hole4) {
        this.hole4 = hole4;
        notifyPropertyChanged(BR.hole4);
    }

    @Bindable
    public int getHole5() {
        return hole5;
    }

    public void setHole5(int hole5) {
        this.hole5 = hole5;
        notifyPropertyChanged(BR.hole5);
    }

    @Bindable
    public int getHole6() {
        return hole6;
    }

    public void setHole6(int hole6) {
        this.hole6 = hole6;
        notifyPropertyChanged(BR.hole6);
    }

    @Bindable
    public int getHole7() {
        return hole7;
    }

    public void setHole7(int hole7) {
        this.hole7 = hole7;
        notifyPropertyChanged(BR.hole7);
    }

    @Bindable
    public int getHole8() {
        return hole8;
    }

    public void setHole8(int hole8) {
        this.hole8 = hole8;
        notifyPropertyChanged(BR.hole8);
    }

    @Bindable
    public int getHole9() {
        return hole9;
    }

    public void setHole9(int hole9) {
        this.hole9 = hole9;
        notifyPropertyChanged(BR.hole9);
    }

    @Bindable
    public int getHole10() {
        return hole10;
    }

    public void setHole10(int hole10) {
        this.hole10 = hole10;
        notifyPropertyChanged(BR.hole10);
    }

    @Bindable
    public int getHole11() {
        return hole11;
    }

    public void setHole11(int hole11) {
        this.hole11 = hole11;
        notifyPropertyChanged(BR.hole11);
    }

    @Bindable
    public int getHole12() {
        return hole12;
    }

    public void setHole12(int hole12) {
        this.hole12 = hole12;
        notifyPropertyChanged(BR.hole12);
    }

    @Bindable
    public int getHole13() {
        return hole13;
    }

    public void setHole13(int hole13) {
        this.hole13 = hole13;
        notifyPropertyChanged(BR.hole13);
    }

    @Bindable
    public int getHole14() {
        return hole14;
    }

    public void setHole14(int hole14) {
        this.hole14 = hole14;
        notifyPropertyChanged(BR.hole14);
    }

    @Bindable
    public int getHole15() {
        return hole15;
    }

    public void setHole15(int hole15) {
        this.hole15 = hole15;
        notifyPropertyChanged(BR.hole15);
    }

    @Bindable
    public int getHole16() {
        return hole16;
    }

    public void setHole16(int hole16) {
        this.hole16 = hole16;
        notifyPropertyChanged(BR.hole16);
    }

    @Bindable
    public int getHole17() {
        return hole17;
    }

    public void setHole17(int hole17) {
        this.hole17 = hole17;
        notifyPropertyChanged(BR.hole17);
    }

    @Bindable
    public int getHole18() {
        return hole18;
    }

    public void setHole18(int hole18) {
        this.hole18 = hole18;
        notifyPropertyChanged(BR.hole18);
    }

    public List<Integer> getFront9ParsList() {
        List<Integer> courseParsList = new ArrayList<>();
        courseParsList.add(getHole1());
        courseParsList.add(getHole2());
        courseParsList.add(getHole3());
        courseParsList.add(getHole4());
        courseParsList.add(getHole5());
        courseParsList.add(getHole6());
        courseParsList.add(getHole7());
        courseParsList.add(getHole8());
        courseParsList.add(getHole9());

        return courseParsList;
    }

    public List<Integer> getBack9ParsList() {
        List<Integer> courseParsList = new ArrayList<>();
        courseParsList.add(getHole10());
        courseParsList.add(getHole11());
        courseParsList.add(getHole12());
        courseParsList.add(getHole13());
        courseParsList.add(getHole14());
        courseParsList.add(getHole15());
        courseParsList.add(getHole16());
        courseParsList.add(getHole17());
        courseParsList.add(getHole18());

        return courseParsList;
    }

    public int getSumOfFront9Pars() {
        int front9ParTotal = 0;
        for (int i = 0; i < getFront9ParsList().size(); i++) {
            front9ParTotal += i;
        }

        return front9ParTotal;
    }

    public int getSumOfBack9Pars() {
        int back9ParTotal = 0;
        for (int i = 0; i < getBack9ParsList().size(); i++) {
            back9ParTotal += i;
        }

        return back9ParTotal;
    }
}
