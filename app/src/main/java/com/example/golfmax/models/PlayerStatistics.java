package com.example.golfmax.models;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.golfmax.BR;
import com.google.gson.annotations.SerializedName;

public class PlayerStatistics extends BaseObservable {

    @SerializedName("roundsPlayed")
    private int roundsPlayed;
    @SerializedName("handicapIndex")
    private double handicapIndex;
    @SerializedName("averageScore")
    private double averageScore;

    public PlayerStatistics() {}

    @Bindable
    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
        notifyPropertyChanged(BR.roundsPlayed);
    }

    @Bindable
    public double getHandicapIndex() {
        return handicapIndex;
    }

    public void setHandicapIndex(double handicapIndex) {
        this.handicapIndex = handicapIndex;
        notifyPropertyChanged(BR.handicapIndex);
    }

    @Bindable
    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
        notifyPropertyChanged(BR.averageScore);
    }

    @NonNull
    public String toStringRoundsPlayed() {
        return "Player Statistics (" +
                " Rounds Played = '" + roundsPlayed + '\'' +
                ')';
    }

    @NonNull
    public String toStringHandicapIndex() {
        return "Player Statistics (" +
                " Handicap Index = '" + handicapIndex + '\'' +
                ')';
    }

    @NonNull
    public String toStringAverageScore() {
        return "Player Statistics (" +
                " Average Score = '" + averageScore + '\'' +
                ')';
    }
}
