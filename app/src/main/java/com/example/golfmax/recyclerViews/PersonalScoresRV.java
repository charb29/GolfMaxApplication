package com.example.golfmax.recyclerViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.golfmax.R;
import com.example.golfmax.databinding.PersonalScoresRecyclerViewBinding;
import com.example.golfmax.models.Score;

import java.util.List;

public class PersonalScoresRV extends RecyclerView.Adapter<PersonalScoresRV.
        PersonalScoresViewHolder> {

    Context context;
    List<Score> scoreList;

    public PersonalScoresRV(Context context, List<Score> scoreList) {
        this.context = context;
        this.scoreList = scoreList;
    }

    @NonNull
    @Override
    public PersonalScoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PersonalScoresRecyclerViewBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.personal_scores_recycler_view,
                        parent,
                        false);
        return new PersonalScoresViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalScoresViewHolder holder, int position) {
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

    static class PersonalScoresViewHolder extends RecyclerView.ViewHolder {

        private final PersonalScoresRecyclerViewBinding binding;
        public Context context;

        public PersonalScoresViewHolder(@NonNull PersonalScoresRecyclerViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
