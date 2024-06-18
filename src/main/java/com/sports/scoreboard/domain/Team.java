package com.sports.scoreboard.domain;

public class Team {
    private final String teamName;
    private int score;

    public Team(String teamName) {
        this.teamName = teamName;
        this.score = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
