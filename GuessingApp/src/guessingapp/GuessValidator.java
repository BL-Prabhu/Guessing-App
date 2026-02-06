package guessingapp;

/**
 * Use Case 2: User Guess Submission
 *
 * This class compares the user's guess
 * with the target number.
 *
 * No input or output handled here.
 */
public class GuessValidator
{

    public static String validateGuess(int guess, int target) {

        if (guess == target)
        {
            return "correct";
        } else if (guess < target) {
            return "high";
        }

        return "low";
    }
}

