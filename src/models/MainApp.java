package src.models;

import models.Employee;
import models.FullTimeEmployee;
import models.PartTimeEmployee;
import models.Payroll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the UL Payroll System!");
        System.out.println("1. Add Employee");
        System.out.println("2. View Payslip");
        System.out.println("3. Promote Employee");
        System.out.println("4. Exit");

        boolean running = true;

        while (running) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:
                    // Add employee logic
                    Employee toAdd = employeeData();
                    CSVUtil writer = new CSVUtil();
                    try {
                        writer.writeCSV("src/Employees.csv", toAdd.toCSVString());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 2:
                    // View payslip logic
                    Payroll payroll = new Payroll();
                    CSVUtil reader = new CSVUtil();
                    ArrayList<String> csvData = null;
                    try {
                        csvData = reader.readCSV("src/Employees.csv");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ArrayList<Employee> employees = new ArrayList<>();
                    for (String s : csvData) {
                        Employee employeeToAdd;
                        if (s.contains("PartTime")) { // Distinguish employee types in CSV
                            employeeToAdd = new PartTimeEmployee(s);
                        } else {
                            employeeToAdd = new FullTimeEmployee(s);
                        }
                        employees.add(employeeToAdd);
                    }
                    System.out.println("Please enter a name for this cycle's payslip:");
                    String fileName = scanner.next();
                    payroll.generatePayslips(employees, "src/" + fileName);
                    break;

                case 3:
                    // Promotion logic
                    System.out.println("Feature not implemented yet!");
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    public static Employee employeeData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the employee type (1 = Full-Time, 2 = Part-Time): ");
        int employeeType = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character

        System.out.println("Enter the employee ID: ");
        String id = scanner.nextLine();

        System.out.println("Enter the employee name: ");
        String name = scanner.nextLine();

        if (employeeType == 1) {
            // Full-Time Employee
            System.out.println("Enter the employee's Role: ");
            String role = scanner.nextLine();
            System.out.println("Enter the employee salary: ");
            double salary = scanner.nextDouble();
            return new FullTimeEmployee(id, name, role, salary);

        } else if (employeeType == 2) {
            // Part-Time Employee
            System.out.println("Enter the employee's hourly rate: ");
            double hourlyRate = scanner.nextDouble();
            return new PartTimeEmployee(id);

        } else {
            System.out.println("Invalid employee type. Returning null.");
            return null;
        }
    }
}
