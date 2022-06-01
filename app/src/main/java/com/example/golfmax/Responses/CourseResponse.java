package com.example.golfmax.Responses;

import androidx.annotation.NonNull;

import com.example.golfmax.Models.Courses;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CourseResponse {

    @SerializedName("courseNames")
    @Expose
    private ArrayList<Courses> courseNames;

    public ArrayList<Courses> getCourseNames() {
        return courseNames;
    }

    @NonNull
    @Override
    public String toString() {
        return courseNames.toString();
    }
}
