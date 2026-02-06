package guessingapp;

import java.util.Scanner;

/**
 * MAIN CLASS
 *
 * Coordinates the game flow:
 * 1. Initialize game
 * 2. Accept user guesses
 * 3. Validate guesses
 * 4. Stop when game ends
 *
 * @author Prabhu
 * @version 3.0
 */
public class GuessingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App");

        GameConfig config = new GameConfig();
        config.showRules();

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int hintCount = 0;

        /*
         * Game loop runs until the player
         * exhausts the maximum attempts.
         */
        while (attempts < config.getMaxAttempts()) {

            System.out.print("enter your guess : ");

            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }

            int guess = scanner.nextInt();
            attempts++;

            String result = GuessValidator.validateGuess(
                    guess,
                    config.getTargetNumber()
            );

            System.out.println(result.toUpperCase());

            if (result.equals("correct"))
            {
                break;
            }
            else
            {
                hintCount++;
                System.out.println(
                        HintService.generateHint(
                                config.getTargetNumber(),
                                hintCount
                        )
                );
            }

        }

        scanner.close();
    }
}
