package guessingapp;

import java.util.Scanner;

public class GameSessionRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Player Name: ");
        String playerName = scanner.nextLine();

        // Run original game
        GameConfig config = new GameConfig();
        config.showRules();

        int attempts = 0;
        int hintsUsed = 0;
        boolean win = false;

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
                    win = true;
                    System.out.println("🎉 You guessed the number in " + attempts + " attempts!");
                    break;
                }

            } catch (InvalidInputException e) {
                System.out.println("❌ " + e.getMessage());
            }
        }

        if (!win) {
            System.out.println("❌ Game Over! Target number was: " + config.getTargetNumber());
        }

        // ✅ UC5 – Persist result
        GameResult gameResult =
                new GameResult(playerName, attempts, win);

        StorageService.save(gameResult);

        scanner.close();
    }
}
