package com.sports.scoreboard;

import com.sports.scoreboard.domain.Scoreboard;

import static com.sports.scoreboard.util.InputHelper.getIntInput;

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
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

