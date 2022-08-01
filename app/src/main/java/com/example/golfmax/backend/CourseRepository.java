package com.example.golfmax.backend;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.golfmax.models.Course;
import com.example.golfmax.recyclerViews.CourseListRV;
import com.example.golfmax.recyclerViews.NewRoundRV;
import com.example.golfmax.databinding.ActivityCourseListBinding;
import com.example.golfmax.databinding.ActivityNewRoundBinding;
import com.example.golfmax.databinding.ActivityScoreCardFront9Binding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseRepository {

    private ActivityCourseListBinding courseListBinding;
    private ActivityNewRoundBinding newRoundBinding;
    private ActivityScoreCardFront9Binding scoreCardFront9Binding;
    private List<Course> courseNamesList;
    private Course course;

    public ActivityCourseListBinding getCourseListBinding() {
        return courseListBinding;
    }

    public void setCourseListBinding(ActivityCourseListBinding binding) {
        this.courseListBinding = binding;
    }

    public void setCourseNamesList(List<Course> courseNamesList) {
        this.courseNamesList = courseNamesList;
    }

    public ActivityNewRoundBinding getNewRoundBinding() {
        return newRoundBinding;
    }

    public void setNewRoundBinding(ActivityNewRoundBinding newRoundBinding) {
        this.newRoundBinding = newRoundBinding;
    }

    public ActivityScoreCardFront9Binding getScoreCardFront9Binding() {
        return scoreCardFront9Binding;
    }

    public void setScoreCardFront9Binding(ActivityScoreCardFront9Binding scoreCardFront9Binding) {
        this.scoreCardFront9Binding = scoreCardFront9Binding;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void getCourseNamesForLeaderboard(Context context) {
        Call<List<Course>> courseCall = GolfMaxHttpClient
                .getApiInterface()
                .getCourseNames();

        courseCall.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(@NonNull Call<List<Course>> call,
                                   @NonNull Response<List<Course>> response) {
                setCourseNamesList(response.body());
                courseListBinding.viewCourseList.setLayoutManager(
                        new LinearLayoutManager(context.getApplicationContext()));

                courseListBinding.viewCourseList.setAdapter(
                        new CourseListRV(context.getApplicationContext(), courseNamesList));

                Log.i("getCourseNames ====> ", courseNamesList.toString());
            }

            @Override
            public void onFailure(@NonNull Call<List<Course>>call,
                                  @NonNull Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
    }

    public void getCourseNamesForNewRound(Context context) {
        Call<List<Course>> courseCall = GolfMaxHttpClient
                .getApiInterface()
                .getCourseNames();

        courseCall.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(@NonNull Call<List<Course>> call,
                                   @NonNull Response<List<Course>> response) {
                setCourseNamesList(response.body());
                newRoundBinding.viewNewRoundCourseList.setLayoutManager(
                        new LinearLayoutManager(context.getApplicationContext()));

                newRoundBinding.viewNewRoundCourseList.setAdapter(
                        new NewRoundRV(context.getApplicationContext(), courseNamesList));

                Log.i("getCourseNames ====> ", courseNamesList.toString());
            }

            @Override
            public void onFailure(@NonNull Call<List<Course>>call,
                                  @NonNull Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
    }

    public void getCourseInfoById(long courseId) {
        Call<Course> courseCall = GolfMaxHttpClient
                .getApiInterface()
                .getCourseById(courseId);

        courseCall.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(@NonNull Call<Course> call,
                                   @NonNull Response<Course> response) {
                setCourse(response.body());
                scoreCardFront9Binding.setCourse(getCourse());

                Log.i("COURSE INFO ====> ", getCourse().toString());
            }

            @Override
            public void onFailure(@NonNull Call<Course> call,
                                  @NonNull Throwable t) {
                Log.e("ERROR ====> ", t.toString());
            }
        });
    }
}
