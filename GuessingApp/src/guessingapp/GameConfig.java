package guessingapp;

import java.util.Random;

/**
 * GAME CONFIGURATION CLASS
 *
 * Responsible for:
 * - Initializing game settings
 * - Generating target number
 * - Displaying rules
 */
public class GameConfig {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 7;

    private int targetNumber;

    public GameConfig() {
        Random random = new Random();
        targetNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    public void showRules() {
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have 7 attempts");
        System.out.println("Hints will be provided after wrong guesses");
        System.out.println();
    }
}
