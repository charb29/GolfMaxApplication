package com.example.golfmax.RecyclerViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.golfmax.Models.Score;
import com.example.golfmax.R;

import java.util.Collections;
import java.util.List;

public class ScoresRV extends RecyclerView.Adapter<ScoresRV.MyViewHolder> {

    private Context context;
    private List<Score> scoreList;

    public ScoresRV(Context context, List<Score> scoreList) {
        this.context = context;
        this.scoreList = scoreList;
    }

    @NonNull
    @Override
    public ScoresRV.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.scores_rv_item, parent, false);
        return new ScoresRV.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoresRV.MyViewHolder holder, int position) {
        holder.tvCourseName.setText(scoreList.get(position).getCourse().getCourseName());
        holder.tvUserScore.setText(scoreList.get(position).getUserScore());

        for (int i = 0; i < getItemCount(); i++) {
            holder.tvRank.setText(String.valueOf(position + 1));
        }

    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCourseName, tvUserScore, tvRank;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvCourseName = (TextView) itemView.findViewById(R.id.text_view_course_name);
            tvUserScore = (TextView) itemView.findViewById(R.id.text_view_user_score);
            tvRank = (TextView) itemView.findViewById(R.id.text_view_rank);
        }
    }
}

