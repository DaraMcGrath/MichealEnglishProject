package models;

import models.Employee;
import models.FullTimeEmployee;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        Payroll payroll = new Payroll();

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Generate Payslips");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            // change to match java version
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Employee ID, Name, and Gross Salary:");
                    String id = scanner.next();
                    String name = scanner.next();
                    double grossSalary = scanner.nextDouble();
                    employees.add(new FullTimeEmployee(id, name, grossSalary, 100, 50));
                }
                case 2 -> {
                    System.out.println("Generating payslips...");
                    payroll.generatePayslips(employees, "payslips.csv");
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
