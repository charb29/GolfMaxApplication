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
import com.example.golfmax.activities.ScoreCardFront9Activity;
import com.example.golfmax.backend.GolfMaxLocalDatabase;
import com.example.golfmax.databinding.NewRoundRecyclerViewBinding;
import com.example.golfmax.models.Course;

import java.util.List;

public class NewRoundRV extends RecyclerView.Adapter<NewRoundRV.NewRoundViewHolder> {

    Context context;
    List<Course> courseNamesList;
    public static String staticCourseName;

    public NewRoundRV(Context context, List<Course> courseNamesList) {
        this.context = context;
        this.courseNamesList = courseNamesList;
    }

    @NonNull
    @Override
    public NewRoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NewRoundRecyclerViewBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.new_round_recycler_view,
                        parent,
                        false);

        return new NewRoundViewHolder(binding, context);
    }

    @Override
    public void onBindViewHolder(@NonNull NewRoundViewHolder holder, int position) {
        Course course = courseNamesList.get(position);
        GolfMaxLocalDatabase db = new GolfMaxLocalDatabase(context.getApplicationContext());
        holder.binding.setCourse(course);
        db.saveCourse(course.getCourseName(), course.getCourseId());
    }

    @Override
    public int getItemCount() {
        return courseNamesList.size();
    }

    static class NewRoundViewHolder extends RecyclerView.ViewHolder {

        private final NewRoundRecyclerViewBinding binding;
        public Context context;

        public NewRoundViewHolder(@NonNull NewRoundRecyclerViewBinding binding, Context context) {
            super(binding.getRoot());
            this.binding = binding;
            this.context = context;

            binding.textViewCourseName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,
                            ScoreCardFront9Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    staticCourseName = binding.getCourse().getCourseName();

                    context.startActivity(intent);
                }
            });
        }
    }
}