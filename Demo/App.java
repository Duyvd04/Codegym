import src.Hospital;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("1: Add Patient");
            System.out.println("2: View Patient");
            System.out.println("3: Get Patient");
            System.out.println("0: Exit");
            System.out.print("Enter a number: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Adding Patient...");
                    hospital.addPatient();
                    break;
                case 2:
                    System.out.println("Viewing Patient...");
                    hospital.showListPatients();
                    break;
                case 3:
                    System.out.println("Getting Patient...");
                    hospital.getPatient();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
