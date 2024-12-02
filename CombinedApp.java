import java.time.LocalDate;
import java.util.*;

// Base Employee Class
class Employee {
    private String username;
    private String password;
    private String name;
    private String position;
    private boolean isFullTime;

    public Employee(String username, String password, String name, String position, boolean isFullTime) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.position = position;
        this.isFullTime = isFullTime;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getDetails() {
        return "Name: " + name + ", Position: " + position + ", Full Time: " + (isFullTime ? "Yes" : "No");
    }
}

// Admin Class
class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void addEmployee(List<Employee> employees, Employee newEmployee) {
        employees.add(newEmployee);
        System.out.println("Employee added successfully: " + newEmployee.getUsername());
    }
}

// HR User Class
class HRUser {
    private String username;
    private String password;

    public HRUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void promoteEmployee(Employee employee) {
        if (employee.isFullTime()) {
            System.out.println("Promoting " + employee.getName() + "...");
            System.out.println("Promotion successful!");
        } else {
            System.out.println("Cannot promote part-time employees.");
        }
    }
}

// Payroll Class
class Payroll {
    public void generatePayslips(List<Employee> employees, String fileName) {
        System.out.println("Generating payslips and saving to file: " + fileName);
        for (Employee employee : employees) {
            System.out.println("Payslip for " + employee.getName() + ": " + employee.getDetails());
        }
    }
}





public class CombinedApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mock data
        List<Employee> employees = new ArrayList<>();
        Admin admin = new Admin("admin", "admin123");
        HRUser hrUser = new HRUser("hr", "hr123");
        employees.add(new Employee("john", "pass123", "John Doe", "Developer", true));
        employees.add(new Employee("jane", "pass456", "Jane Smith", "Designer", false));

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
                System.out.print("Enter new employee username: ");
                String empUsername = scanner.nextLine();
                System.out.print("Enter password: ");
                String empPassword = scanner.nextLine();
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter position: ");
                String position = scanner.nextLine();
                System.out.print("Is full-time? (true/false): ");
                boolean isFullTime = scanner.nextBoolean();

                Employee newEmployee = new Employee(empUsername, empPassword, name, position, isFullTime);
                admin.addEmployee(employees, newEmployee);
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
    }
}