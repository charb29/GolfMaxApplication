package com.example.golfmax.Responses;

import com.example.golfmax.Models.User;

public class PlayerStatisticsResponse {

    private long id;
    private User user;
    private int roundsPlayed;
    private double handicapIndex;
    private double averageScore;

    public PlayerStatisticsResponse() {}

    public PlayerStatisticsResponse(long id, User user, int roundsPlayed, double handicapIndex, double averageScore) {
        this.id = id;
        this.user = user;
        this.roundsPlayed = roundsPlayed;
        this.handicapIndex = handicapIndex;
        this.averageScore = averageScore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    public double getHandicapIndex() {
        return handicapIndex;
    }

    public void setHandicapIndex(double handicapIndex) {
        this.handicapIndex = handicapIndex;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
}
