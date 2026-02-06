package guessingapp;

import java.util.Random;

/**
 * Holds all game configuration values.
 */
public class GameConfig
{

    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 5;
    private static final int MAX_HINTS = 2;

    private final int targetNumber;

    public GameConfig()
    {
        this.targetNumber = new Random().nextInt(MAX - MIN + 1) + MIN;
    }

    public int getTargetNumber()
    {
        return targetNumber;
    }

    public int getMaxAttempts()
    {
        return MAX_ATTEMPTS;
    }

    public int getMaxHints() {
        return MAX_HINTS;
    }

    public void showRules()
    {
        System.out.println("📜 Rules:");
        System.out.println("- Guess a number between 1 and 100");
        System.out.println("- Maximum attempts: " + MAX_ATTEMPTS);
        System.out.println("- Maximum hints: " + MAX_HINTS);
        System.out.println("----------------------------------");
    }
}
