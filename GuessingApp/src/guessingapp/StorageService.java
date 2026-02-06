package guessingapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ============================================================
 * StorageService
 * ============================================================
 *
 * <p>
 * Responsible for persisting game results to a permanent
 * storage medium.
 * </p>
 *
 * <p>
 * This implementation uses file-based storage and writes
 * game results to a text file in append mode.
 * </p>
 *
 * <p>
 * Each game result includes:
 * </p>
 * <ul>
 *     <li>Player name</li>
 *     <li>Number of attempts</li>
 *     <li>Game outcome (WIN / LOSE)</li>
 *     <li>Timestamp of the game</li>
 * </ul>
 *
 * <p>
 * This class demonstrates:
 * </p>
 * <ul>
 *     <li>File I/O using {@link BufferedWriter}</li>
 *     <li>Safe resource handling using try-with-resources</li>
 *     <li>Object persistence</li>
 * </ul>
 *
 * <p>
 * Part of <b>UC5 – Game Result Storage</b>.
 * </p>
 *
 * <p>
 * Future enhancements may include database (JDBC)
 * or serialization-based persistence.
 * </p>
 *
 * @author Prabhu
 * @version 5.0
 */
public class StorageService
{

    /**
     * Name of the file where game results are stored.
     *
     * <p>
     * The file is created automatically if it does not exist
     * in the application's working directory.
     * </p>
     */
    private static final String FILE_NAME = "game_results.txt";

    /**
     * Saves a single {@link GameResult} record to the storage file.
     *
     * <p>
     * The record is appended to the file to preserve
     * previous game history.
     * </p>
     *
     * <p>
     * File format:
     * </p>
     * <pre>
     * Player name : Prabhu, Attempts : 4, Result : WIN, 2026-02-06T17:20:44.881
     * </pre>
     *
     * @param result the game result to be persisted
     */
    public static void save(GameResult result) {

        String record =
                "Player name : " + result.getPlayerName() +
                        ", Attempts : " + result.getAttempts() +
                        ", Result : " + (result.isWin() ? "WIN" : "LOSE") +
                        ", " + result.getPlayedAt();

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(record);
            writer.newLine();

            System.out.println("✅ Game result saved.");

        } catch (IOException e) {
            System.out.println("❌ Failed to save game result.");
        }
    }
}
