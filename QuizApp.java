import java.util.Scanner;

public class QuizApp {

    private static final String[] questions = {
        "What is the capital of France?",
        "Which planet is known as the Red Planet?",
        "Who wrote 'Romeo and Juliet'?",
        "What is the largest ocean on Earth?",
        "Which element has the chemical symbol 'O'?"
    };

    private static final String[][] options = {
        {"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"},
        {"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"},
        {"1. William Shakespeare", "2. Charles Dickens", "3. J.K. Rowling", "4. Mark Twain"},
        {"1. Atlantic", "2. Indian", "3. Arctic", "4. Pacific"},
        {"1. Gold", "2. Oxygen", "3. Hydrogen", "4. Nitrogen"}
    };

    private static final int[] correctAnswers = {3, 2, 1, 4, 2};
    private static int score = 0;
    private static int[] userAnswers = new int[questions.length];
    private static final int TIME_LIMIT = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            presentQuestion(i, scanner);
        }

        scanner.close();
        displayResult();
    }

    private static void presentQuestion(int questionIndex, Scanner scanner) {
        System.out.println("Question " + (questionIndex + 1) + ": " + questions[questionIndex]);

        for (String option : options[questionIndex]) {
            System.out.println(option);
        }

        Thread timerThread = new Thread(() -> {
            try {
                Thread.sleep(TIME_LIMIT * 1000);
                System.out.println("\nTime's up! Moving to the next question.");
                synchronized (scanner) {
                    scanner.notify(); 
                }
            } catch (InterruptedException e) {
                
            }
        });

        timerThread.start();

        synchronized (scanner) {
            System.out.print("Your answer (1-4): ");
            if (scanner.hasNextInt()) {
                userAnswers[questionIndex] = scanner.nextInt();
                if (userAnswers[questionIndex] == correctAnswers[questionIndex]) {
                    score++;
                }
            } else {
                userAnswers[questionIndex] = 0;
                scanner.next(); 

            timerThread.interrupt(); 
            }
        }
    }

    private static void displayResult() {
        System.out.println("\nQuiz Finished!");
        System.out.println("Your final score is: " + score + " out of " + questions.length);

        System.out.println("\nSummary:");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            System.out.println("Your answer: " + (userAnswers[i] == 0 ? "No answer" : options[i][userAnswers[i] - 1]));
            System.out.println("Correct answer: " + options[i][correctAnswers[i] - 1]);
            System.out.println();
        }
    }
}