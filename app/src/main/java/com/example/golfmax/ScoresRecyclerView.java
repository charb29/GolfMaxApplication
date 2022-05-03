package com.example.golfmax;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScoresRecyclerView extends RecyclerView.Adapter<ScoresRecyclerView.ViewHolder> {

    private ArrayList<UserScores> userScoresArrayList;
    private Context context;

    public ScoresRecyclerView(ArrayList<UserScores> userScoresArrayList, Context context) {
        this.userScoresArrayList = userScoresArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ScoresRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_rows, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoresRecyclerView.ViewHolder holder, int position) {
        UserScores scores = userScoresArrayList.get(position);
        holder.courseName.setText(scores.getCourseName());

        String userScores = Integer.toString(scores.getUserScore());
        holder.viewUserScores.setText(userScores);

        String courseRating = Double.toString(scores.getCourseRating());
        holder.viewCourseRating.setText(courseRating);

        String slopeRating = Double.toString(scores.getSlopeRating());
        holder.viewSlopeRating.setText(slopeRating);
    }

    @Override
    public int getItemCount() {
        return userScoresArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView courseName;
        private TextView viewUserScores;
        private TextView viewCourseRating;
        private TextView viewSlopeRating;

        public ViewHolder(View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.viewCourseName);
            viewUserScores = itemView.findViewById(R.id.viewUserScore);
            viewCourseRating = itemView.findViewById(R.id.viewCourseRating);
            viewSlopeRating = itemView.findViewById(R.id.viewSlopeRating);
        }
    }
}
