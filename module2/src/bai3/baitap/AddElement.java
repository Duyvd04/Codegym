package bai3.baitap;

import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số phần tử mảng: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[size];

        System.out.println("Nhập phần tử mảng: ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Nhập phần tử cần thêm: ");
        int x = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập vị trí phần tử được thêm: ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index < 0 || index > size) {
            System.out.println("Không chèn được phần tử vào mảng");
        } else {
            int[] newArr = new int[size + 1];
            for (int i = 0; i < index; i++) {
                newArr[i] = arr[i];
            }
            newArr[index] = x;
            for (int i = index; i < size; i++) {
                newArr[i + 1] = arr[i];
            }

            System.out.println("Mảng sau khi thêm phần tử:");
            for (int i : newArr) {
                System.out.println(i);
            }
        }
    }
}
