package com.sports.scoreboard.operation;

import com.sports.scoreboard.domain.Game;
import com.sports.scoreboard.domain.Scoreboard;

import java.util.Collections;
import java.util.List;

public class ScoreboardOperation {

    public static int startGame(Scoreboard scoreboard, String homeTeamName, String awayTeamName) {
        int gameId = scoreboard.startGame(homeTeamName, awayTeamName);
        System.out.printf("Game started %s - %s, with game ID: %d%n", homeTeamName, awayTeamName, gameId);
        return gameId;
    }

    public static void updateGame(Scoreboard scoreboard, int gameId, int homeTeamScore, int awayTeamScore) {
    }

    public static void finishGame(Scoreboard scoreboard, int gameId) {
    }

    public static List<Game> getSortedGameList(Scoreboard scoreboard) {
        return Collections.emptyList();
    }
}
