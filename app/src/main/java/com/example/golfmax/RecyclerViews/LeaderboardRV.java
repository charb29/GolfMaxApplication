package com.example.golfmax.RecyclerViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.golfmax.Backend.DBHelper;
import com.example.golfmax.Models.Course;
import com.example.golfmax.R;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardRV extends RecyclerView.Adapter<LeaderboardRV.MyViewHolder> {

    private List<Course> courseList;
    private Context context;
    DBHelper db;
    public static String courseName;

    public LeaderboardRV(Context context, List<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public LeaderboardRV.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboards_rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardRV.MyViewHolder holder, int position) {
        db = new DBHelper(context.getApplicationContext());
        holder.textViewCourseName.setText(courseList.get(position).getCourseName());
        db.saveCourse(courseList.get(position).getCourseName(), courseList.get(position).getId());
        courseName = courseList.get(position).getCourseName();
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCourseName;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewCourseName = (TextView) itemView.findViewById(R.id.textViewCourseName);

        }
    }
}
