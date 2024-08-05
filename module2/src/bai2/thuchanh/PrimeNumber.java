package bai2.thuchanh;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        if (number < 2){
            System.out.println(number + " is not a prime number");
        }else{
            int i = 2;
            boolean check = true;
            while(i<= Math.sqrt(number)){
                if (number % i ==0){
                    check = false;
                    break;
                }
                i++;
            }
            if(check){
                System.out.println(number + " is a prime number");
            }else{
                System.out.println(number + " is not a prime number");
            }
        }
    }
}
