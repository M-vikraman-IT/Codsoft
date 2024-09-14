import java.util.*;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        boolean replay= true;
        int totScore = 0;
        int rounds = 0;
        while (replay) {
            int ranNumber = r.nextInt(100) + 1;
            int attempts = 0;
            boolean correctGuess = false;
            rounds++;
            System.out.println("Round " + rounds + ": Guess the number (b/w 1 and 100). Note: only 10 attempts.");
            while (attempts < 10 && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = s.nextInt();
                attempts++;
                if (userGuess == ranNumber) {
                    System.out.println("Congratulations! That was correct guess! " + attempts + " attempts.");
                    correctGuess = true;
                    totScore += 10 - attempts;
                } else if (userGuess < ranNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!correctGuess) {
                System.out.println("Sorry, you've used all attempts. The correct Answer was " + ranNumber + ".");
            }
            rounds++;
            System.out.print("Ready for round "+rounds+"? : ");
            String response = s.next();
            replay = response.equalsIgnoreCase("yes");
        }
        
        s.close();
    }
}