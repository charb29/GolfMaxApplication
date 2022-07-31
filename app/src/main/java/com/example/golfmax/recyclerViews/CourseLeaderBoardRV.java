package com.example.golfmax.recyclerViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.golfmax.R;
import com.example.golfmax.databinding.CourseLeaderboardRecyclerViewBinding;
import com.example.golfmax.models.Score;

import java.util.List;

public class CourseLeaderBoardRV extends RecyclerView.Adapter<CourseLeaderBoardRV
        .CourseLeaderboardViewHolder> {

    Context context;
    List<Score> scoreList;

    public CourseLeaderBoardRV(Context context, List<Score> scoreList) {
        this.context = context;
        this.scoreList = scoreList;
    }

    @NonNull
    @Override
    public CourseLeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CourseLeaderboardRecyclerViewBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.course_leaderboard_recycler_view,
                        parent,
                        false);
        return new CourseLeaderboardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseLeaderboardViewHolder holder, int position) {
        Score score = scoreList.get(position);
        holder.binding.setScore(score);

        for (int i = 0; i < getItemCount(); i++) {
            int rank = position + 1;
            score.setRank(rank);
            holder.binding.setScore(score);
        }
    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }

    static class CourseLeaderboardViewHolder extends RecyclerView.ViewHolder {

        private final CourseLeaderboardRecyclerViewBinding binding;

        public CourseLeaderboardViewHolder(@NonNull CourseLeaderboardRecyclerViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
