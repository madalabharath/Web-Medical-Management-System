package Intermediate_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Patient class
class Patient {
    String name;
    int id;
    String appointmentDate;
    String appointmentTime;

    public Patient(String name, int id, String appointmentDate, String appointmentTime) {
        this.name = name;
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public String toString() {
        return "Name: " + name + "\nID: " + id + "\nAppointment Date: " + appointmentDate + "\nAppointment Time: " + appointmentTime;
    }
}

// Doctor class
class Doctor {
    String name;
    int id;
    String specialization;

    public Doctor(String name, int id, String specialization) {
        this.name = name;
        this.id = id;
        this.specialization = specialization;
    }

    public String toString() {
        return "Name: " + name + "\nID: " + id + "\nSpecialization: " + specialization;
    }
}

// Admin class
class Admin {
    String name;
    int id;

    public Admin(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "Name: " + name + "\nID: " + id;
    }
}

// Virtual Medicine Home class
public class VirtualMedicineHome {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Admin> admins;
    private Scanner scanner;

    public VirtualMedicineHome() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Virtual Medicine Home");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. View Patient Records");
            System.out.println("3. View Doctor Records");
            System.out.println("4. View Admin Records");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    scheduleAppointment();
                    break;
                case 2:
                    viewPatientRecords();
                    break;
                case 3:
                    viewDoctorRecords();
                    break;
                case 4:
                    viewAdminRecords();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private void scheduleAppointment() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter appointment date: ");
        String appointmentDate = scanner.nextLine();
        System.out.print("Enter appointment time: ");
        String appointmentTime = scanner.nextLine();

        Patient patient = new Patient(name, id, appointmentDate, appointmentTime);
        patients.add(patient);
        System.out.println("Appointment scheduled successfully!");
    }

    private void viewPatientRecords() {
        for (Patient patient : patients) {
            System.out.println(patient.toString());
        }
    }

    private void viewDoctorRecords() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor.toString());
        }
    }

    private void viewAdminRecords() {
        for (Admin admin : admins) {
            System.out.println(admin.toString());
        }
    }

    public static void main(String[] args) {
        VirtualMedicineHome virtualMedicineHome = new VirtualMedicineHome();
        virtualMedicineHome.run();
    }
}