package guessingapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StorageService {

    private static final String FILE_NAME = "game_results.txt";

    public static void save(GameResult result)
    {

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
