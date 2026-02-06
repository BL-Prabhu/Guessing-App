package guessingapp;
import java.util.Random;
/**
 * Project      : Number Guessing Game (Java Console Application)
 * Use Case     : UC1 – Game Initialization
 * Description  : Initializes the guessing game by configuring rules,
 *                generating a random target number, and displaying
 *                welcome instructions to the user.
 *
 * Author       : Prabhu
 * Version      : 1.0
 *
 * Commands:
 *   Compile -> javac GuessingGame.java
 *   Run     -> java GuessingGame
 */
public class GuessingAppUseCase1
{

    // ================================
    // Constants (easy to modify difficulty)
    // ================================
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 7;
    private static final int MAX_HINTS = 3;

    // ================================
    // Encapsulated game configuration
    // ================================
    private int targetNumber;
    private int attemptsLeft;
    private int hintsLeft;

    // ================================
    // UC1 – Game Initialization
    // Constructor initializes game state
    // ================================

    /**
     * Constructor
     * Initializes game configuration
     */
    public GuessingAppUseCase1()
    {
        this.attemptsLeft = MAX_ATTEMPTS;
        this.hintsLeft = MAX_HINTS;
        this.targetNumber = generateRandomNumber();
    }

    /**
     * Generates a random number within the defined range
     */
    private int generateRandomNumber()
    {
        Random random = new Random();
        return random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
    }

    // ---------------- GETTER METHODS ----------------

    /**
     * Returns the randomly generated target number
     */
    public int getTargetNumber() {
        return targetNumber;
    }

    /**
     * Returns the maximum number of attempts allowed
     */
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    /**
     * Returns the maximum number of hints allowed
     */
    public int getMaxHints() {
        return MAX_HINTS;
    }

    /**
     * Displays game welcome message and rules
     */
    public void displayWelcomeMessage()
    {
        System.out.println("Welcome to the Guessing App");
        System.out.println("Guess a number between " + MIN_RANGE + " and " + MAX_RANGE);
        System.out.println("You have " + attemptsLeft + " attempts");
        System.out.println("Hints will be provided after wrong guesses");
    }

    /**
     * Application entry point
     */
    public static void main(String[] args)
    {
        GuessingAppUseCase1 game = new GuessingAppUseCase1();
        game.displayWelcomeMessage();
    }
}
