
import java.util.Scanner;


public class SGC{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int number_Of_Subjects = s.nextInt();
        int[] marks = new int[number_Of_Subjects];
        for (int i = 0; i < number_Of_Subjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = s.nextInt();
        }

        int totalMarks = totalMarks(marks);
        double averagePercentage = averagePercentage(totalMarks, number_Of_Subjects);
        char grade = calculateGrade(averagePercentage);
        displayResults(totalMarks, averagePercentage, grade);
        s.close();
    }

    private static int totalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private static double averagePercentage(int totalMarks, int number_Of_Subjects) {
        return (double) totalMarks / number_Of_Subjects;
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average(Percentage): " + averagePercentage + "%");
        System.out.println("Grade: " +grade);
    }
}
