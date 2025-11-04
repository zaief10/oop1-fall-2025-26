package Lab;

import java.util.Scanner;

public class Score {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student score=");
        double A1 = scanner.nextDouble();
        double A2 = scanner.nextDouble();
        double A3 = scanner.nextDouble();

        double avg = (A1 + A2 + A3) / 3;
        System.out.printf("Average score = 5.2f\n");
        scanner.close();

    }
}