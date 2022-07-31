package com.example.golfmax.contracts;

import com.example.golfmax.models.PlayerStatistics;

public interface PlayerStatisticsContract {

    interface Presenter {
    }

    interface View {
        void showData(PlayerStatistics playerStatistics);
    }
}
