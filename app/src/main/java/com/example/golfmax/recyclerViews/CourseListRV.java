package com.example.golfmax.recyclerViews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.golfmax.R;
import com.example.golfmax.activities.CourseLeaderboardActivity;
import com.example.golfmax.backend.GolfMaxLocalDatabase;
import com.example.golfmax.databinding.CourseListRecyclerViewBinding;
import com.example.golfmax.models.Course;

import java.util.List;

public class CourseListRV extends RecyclerView.Adapter<CourseListRV.CourseListViewHolder> {

    Context context;
    List<Course> courseNamesList;

    public CourseListRV(Context context, List<Course> courseNamesList) {
        this.context = context;
        this.courseNamesList = courseNamesList;
    }

    @NonNull
    @Override
    public CourseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CourseListRecyclerViewBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.course_list_recycler_view,
                        parent,
                        false);

        return new CourseListViewHolder(binding, context);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseListViewHolder holder, int position) {
        Course course = courseNamesList.get(position);
        GolfMaxLocalDatabase db = new GolfMaxLocalDatabase(context.getApplicationContext());
        holder.binding.setCourse(course);
        db.saveCourse(course.getCourseName(), course.getCourseId());
    }

    @Override
    public int getItemCount() {
        return courseNamesList.size();
    }

    static class CourseListViewHolder extends RecyclerView.ViewHolder {

        private final CourseListRecyclerViewBinding binding;
        public Context context;

        public CourseListViewHolder(@NonNull CourseListRecyclerViewBinding binding, Context context) {
            super(binding.getRoot());
            this.binding = binding;
            this.context = context;

            binding.textViewCourseName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,
                            CourseLeaderboardActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("Course name", binding.getCourse().getCourseName());
                    context.startActivity(intent);
                }
            });
        }
    }
}
