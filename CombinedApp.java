import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import models.*;


public class CombinedApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mock data
        List<Employee> employees = new ArrayList<>();
        Admin admin = new Admin("admin", "admin123");
        HRUser hrUser = new HRUser("hr", "hr123");
        Employee fulltimeEmployee = new FullTimeEmployee("1", "Myron", "Professor", true);

        Payroll payroll = new Payroll();

        System.out.println("Welcome to the Employee Management System!");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Role-based access
        if (admin.authenticate(username, password)) {
            System.out.println("Logged in as Admin");
            System.out.println("1. Add Employee");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println("Enter the employee type (1 = Full-Time, 2 = Part-Time): ");
                int employeeType = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character
                Employee newEmployee = null;

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
                    newEmployee =  new FullTimeEmployee(id, name, role, salary);
                    System.out.println("You have successfully added an employee ");

                } else if (employeeType == 2) {
                    // Part-Time Employee
                    System.out.println("Enter the employee's hourly rate: ");
                    double hourlyRate = scanner.nextDouble();
                    newEmployee = new PartTimeEmployee(id);
                    System.out.println("You have successfully added an employee ");

                } else {
                    System.out.println("Invalid employee type. Returning null.");
                }

                admin.addEmployee(employees, newEmployee);
                CSVUtil writer = new CSVUtil();
                try {
                    writer.writeCSV("Employees.csv", newEmployee.toCSVString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        } else if (hrUser.authenticate(username, password)) {
            System.out.println("Logged in as HR User");
            System.out.println("1. Promote Employee");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println("Employees:");
                for (int i = 0; i < employees.size(); i++) {
                    System.out.println((i + 1) + ". " + employees.get(i).getUsername());
                }
                System.out.print("Choose an employee to promote: ");
                int empIndex = scanner.nextInt() - 1;
                if (empIndex >= 0 && empIndex < employees.size()) {
                    hrUser.promoteEmployee(employees.get(empIndex));
                } else {
                    System.out.println("Invalid selection.");
                }

            }
        } else {
            // Employee login
            Optional<Employee> loggedInEmployee = employees.stream()
                    .filter(emp -> emp.authenticate(username, password))
                    .findFirst();

            if (loggedInEmployee.isPresent()) {
                System.out.println("Logged in as Employee");
                System.out.println(loggedInEmployee.get().getDetails());
            } else {
                System.out.println("Invalid credentials.");
            }
        }
        scanner.close();
    }
}