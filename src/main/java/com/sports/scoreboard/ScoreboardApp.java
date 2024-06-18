package com.sports.scoreboard;

import com.sports.scoreboard.domain.Game;
import com.sports.scoreboard.domain.Scoreboard;

import java.util.List;

import static com.sports.scoreboard.operation.ScoreboardOperation.*;
import static com.sports.scoreboard.util.InputHelper.getIntInput;
import static com.sports.scoreboard.util.InputHelper.getStringInput;

public class ScoreboardApp {

    public static void main(String[] args) {

        System.out.println("""
                **********************************************
                Welcome to the Football World Cup Scoreboard!
                **********************************************
                """
        );

        boolean running = true;

        Scoreboard scoreboard = new Scoreboard();

        while (running) {
            try {
                System.out.println("""
                        1 - Start a game.
                        2 - Update a game.
                        3 - Finish a game.
                        4 - Get live scoreboard.
                        5 - Exit.
                        """);

                int option = getIntInput("Choose from the above options: ");

                if (option > 5) {
                    throw new IllegalArgumentException("Please provide valid option from the given list");
                } else if (option == 5) {
                    running = false;
                } else {
                    switch (option) {
                        case 1 -> {
                            String homeTeamName = getStringInput("Enter home team name: ");
                            String awayTeamName = getStringInput("Enter away team name: ");
                            startGame(scoreboard, homeTeamName, awayTeamName);
                        }
                        case 2 -> {
                            int gameId = getIntInput("Enter game id: ");
                            int homeTeamScore = getIntInput("Enter home team score: ");
                            int awayTeamScore = getIntInput("Enter away team score: ");
                            updateGame(scoreboard, gameId, homeTeamScore, awayTeamScore);
                        }
                        case 3 -> {
                            int gameId = getIntInput("Enter game id: ");
                            finishGame(scoreboard, gameId);
                        }
                        case 4 -> {
                            List<Game> gameList = getSortedGameList(scoreboard);
                            if (gameList.isEmpty()) {
                                System.out.println("No active games found.");
                            } else {
                                System.out.println("**********************Scoreboard**********************");
                                gameList.forEach(System.out::println);
                                System.out.println("******************************************************");
                            }
                        }
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

