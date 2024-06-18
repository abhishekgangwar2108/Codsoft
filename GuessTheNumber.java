import java.util.*;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("\nYou've to guess a number between 1 and 100");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 10;
            int roundScore = 0;

            System.out.println("\nNumber is generated between 1 and 100.");
            System.out.println("You have 10 attempts to guess the correct number.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (Attempts left: " + attemptsLeft + "): ");
                int guess;

                try {
                    guess = Integer.parseInt(scanner.nextLine());

                    if (guess < 1 || guess > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                attemptsLeft--;
                roundScore++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } 
                else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                }
                 else {
                    System.out.println("Congratulations! You've guessed the correct number " + numberToGuess + " in " + roundScore + " attempts.");
                    totalScore += roundScore;
                    break;
                }
            }

            if (attemptsLeft == 0) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine().trim().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thank you for playing! Your total score is " + totalScore + " points.");
        scanner.close();
    }
}
