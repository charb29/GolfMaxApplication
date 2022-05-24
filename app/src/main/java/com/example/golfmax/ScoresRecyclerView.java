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

    private ArrayList<ScoreRequest> scoreArrayList;
    private Context context;

    public ScoresRecyclerView(ArrayList<ScoreRequest> scoreArrayList, Context context) {
        this.scoreArrayList = scoreArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scores_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ScoreRequest score = scoreArrayList.get(position);
        holder.textViewCourseName.setText(score.getCourseName());

        String userScores = Double.toString(score.getScore());
        holder.textViewScore.setText(userScores);

        String courseRating = Double.toString(score.getCourseRating());
        holder.textViewCourseRating.setText(courseRating);

        String slopeRating = Double.toString(score.getSlopeRating());
        holder.textViewSlopeRating.setText(slopeRating);
    }

    @Override
    public int getItemCount() {
        return scoreArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewCourseName, textViewScore, textViewCourseRating, textViewSlopeRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCourseName = itemView.findViewById(R.id.viewCourseName);
            textViewScore = itemView.findViewById(R.id.viewUserScore);
            textViewCourseRating = itemView.findViewById(R.id.viewCourseRating);
            textViewSlopeRating = itemView.findViewById(R.id.viewSlopeRating);
        }
    }
}