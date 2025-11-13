package Lab;
import java.util.Scanner;
public class Mortgagecalculator {

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.print("Enter loan amount:");
        double P=input.nextDouble();
        System.out.print("Enter annual interest rate(in %):");
        double annualrate = input.nextDouble();
        System.out.print("Enter loan term (in years):");
        int years = input.nextInt();
        double r =annualrate/12/100;
        int n = years*12;
        double M =P*(r*Math.pow(1+r,n))/ (Math.pow(1+r,n)-1);
        System.err.printf("MonthlybPaymentv:$%.2f%n",M);

}
}