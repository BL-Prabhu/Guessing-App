package guessingapp;

import java.util.Scanner;

/**
 * ============================================================
 * GameSessionRunner
 * ============================================================
 *
 * <p>
 * Acts as a standalone runner for executing a single
 * game session of the Guessing App.
 * </p>
 *
 * <p>
 * This class demonstrates the complete game flow:
 * </p>
 * <ul>
 *     <li>UC1 – Game initialization</li>
 *     <li>UC2 – User guess submission</li>
 *     <li>UC3 – Hint generation</li>
 *     <li>UC4 – Input validation and error handling</li>
 *     <li>UC5 – Game result persistence</li>
 * </ul>
 *
 * <p>
 * Unlike {@link GuessingApp}, this runner does not
 * support restart functionality (UC6).
 * </p>
 *
 * <p>
 * Intended for testing, demonstration, or debugging
 * a single game lifecycle.
 * </p>
 *
 * @author Prabhu
 * @version 6.0
 */
public class GameSessionRunner
{

    /**
     * Entry point for running a single game session.
     *
     * <p>
     * Handles player input, game logic execution,
     * and result persistence.
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Player Name: ");
        String playerName = scanner.nextLine();

        // ===== UC1: Game Initialization =====
        GameConfig config = new GameConfig();
        config.showRules();

        int attempts = 0;
        int hintsUsed = 0;
        boolean win = false;

        // ===== UC2–UC4: Game Play Loop =====
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

                if (!"CORRECT".equals(result)
                        && hintsUsed < config.getMaxHints()) {

                    hintsUsed++;
                    System.out.println(
                            HintService.generateHint(
                                    config.getTargetNumber(),
                                    hintsUsed
                            )
                    );
                }

                if ("CORRECT".equals(result)) {
                    win = true;
                    System.out.println(
                            "🎉 You guessed the number in "
                                    + attempts + " attempts!"
                    );
                    break;
                }

            } catch (InvalidInputException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }

        if (!win) {
            System.out.println(
                    "❌ Game Over! Target number was: "
                            + config.getTargetNumber()
            );
        }

        // ===== UC5: Persist Game Result =====
        GameResult gameResult =
                new GameResult(playerName, attempts, win);

        StorageService.save(gameResult);

        // Resource cleanup
        scanner.close();
    }
}
