package Executible_logic_class;

import Business_logic_classes.Appointment;
import Business_logic_classes.Doctor;
import Business_logic_classes.Patient;

import java.util.*;

public class HospitalManagement {

    private static ArrayList<Patient> patients=new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);
        int choice;
        do {
            System.out.println("Hospital management system");
            System.out.println("1.Add patient");
            System.out.println("2.Add doctor");
            System.out.println("3.schedule Appointment");
            System.out.println("4.view Patient");
            System.out.println("5.view Doctor");
            System.out.println("6.view Appointment");
            System.out.println("0.Exits");
            System.out.println("enter your choice");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    addDoctor(scanner);
                    break;
                case 3:
                    scheduleAppointment(scanner);
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    viewDoctors();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 0:
                    System.out.println("existing .....");
                    break;
                default:
                    System.out.println("invalid choice : please try again ");

            }
        }while(choice !=0);

    }
    private static void addPatient(Scanner scanner){
        System.out.println("enter patient name");
        String name=scanner.next();
        System.out.println("patient age");
        int age=scanner.nextInt();
        System.out.println("enter patient gender");
        String gender=scanner.next();
        System.out.println("enter patients address");
        String address=scanner.next();

        Patient patient=new Patient(name, gender, age, address);
        patients.add(patient);
        System.out.println("patient added successfully");

    }
    private static void addDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.next();
        System.out.print("Enter Doctor Specialty: ");
        String specialty = scanner.next();

        Doctor doctor = new Doctor(name, specialty);
        doctors.add(doctor);

        System.out.println("Doctor added successfully!");
    }
    private static void scheduleAppointment(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.next();

        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);

        if (patient != null && doctor != null) {
            Appointment appointment = new Appointment(patient, doctor, date);
            appointments.add(appointment);
            System.out.println("Appointment scheduled successfully!");
        } else {
            System.out.println("Invalid Patient ID or Doctor ID.");
        }
    }
    private static void viewPatients() {
        System.out.println("List of Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private static void viewDoctors() {
        System.out.println("List of Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }
    private static void viewAppointments() {
        System.out.println("List of Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private static Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }
    private static Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

}
