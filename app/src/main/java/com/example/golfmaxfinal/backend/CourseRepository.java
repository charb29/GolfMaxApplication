package com.example.golfmaxfinal.backend;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.golfmaxfinal.databinding.ActivityCourseListBinding;
import com.example.golfmaxfinal.models.Course;
import com.example.golfmaxfinal.recyclerViews.CourseListRV;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseRepository {

    private ActivityCourseListBinding binding;
    private List<Course> courseNamesList;

    public ActivityCourseListBinding getBinding() {
        return binding;
    }

    public void setBinding(ActivityCourseListBinding binding) {
        this.binding = binding;
    }

    public void setCourseNamesList(List<Course> courseNamesList) {
        this.courseNamesList = courseNamesList;
    }

    public void getCourseNames(Context context) {

        Call<List<Course>> courseCall = GolfMaxHttpClient
                .getApiInterface()
                .getCourseNames();

        courseCall.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(@NonNull Call<List<Course>> call,
                                   @NonNull Response<List<Course>> response) {
                setCourseNamesList(response.body());
                binding.viewCourseList.setLayoutManager(
                        new LinearLayoutManager(context.getApplicationContext()));

                binding.viewCourseList.setAdapter(
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
}
