package guessingapp;

import java.util.Random;

/**
 * ============================================================
 * GameConfig
 * ============================================================
 *
 * <p>
 * Holds all configuration values required to initialize
 * and control a single game session.
 * </p>
 *
 * <p>
 * This class is responsible for:
 * </p>
 * <ul>
 *     <li>Defining the valid guessing range</li>
 *     <li>Setting maximum attempts allowed</li>
 *     <li>Limiting number of hints</li>
 *     <li>Generating a random target number</li>
 * </ul>
 *
 * <p>
 * GameConfig is immutable with respect to the target number
 * once a game session starts, ensuring consistency
 * throughout the game lifecycle.
 * </p>
 *
 * <h3>Use Case</h3>
 * <ul>
 *     <li>UC1 – Game Initialization</li>
 * </ul>
 *
 * @author Prabhu
 * @version 6.0
 */
public class GameConfig
{

    /** Minimum possible number for guessing */
    private static final int MIN = 1;

    /** Maximum possible number for guessing */
    private static final int MAX = 100;

    /** Maximum number of attempts allowed per game */
    private static final int MAX_ATTEMPTS = 5;

    /** Maximum number of hints allowed per game */
    private static final int MAX_HINTS = 2;

    /**
     * Randomly generated target number that the player
     * must guess during the game session.
     */
    private final int targetNumber;

    /**
     * Constructs a new {@code GameConfig} instance and
     * generates a random target number within the
     * configured range.
     */
    public GameConfig()
    {
        this.targetNumber = new Random().nextInt(MAX - MIN + 1) + MIN;
    }

    /**
     * Returns the target number to be guessed.
     *
     * @return the randomly generated target number
     */
    public int getTargetNumber()
    {
        return targetNumber;
    }

    /**
     * Returns the maximum number of attempts allowed
     * for the player.
     *
     * @return maximum attempts per game
     */
    public int getMaxAttempts()
    {
        return MAX_ATTEMPTS;
    }

    /**
     * Returns the maximum number of hints allowed
     * during a game session.
     *
     * @return maximum hints per game
     */
    public int getMaxHints()
    {
        return MAX_HINTS;
    }

    /**
     * Displays the game rules and configuration details
     * to the console.
     */
    public void showRules()
    {
        System.out.println("📜 Rules:");
        System.out.println("- Guess a number between 1 and 100");
        System.out.println("- Maximum attempts: " + MAX_ATTEMPTS);
        System.out.println("- Maximum hints: " + MAX_HINTS);
        System.out.println("----------------------------------");
    }
}
