package com.sports.scoreboard.domain;

import java.time.LocalDateTime;

public class Game {
    private final int gameId;
    private final Team homeTeam;
    private final Team awayTeam;

    private final LocalDateTime startedTime;
    private LocalDateTime updatedTime;

    public Game(int gameId, String homeTeamName, String awayTeamName) {
        this.gameId = gameId;
        this.homeTeam = new Team(homeTeamName);
        this.awayTeam = new Team(awayTeamName);
        this.startedTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

    public int getGameId() {
        return gameId;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
