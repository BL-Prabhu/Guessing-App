package guessingapp;

import java.time.LocalDateTime;

public class GameResult {

    private final String playerName;
    private final int attempts;
    private final boolean win;
    private final LocalDateTime playedAt;

    public GameResult(String playerName, int attempts, boolean win) {
        this.playerName = playerName;
        this.attempts = attempts;
        this.win = win;
        this.playedAt = LocalDateTime.now();
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isWin() {
        return win;
    }

    public LocalDateTime getPlayedAt() {
        return playedAt;
    }
}
