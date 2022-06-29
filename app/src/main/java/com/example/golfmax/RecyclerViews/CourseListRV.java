package com.example.golfmax.RecyclerViews;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.golfmax.Activities.CourseLeaderboardActivity;
import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Models.Course;
import com.example.golfmax.R;

import java.util.List;

public class CourseListRV extends RecyclerView.Adapter<CourseListRV.MyViewHolder> {

    private List<Course> courseList;
    private Context context;
    DBHelper db;
    public static Course course;
    public static String courseName;
    public static String courseNameForTextView;

    public CourseListRV(Context context, List<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseListRV.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_list_rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseListRV.MyViewHolder holder, int position) {
        db = new DBHelper(context.getApplicationContext());
        holder.tvCourseName.setText(courseList.get(position).getCourseName());
        db.saveCourse(courseList.get(position).getCourseName(), courseList.get(position).getId());
        courseName = courseList.get(position).getCourseName();
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCourseName;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvCourseName = (TextView) itemView.findViewById(R.id.text_view_course_name);

            tvCourseName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Course course = new Course();
                    Intent intent = new Intent(context, CourseLeaderboardActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Log.i("COURSE NAME ====> ", tvCourseName.getText().toString());
                    course.setCourseName(tvCourseName.getText().toString());
                    courseNameForTextView = course.getCourseName();
                    context.startActivity(intent);
                }
            });
        }
    }
}
