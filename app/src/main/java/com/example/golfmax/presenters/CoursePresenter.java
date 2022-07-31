package com.example.golfmax.presenters;

import android.content.Context;

import com.example.golfmax.contracts.CourseContract;

public class CoursePresenter implements CourseContract.Presenter {

    private CourseContract.View view;
    private Context context;

    public CoursePresenter(CourseContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
}
