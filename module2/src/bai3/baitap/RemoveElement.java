package bai3.baitap;

import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số phần tử mảng: ");
        int size1 = Integer.parseInt(scanner.nextLine());
        int[] arr1 = new int[size1];

        System.out.println("Nhập phần tử mảng: ");
        for (int i = 0; i < size1; i++) {
            arr1[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Nhập phần tử cần xoá: ");
        int x = Integer.parseInt(scanner.nextLine());

        int index_del = -1;
        for (int i = 0; i < size1; i++) {
            if (arr1[i] == x) {
                index_del = i;
                break;
            }
        }

        if (index_del != -1) {
            for (int i = index_del; i < size1 - 1; i++) {
                arr1[i] = arr1[i + 1];
            }
            size1--;
        } else {
            System.out.println("Phần tử không tồn tại trong mảng");
        }

        System.out.println("Mảng sau khi xoá: ");
        for (int i = 0; i < size1; i++) {
            System.out.println(arr1[i]);
        }
    }
}
