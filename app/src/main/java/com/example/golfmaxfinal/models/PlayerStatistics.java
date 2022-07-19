package com.example.golfmaxfinal.models;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.golfmaxfinal.BR;

public class PlayerStatistics extends BaseObservable {

    private int roundsPlayed;
    private double handicapIndex;
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
    @Override
    public String toString() {
        return "Player Stats (" +
                " roundsPlayed = '" + roundsPlayed + '\'' +
                " handicapIndex = '" + handicapIndex + '\'' +
                " averageScore = '" + averageScore + '\'' +
                ')';
    }
}
