package com.example.golfmax;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.golfmax.Models.Scores;

import java.util.List;

public class ScoresRecyclerView extends RecyclerView.Adapter<ScoresRecyclerView.MyViewHolder> {

    private Context context;
    private List<Scores> scoresList;

    public ScoresRecyclerView(Context context, List<Scores> scoresList) {
        this.context = context;
        this.scoresList = scoresList;
    }

    @NonNull
    @Override
    public ScoresRecyclerView.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.scores_rv_item, parent, false);
        return new ScoresRecyclerView.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoresRecyclerView.MyViewHolder holder, int position) {
        holder.textViewCourseName.setText(scoresList.get(position).getCourse().getCourseName());
    }

    @Override
    public int getItemCount() {
        return scoresList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCourseName;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewCourseName = (TextView) itemView.findViewById(R.id.textViewCourseName);
        }
    }
}

