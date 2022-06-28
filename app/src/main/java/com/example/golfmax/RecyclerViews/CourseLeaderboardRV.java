package com.example.golfmax.RecyclerViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.golfmax.Activities.LoginActivity;
import com.example.golfmax.Models.Score;
import com.example.golfmax.R;

import java.util.List;

public class CourseLeaderboardRV extends RecyclerView.Adapter<CourseLeaderboardRV.MyViewHolder> {

    private Context context;
    private List<Score> scoreList;

    public CourseLeaderboardRV(Context context, List<Score> scoreList) {
        this.context = context;
        this.scoreList = scoreList;
    }

    @NonNull
    @Override
    public CourseLeaderboardRV.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.course_leaderboard_rv_item, parent, false);
        return new CourseLeaderboardRV.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseLeaderboardRV.MyViewHolder holder, int position) {
        holder.textViewUsername.setText(scoreList.get(position).getUser().getUsername());
        holder.textViewUserScore.setText(scoreList.get(position).getUserScore());
        
        for (int i = 0; i < getItemCount(); i++) {
            holder.textViewRank.setText(String.valueOf(position + 1));
        }
    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewUsername, textViewUserScore, textViewRank;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewUsername = (TextView) itemView.findViewById(R.id.textViewUsername);
            textViewUserScore = (TextView) itemView.findViewById(R.id.textViewUserScore);
            textViewRank = (TextView) itemView.findViewById(R.id.textViewRank);

        }
    }
}