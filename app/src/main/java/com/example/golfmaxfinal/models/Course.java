package com.example.golfmaxfinal.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.golfmaxfinal.BR;
import com.google.gson.annotations.Expose;
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
    private String hole10;
    @SerializedName("hole11")
    private String hole11;
    @SerializedName("hole12")
    private String hole12;
    @SerializedName("hole13")
    private String hole13;
    @SerializedName("hole14")
    private String hole14;
    @SerializedName("hole15")
    private String hole15;
    @SerializedName("hole16")
    private String hole16;
    @SerializedName("hole17")
    private String hole17;
    @SerializedName("hole18")
    private String hole18;

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

    public List<Integer> getCourseParsList() {
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
}
