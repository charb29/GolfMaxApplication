package com.example.golfmax.Responses;

import androidx.annotation.NonNull;

import com.example.golfmax.Models.Course;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CourseResponse {

    @SerializedName("courseNames")
    @Expose
    private ArrayList<Course> courseNames;

    public ArrayList<Course> getCourseNames() {
        return courseNames;
    }

    @NonNull
    @Override
    public String toString() {
        return courseNames.toString();
    }
}
