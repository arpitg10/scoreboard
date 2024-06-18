package com.sports.scoreboard.domain;

import java.time.LocalDateTime;

public class Game {
    private final int gameId;
    private final Team homeTeam;
    private final Team awayTeam;

    private final LocalDateTime startedTime;
    private LocalDateTime updatedTime;
}
