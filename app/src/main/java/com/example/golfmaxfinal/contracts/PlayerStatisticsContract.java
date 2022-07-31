package com.example.golfmaxfinal.contracts;

import com.example.golfmaxfinal.models.PlayerStatistics;

public interface PlayerStatisticsContract {

    interface Presenter {
    }

    interface View {
        void showData(PlayerStatistics playerStatistics);
    }
}
