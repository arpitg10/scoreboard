package com.sports.scoreboard.operation;

import com.sports.scoreboard.domain.Game;
import com.sports.scoreboard.domain.Scoreboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.sports.scoreboard.operation.ScoreboardOperation.*;
import static org.junit.jupiter.api.Assertions.*;

class ScoreboardOperationTest {

    private Scoreboard scoreboard;

    @BeforeEach
    public void setup() {
        scoreboard = new Scoreboard();
    }

    @Test
    void shouldStartGameAndWithUniqueGameId() {
        int gameId1 = startGame(scoreboard, "HomeTeam1", "AwayTeam1");
        assertEquals(1, scoreboard.getGameList().size());
        assertEquals(gameId1, scoreboard.getGameList().get(0).getGameId());

        int gameId2 = startGame(scoreboard, "HomeTeam2", "AwayTeam2");
        assertEquals(2, scoreboard.getGameList().size());
        assertEquals(gameId2, scoreboard.getGameList().get(1).getGameId());
    }

    @Test
    void shouldAssignUniqueGameIdUsingCounter() {
        int gameId1 = startGame(scoreboard, "HomeTeam1", "AwayTeam1");
        assertEquals(1, scoreboard.getGameList().size());
        assertEquals("HomeTeam1", scoreboard.getGameList().get(0).getHomeTeam().getTeamName());

        int gameId2 = startGame(scoreboard, "HomeTeam2", "AwayTeam2");
        assertEquals(2, scoreboard.getGameList().size());
        assertEquals("HomeTeam2", scoreboard.getGameList().get(1).getHomeTeam().getTeamName());

        finishGame(scoreboard, gameId2);

        int gameId3 = startGame(scoreboard, "HomeTeam3", "AwayTeam3");
        assertEquals(2, scoreboard.getGameList().size());
        assertEquals(gameId1, scoreboard.getGameList().get(0).getGameId());
        assertEquals(gameId3, scoreboard.getGameList().get(1).getGameId());
    }

    @Test
    void updateGameSuccessfully() {
        int gameId1 = startGame(scoreboard, "HomeTeam1", "AwayTeam1");

        int gameId2 = startGame(scoreboard, "HomeTeam2", "AwayTeam2");

        updateGame(scoreboard, gameId2, 3, 1);
        assertEquals(0, scoreboard.getGameList().get(0).getHomeTeam().getScore());
        assertEquals(3, scoreboard.getGameList().get(1).getHomeTeam().getScore());
        assertEquals(1, scoreboard.getGameList().get(1).getAwayTeam().getScore());
    }

    @Test
    void finishGameSuccessfully() {
        int gameId1 = startGame(scoreboard, "HomeTeam1", "AwayTeam1");

        int gameId2 = startGame(scoreboard, "HomeTeam2", "AwayTeam2");

        assertEquals(2, scoreboard.getGameList().size());

        finishGame(scoreboard, gameId1);
        assertEquals(1, scoreboard.getGameList().size());
        assertEquals("HomeTeam2", scoreboard.getGameList().get(0).getHomeTeam().getTeamName());
        assertEquals(gameId2, scoreboard.getGameList().get(0).getGameId());
    }

    @Test
    void getSortedScoreboardSuccessfully() {
        int gameId1 = startGame(scoreboard, "HomeTeam1", "AwayTeam1");
        int gameId2 = startGame(scoreboard, "HomeTeam2", "AwayTeam2");
        int gameId3 = startGame(scoreboard, "HomeTeam3", "AwayTeam3");

        updateGame(scoreboard, gameId1, 3, 3);
        updateGame(scoreboard, gameId2, 1, 0);
        updateGame(scoreboard, gameId3, 1, 5);

        List<Game> scoreboardDisplay = getSortedGameList(scoreboard);

        assertEquals(List.of(gameId3, gameId1, gameId2), scoreboardDisplay.stream().map(Game::getGameId).toList());
    }
}