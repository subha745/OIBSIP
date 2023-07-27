import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private int randomNumber;
    private int maxRange;
    private int attempts;

    public GuessTheNumberGame(int maxRange) {
        this.maxRange = maxRange;
        this.randomNumber = generateRandomNumber(maxRange);
        this.attempts = 0;
    }

    public void play() {
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have chosen a number between 1 and " + maxRange);
        System.out.println("Can you guess it?");

        Scanner scanner = new Scanner(System.in);
        int guess;
        boolean guessedCorrectly = false;

        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
            } else if (guess < randomNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }
        }
    }

    private int generateRandomNumber(int maxRange) {
        Random random = new Random();
        return random.nextInt(maxRange) + 1;
    }

    public static void main(String[] args) {
        GuessTheNumberGame game = new GuessTheNumberGame(100);
        game.play();
    }
}

