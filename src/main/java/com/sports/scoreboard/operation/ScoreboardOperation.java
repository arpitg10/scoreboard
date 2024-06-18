package com.sports.scoreboard.operation;

import com.sports.scoreboard.domain.Game;
import com.sports.scoreboard.domain.Scoreboard;

import java.util.List;
import java.util.NoSuchElementException;

public class ScoreboardOperation {

    public static int startGame(Scoreboard scoreboard, String homeTeamName, String awayTeamName) {
        int gameId = scoreboard.startGame(homeTeamName, awayTeamName);
        System.out.printf("Game started %s - %s, with game ID: %d%n", homeTeamName, awayTeamName, gameId);
        return gameId;
    }

    public static void updateGame(Scoreboard scoreboard, int gameId, int homeTeamScore, int awayTeamScore) {
        try {
            scoreboard.updateGame(gameId, homeTeamScore, awayTeamScore);
            System.out.println("Game score updated successfully");
        } catch (NoSuchElementException e) {
            System.out.println("No game found with provided game ID");
        }
    }

    public static void finishGame(Scoreboard scoreboard, int gameId) {
        if (scoreboard.finishGame(gameId)) {
            System.out.println("Game finished successfully!!");
        } else {
            System.out.println("No game is present with provided game Id.");
        }
    }

    public static List<Game> getSortedGameList(Scoreboard scoreboard) {
        List<Game> gameList = scoreboard.getGameList();
        gameList.sort((a, b) -> {
            int gameOneAccumulated = a.getHomeTeam().getScore() + a.getAwayTeam().getScore();
            int gameTwoAccumulated = b.getHomeTeam().getScore() + b.getAwayTeam().getScore();
            if (gameOneAccumulated > gameTwoAccumulated) {
                return -1;
            } else if (gameTwoAccumulated > gameOneAccumulated) {
                return 1;
            } else if (a.getUpdatedTime().isAfter(b.getUpdatedTime())) {
                return -1;
            } else {
                return 1;
            }
        });
        return gameList;
    }
}
