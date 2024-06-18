package com.sports.scoreboard.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    private final List<Game> gameList;
    private static int gameIdCounter = 1;

    public Scoreboard() {
        this.gameList = new ArrayList<>();
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public int startGame(String homeTeamName, String awayTeamName) {
        int gameId = gameIdCounter++;
        gameList.add(new Game(gameId, homeTeamName, awayTeamName));
        return gameId;
    }

    public void updateGame(int gameId, int homeTeamScore, int awayTeamScore) {
        Game selectedGame = gameList.stream().filter(game -> game.getGameId() == gameId).findFirst().orElseThrow();
        selectedGame.getHomeTeam().setScore(homeTeamScore);
        selectedGame.getAwayTeam().setScore(awayTeamScore);
        selectedGame.setUpdatedTime(LocalDateTime.now());
    }
}
