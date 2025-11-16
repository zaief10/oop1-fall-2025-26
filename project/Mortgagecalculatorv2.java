package project;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mortgagecalculatorv2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double monthlySalary = 0;
        double creditScore = 0;
        boolean hasCriminalRecord = false;
        while (true) {
            try {
                System.out.print("Enter your monthly salary : ");
                monthlySalary = scanner.nextDouble();
                if (monthlySalary > 0) {
                    break;
                } else {
                    System.out.println("Salary must be a positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a numeric value.");
                scanner.next();
            }
        }
        while (true) {
            try {
                System.out.print("Enter your credit score (0-500) : ");
                creditScore = scanner.nextDouble();
                if (creditScore >= 0 && creditScore <= 500) {
                    break;
                } else {
                    System.out.println("Please enter a score between 0 and 500.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a numeric value.");
                scanner.next();
            }
        }
        while (true) {
            try {
                System.out.print("Do you have any criminal record (true/false)? : ");
                hasCriminalRecord = scanner.nextBoolean();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter true or false.");
                scanner.next();
            }
        }
        System.out.println("\n--- Eligibility Check ---");
        if (hasCriminalRecord) {
            System.out.println("You are not eligible.");
        } else if (creditScore < 200) {
            System.out.println("Not eligible. Credit score is too low.");
        } else {
            System.out.println("\n--- Eligibility Cleared ---");
            System.out.println("You are eligible to apply. Please enter loan details.");
            System.out.println("Note: Loan amount cannot exceed $" + (monthlySalary * 2));
            double loanAmount = 0;
            double annualPercentageRate = 0;
            int loanTermMonths = 0;
            while (true) {
                try {
                    System.out.print("Loan Amount: ");
                    loanAmount = scanner.nextDouble();
                    if (loanAmount <= 0) {
                        System.out.println("Loan amount must be positive.");
                        continue;
                    }
                    if (loanAmount > (monthlySalary * 2)) {
                        System.out.println("Not eligible. Loan amount is higher than double your monthly salary.");
                        scanner.close();
                        return;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a numeric value.");
                    scanner.next();
                }
            }
            while (true) {
                try {
                    System.out.print("Percentage (e.g., 5 for 5%): ");
                    annualPercentageRate = scanner.nextDouble();
                    if (annualPercentageRate > 0) {
                        break;
                    } else {
                        System.out.println("Rate must be a positive number.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a numeric value.");
                    scanner.next();
                }
            }
            while (true) {
                try {
                    System.out.print("For how many months: ");
                    loanTermMonths = scanner.nextInt();
                    if (loanTermMonths > 0) {
                        break;
                    } else {
                        System.out.println("Months must be a positive number.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a numeric value (a whole number).");
                    scanner.next();
                }
            }
            double P = loanAmount;
            double r = (annualPercentageRate / 100) / 12.0;
            int n = loanTermMonths;
            double monthlyPayment;
            if (r == 0) {
                monthlyPayment = P / n;
            } else {
                double numerator = r * Math.pow(1 + r, n);
                double denominator = Math.pow(1 + r, n) - 1;
                monthlyPayment = P * (numerator / denominator);
            }
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            System.out.println("\n---------------------------------");
            System.out.println("Your estimated monthly payment is: " + currency.format(monthlyPayment));
            System.out.println("---------------------------------");
        }
        scanner.close();
    }
}
