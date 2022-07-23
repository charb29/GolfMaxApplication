package com.example.golfmaxfinal.presenters;

import android.content.Context;

import com.example.golfmaxfinal.contracts.CourseContract;

public class CoursePresenter implements CourseContract.Presenter {

    private CourseContract.View view;
    private Context context;

    public CoursePresenter(CourseContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
