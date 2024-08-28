package src;

import java.util.*;

public class Hospital {
    private Queue<Patient> patientList;
    private Scanner scanner;

    public Hospital() {
        this.patientList = new ArrayDeque<>();
        this.scanner = new Scanner(System.in);
    }

    public void addPatient() {
        System.out.println("Enter code: ");
        String code = this.scanner.nextLine();
        System.out.println("Enter name: ");
        String name = this.scanner.nextLine();
        Patient patient = new Patient(code, name);
        this.patientList.add(patient);
        System.out.println("Add patient successfully!.................");
    }

    public void showListPatients() {
        System.out.println("------------List of patients:-----------");
        for (Patient patient : this.patientList) {
            System.out.println("Code: " + patient.getCode() + ", Name: " + patient.getName());
        }
    }

    public void getPatient() {
        if (this.patientList.isEmpty()) {
            System.out.println("No patient available!");
        } else {
            System.out.println("Patient: " + this.patientList.poll().getName());
        }
    }

}
