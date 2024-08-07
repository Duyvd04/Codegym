package bai3.baitap;

import java.util.Scanner;

public class Concat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Nhập số phần tử mảng 1: ");
        int size1 = Integer.parseInt(scanner.nextLine());
        int[] arr1 = new int[size1];

        System.out.println("Nhập số phần tử mảng 2: ");
        int size2 = Integer.parseInt(scanner.nextLine());
        int[] arr2 = new int[size2];


        System.out.println("Nhập phần tử mảng 1: ");
        for (int i = 0; i < size1; i++) {
            arr1[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Nhập phần tử mảng 2: ");
        for (int j = 0; j < size2; j++) {
            arr2[j] = Integer.parseInt(scanner.nextLine());
        }


        int[] arr3 = new int[size1 + size2];


        for (int i = 0; i < size1; i++) {
            arr3[i] = arr1[i];
        }


        for (int j = 0; j < size2; j++) {
            arr3[size1 + j] = arr2[j];
        }


        System.out.println("Mảng sau khi nối: ");
        for (int s : arr3) {
            System.out.println(s);
        }
    }
}
