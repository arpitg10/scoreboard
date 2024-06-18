package com.sports.scoreboard.operation;

import com.sports.scoreboard.domain.Game;
import com.sports.scoreboard.domain.Scoreboard;

import java.util.Collections;
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
    }

    public static List<Game> getSortedGameList(Scoreboard scoreboard) {
        return Collections.emptyList();
    }
}
