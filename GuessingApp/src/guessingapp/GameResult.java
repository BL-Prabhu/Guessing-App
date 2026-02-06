package guessingapp;

import java.time.LocalDateTime;

/**
 * ============================================================
 * GameResult
 * ============================================================
 *
 * <p>
 * Represents the outcome of a completed game session.
 * </p>
 *
 * <p>
 * This class acts as a simple data carrier (DTO) that captures
 * essential details about a game after it ends, including
 * player identity, number of attempts, win/loss status,
 * and the timestamp of play.
 * </p>
 *
 * <h3>Responsibilities</h3>
 * <ul>
 *     <li>Store immutable game result data</li>
 *     <li>Provide structured access to result fields</li>
 *     <li>Support persistence and reporting use cases</li>
 * </ul>
 *
 * <h3>Use Case</h3>
 * <ul>
 *     <li>UC5 – Persist Game Result</li>
 * </ul>
 *
 * <p>
 * Once created, a {@code GameResult} instance cannot be modified,
 * ensuring data integrity when storing or logging results.
 * </p>
 *
 * @author Prabhu
 * @version 6.0
 */
public class GameResult
{

    /** Name of the player who played the game */
    private final String playerName;

    /** Total number of attempts used by the player */
    private final int attempts;

    /** Indicates whether the player won the game */
    private final boolean win;

    /** Timestamp indicating when the game was played */
    private final LocalDateTime playedAt;

    /**
     * Constructs a {@code GameResult} object with the provided
     * game outcome details.
     *
     * <p>
     * The play timestamp is automatically captured at the
     * time of object creation.
     * </p>
     *
     * @param playerName name of the player
     * @param attempts  number of attempts taken
     * @param win       {@code true} if the player won,
     *                  {@code false} otherwise
     */
    public GameResult(String playerName, int attempts, boolean win) {
        this.playerName = playerName;
        this.attempts = attempts;
        this.win = win;
        this.playedAt = LocalDateTime.now();
    }

    /**
     * Returns the name of the player.
     *
     * @return player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Returns the number of attempts taken by the player.
     *
     * @return attempt count
     */
    public int getAttempts() {
        return attempts;
    }

    /**
     * Indicates whether the player won the game.
     *
     * @return {@code true} if the player won,
     *         {@code false} otherwise
     */
    public boolean isWin() {
        return win;
    }

    /**
     * Returns the date and time when the game was played.
     *
     * @return game play timestamp
     */
    public LocalDateTime getPlayedAt() {
        return playedAt;
    }
}
