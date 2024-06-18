# Scoreboard

This is a console application to manage games and view scoreboard of FIFA Football World Cup. Users can perform various
operations related to game management through a simple command-line interface.

## Stack

- [JDK 17](https://openjdk.org/projects/jdk/17/)
- [Java](https://dev.java/)
- [Gradle](https://gradle.org/)
- [Junit 5](https://junit.org/junit5/)

## Build

```bash
gradle build
```

## Run

```bash
java -jar build/libs/scoreboard-1.0-SNAPSHOT.jar
```

## Scoreboard Features

1. **Start a Game**
   <br/> Begin a new game by providing names of home and away team.
   Initial score will be 0-0. You'll get a game ID which will be unique to every game. Game ID can be used to finish
   the game or update the game score.

2. **Update a Game**
   <br/> Modify the score of an ongoing game by providing the current score of both teams. Game ID will be required to
   perform this action.

3. **Finish a Game**
   <br/> Mark a game as finished. Finished game will be removed from the scoreboard. Game ID will be required to
   perform this action.

4. **Get Live Scoreboard**
   <br/> Monitor real-time scores for ongoing games. Games are sorted as follows:<br/>
   Games with a higher accumulated score appear first. If two games have the same accumulated score, the most recently
   updated game will be prioritized.

### Watch out

- If an invalid game ID is provided for updating or finishing a game, operation will not be performed and same will be
  conveyed through message in command-line.