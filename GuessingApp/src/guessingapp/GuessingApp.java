package guessingapp;

import java.util.Scanner;

/**
 * ============================================================
 * GuessingApp
 * ============================================================
 *
 * <p>
 * Main entry point of the Number Guessing Game application.
 * This class controls the complete application lifecycle and
 * integrates all use cases from UC1 to UC6.
 * </p>
 *
 * <h3>Responsibilities</h3>
 * <ul>
 *     <li>Start the game</li>
 *     <li>Accept player name</li>
 *     <li>Coordinate game flow (guessing, hints, validation)</li>
 *     <li>Persist game results (UC5)</li>
 *     <li>Handle restart or graceful exit (UC6)</li>
 * </ul>
 *
 * <h3>Use Cases Covered</h3>
 * <ul>
 *     <li>UC1 – Game Initialization</li>
 *     <li>UC2 – User Guess Submission</li>
 *     <li>UC3 – Hint Generation</li>
 *     <li>UC4 – Input Validation</li>
 *     <li>UC5 – Persist Game Result</li>
 *     <li>UC6 – Game Restart & Exit</li>
 * </ul>
 *
 * <p>
 * The game allows the player to restart multiple sessions
 * without restarting the application, ensuring better
 * usability and resource-safe execution.
 * </p>
 *
 * @author Prabhu
 * @version 6.0
 */
public class GuessingApp {

    /**
     * Main method that launches the Guessing Application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args)
    {

        System.out.println("🎯 Welcome to the Guessing App");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Player Name: ");
        String playerName = scanner.nextLine();

        boolean restart;

        /**
         * Outer loop (UC6):
         * Controls whether a new game session should start
         * or the application should exit.
         */
        do {
            // ================= UC1: Game Initialization =================
            GameConfig config = new GameConfig();
            config.showRules();

            int attempts = 0;
            int hintsUsed = 0;
            boolean win = false;

            /**
             * Inner loop:
             * Handles the guessing logic for a single game session.
             */
            while (attempts < config.getMaxAttempts()) {

                System.out.print("Enter your guess: ");

                try {
                    int guess =
                            ValidationService.validateInput(scanner.nextLine());
                    attempts++;

                    String result =
                            GuessValidator.validateGuess(
                                    guess,
                                    config.getTargetNumber()
                            );

                    System.out.println(result);

                    // ================= UC3: Hint Generation =================
                    if (!"CORRECT".equalsIgnoreCase(result)
                            && hintsUsed < config.getMaxHints()) {

                        hintsUsed++;
                        System.out.println(
                                HintService.generateHint(
                                        config.getTargetNumber(),
                                        hintsUsed
                                )
                        );
                    }

                    if ("CORRECT".equalsIgnoreCase(result)) {
                        win = true;
                        System.out.println(
                                "🎉 You guessed the number in "
                                        + attempts + " attempts!"
                        );
                        break;
                    }

                } catch (InvalidInputException e) {
                    // ================= UC4: Input Validation =================
                    System.out.println("❌ " + e.getMessage());
                }
            }

            if (!win) {
                System.out.println(
                        "❌ Game Over! Target number was: "
                                + config.getTargetNumber()
                );
            }

            // ================= UC5: Persist Game Result =================
            GameResult gameResult =
                    new GameResult(playerName, attempts, win);
            StorageService.save(gameResult);

            // ================= UC6: Restart / Exit =================
            System.out.print("Do you want to play again? (yes/no): ");
            restart = scanner.nextLine().equalsIgnoreCase("yes");

        } while (restart);

        System.out.println("👋 Thank you for playing!");
        scanner.close();
    }
}
