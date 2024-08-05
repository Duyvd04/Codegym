package bai2.thuchanh;

import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        double money;
        double interestRate;
        float month;
        double totalInterest = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of money: ");
        money = scanner.nextDouble();
        System.out.println("Enter the interest rate: ");
        interestRate = scanner.nextDouble();
        System.out.println("Enter the month: ");
        month = scanner.nextFloat();

        for(int i = 0; i < month; i++){
            totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}
