import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import models.Employee;
import models.FullTimeEmployee;
import models.Payroll;

public class MainApp {
    public MainApp() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the UL models.Payroll System!");
        System.out.println("1. Add Employee");
        System.out.println("2. View models.Payslip");
        System.out.println("3. Promote Employee");
        System.out.println("4. Exit");
        boolean running = true;

        while (true) {
            while (running) {
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Employee toAdd = employeeData();
                        CSVUtil writer = new CSVUtil();

                        try {
                            CSVUtil.writeCSV("src/Employees.csv", toAdd.toCSVString());
                            break;
                        } catch (IOException var14) {
                            throw new RuntimeException(var14);
                        }
                    case 2:
                        Payroll payroll = new Payroll();
                        CSVUtil reader = new CSVUtil();
                        ArrayList<String> csvdata = null;

                        try {
                            csvdata = CSVUtil.readCSV("src/Employees.csv");
                        } catch (IOException var13) {
                            throw new RuntimeException(var13);
                        }

                        ArrayList<Employee> employees = new ArrayList();
                        Iterator var10 = csvdata.iterator();

                        String fileName;
                        while (var10.hasNext()) {
                            fileName = (String) var10.next();
                            Employee employeetoAdd = new FullTimeEmployee(fileName);
                            employees.add(employeetoAdd);
                        }

                        System.out.println("Please enter a name for this cycles payslip");
                        Scanner in = new Scanner(System.in);
                        fileName = in.next();
                        payroll.generatePayslips(employees, "src/" + fileName);
                        break;
                    case 3:
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
            return;
        }
    }

    public static Employee employeeData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the employee ID: ");
        String name = scanner.nextLine();
        System.out.println("Enter the employee name: ");
        String surname = scanner.nextLine();
        System.out.println("Enter the employees Role :");
        String role = scanner.nextLine();
        System.out.println("Enter the employee salary: ");
        double salary = scanner.nextDouble();
        return new FullTimeEmployee(surname, name, role, salary);
    }
}
