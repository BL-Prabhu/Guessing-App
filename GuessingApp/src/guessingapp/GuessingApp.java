package guessingapp;

import java.util.Scanner;

/**
 * MAIN CLASS
 *
 * Coordinates the game flow:
 * - Game initialization
 * - User input
 * - Validation & error handling
 * - Hint generation
 *
 * @author Prabhu
 * @version 4.0
 */
public class GuessingApp
{

    public static void main(String[] args) {

        System.out.println("🎯 Welcome to the Guessing App");

        GameConfig config = new GameConfig();
        config.showRules();

        Scanner scanner = new Scanner(System.in);

        int attempts = 0;
        int hintsUsed = 0;

        while (attempts < config.getMaxAttempts()) {

            System.out.print("Enter your guess: ");

            try {
                int guess = ValidationService.validateInput(scanner.nextLine());
                attempts++;

                String result = GuessValidator.validateGuess(
                        guess,
                        config.getTargetNumber()
                );

                System.out.println(result);

                // UC3 – Hint generation
                if (!"CORRECT".equals(result) && hintsUsed < config.getMaxHints()) {
                    hintsUsed++;
                    System.out.println(
                            HintService.generateHint(
                                    config.getTargetNumber(),
                                    hintsUsed
                            )
                    );
                }

                if ("CORRECT".equals(result)) {
                    System.out.println("🎉 You guessed the number in " + attempts + " attempts!");
                    break;
                }

            } catch (InvalidInputException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }

        if (attempts == config.getMaxAttempts()) {
            System.out.println("❌ Game Over! Target number was: " + config.getTargetNumber());
        }

        scanner.close();
    }
}
