package bai2.baitap;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {

        int numbers = 20;

        int count = 0; // Đếm số lượng số nguyên tố đã hiển thị
        int N = 2; // Giá trị ban đầu để kiểm tra

        while (count < numbers) {
            if (isPrime(N)) {
                System.out.print(N + " ");
                count++;
            }
            N++;
        }


    }

    // Phương thức kiểm tra xem một số có phải là số nguyên tố hay không
    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
