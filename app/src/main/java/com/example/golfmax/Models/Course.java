package com.example.golfmax.Models;

import com.google.gson.annotations.SerializedName;

public class Course {

    @SerializedName("courseName")
    private String courseName;

    private int hole1;
    private int hole2;
    private int hole3;
    private int hole4;
    private int hole5;
    private int hole6;
    private int hole7;
    private int hole8;
    private int hole9;
    private int hole10;
    private int hole11;
    private int hole12;
    private int hole13;
    private int hole14;
    private int hole15;
    private int hole16;
    private int hole17;
    private int hole18;
    private int hole19;

    @SerializedName("id")
    private long id;

    private double courseRating;

    private double slopeRating;

    public Course() {}

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getHole1() {
        return hole1;
    }

    public void setHole1(int hole1) {
        this.hole1 = hole1;
    }

    public int getHole2() {
        return hole2;
    }

    public void setHole2(int hole2) {
        this.hole2 = hole2;
    }

    public int getHole3() {
        return hole3;
    }

    public void setHole3(int hole3) {
        this.hole3 = hole3;
    }

    public int getHole4() {
        return hole4;
    }

    public void setHole4(int hole4) {
        this.hole4 = hole4;
    }

    public int getHole5() {
        return hole5;
    }

    public void setHole5(int hole5) {
        this.hole5 = hole5;
    }

    public int getHole6() {
        return hole6;
    }

    public void setHole6(int hole6) {
        this.hole6 = hole6;
    }

    public int getHole7() {
        return hole7;
    }

    public void setHole7(int hole7) {
        this.hole7 = hole7;
    }

    public int getHole8() {
        return hole8;
    }

    public void setHole8(int hole8) {
        this.hole8 = hole8;
    }

    public int getHole9() {
        return hole9;
    }

    public void setHole9(int hole9) {
        this.hole9 = hole9;
    }

    public int getHole10() {
        return hole10;
    }

    public void setHole10(int hole10) {
        this.hole10 = hole10;
    }

    public int getHole11() {
        return hole11;
    }

    public void setHole11(int hole11) {
        this.hole11 = hole11;
    }

    public int getHole12() {
        return hole12;
    }

    public void setHole12(int hole12) {
        this.hole12 = hole12;
    }

    public int getHole13() {
        return hole13;
    }

    public void setHole13(int hole13) {
        this.hole13 = hole13;
    }

    public int getHole14() {
        return hole14;
    }

    public void setHole14(int hole14) {
        this.hole14 = hole14;
    }

    public int getHole15() {
        return hole15;
    }

    public void setHole15(int hole15) {
        this.hole15 = hole15;
    }

    public int getHole16() {
        return hole16;
    }

    public void setHole16(int hole16) {
        this.hole16 = hole16;
    }

    public int getHole17() {
        return hole17;
    }

    public void setHole17(int hole17) {
        this.hole17 = hole17;
    }

    public int getHole18() {
        return hole18;
    }

    public void setHole18(int hole18) {
        this.hole18 = hole18;
    }

    public int getHole19() {
        return hole19;
    }

    public void setHole19(int hole19) {
        this.hole19 = hole19;
    }

    @Override
    public String toString() {
        return "Course(" +
                "courseName='" + courseName + '\'' +
                "par1 = '" + hole1 + '\'' +
                "par2 = '" + hole2 + '\'' +
                "par3 = '" + hole3 + '\'' +
                "par4 = '" + hole4 + '\'' +
                "par5 = '" + hole5 + '\'' +
                "par6 = '" + hole6 + '\'' +
                "par7 = '" + hole7 + '\'' +
                "par8 = '" + hole8 + '\'' +
                "par9 = '" + hole9 + '\'' +
                "par10 = '" + hole10 + '\'' +
                "par11 = '" + hole11 + '\'' +
                "par12 = '" + hole12 + '\'' +
                "par13 ='" + hole13 + '\'' +
                "par14 = '" + hole14 + '\'' +
                "par15 = '" + hole15 + '\'' +
                "par16 = '" + hole16 + '\'' +
                "par17 = '" + hole17 + '\'' +
                "par18 = '" + hole18 + '\'' +
                ')';
    }
}
