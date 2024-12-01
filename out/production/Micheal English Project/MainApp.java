

import models.Employee;
import models.FullTimeEmployee;
import models.Payroll;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the UL models.Payroll System!");
        System.out.println("1. Add Employee");
        System.out.println("2. View models.Payslip");
        System.out.println("3. Promote Employee");
        System.out.println("4. Exit");

        boolean running = true;

        while (running) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add employee logic
                    Employee toAdd = employeeData();
                    CSVUtil writer = new CSVUtil();
                    try {
                        writer.writeCSV("src/Employees.csv",toAdd.toCSVString());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 2:
                    // View payslip logic
                    Payroll payroll = new Payroll();
                    CSVUtil reader = new CSVUtil();
                    ArrayList<String> csvdata = null;
                    try {
                        csvdata = reader.readCSV("src/Employees.csv");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ArrayList<Employee> employees = new ArrayList<>();
                    for(String s : csvdata){
                        Employee employeetoAdd = new FullTimeEmployee(s);
                        employees.add(employeetoAdd);
                    }
                    System.out.println("Please enter a name for this cycles payslip");
                    Scanner in = new Scanner(System.in);
                    String fileName = in.next();
                    payroll.generatePayslips(employees,"src/" + fileName);
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

    public static Employee employeeData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the employee ID: ");
        String name = scanner.nextLine();
        System.out.println("Enter the employee name: ");
        String surname = scanner.nextLine();
        System.out.println("Enter the employees Role :");
        String role = scanner.nextLine();
        System.out.println("Enter the employee salary: ");
        double salary = scanner.nextDouble();-

        return new FullTimeEmployee(surname,name,role,salary);
    }
}

