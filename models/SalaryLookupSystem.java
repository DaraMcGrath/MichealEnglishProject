package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SalaryEntry {
    String department;
    String jobTitle;
    int pointValue;
    int salary;

    public SalaryEntry(String department, String jobTitle, int pointValue, int salary) {
        this.department = department;
        this.jobTitle = jobTitle;
        this.pointValue = pointValue;
        this.salary = salary;
    }
}

public class SalaryLookupSystem {
    private List<SalaryEntry> salaryData;

    public SalaryLookupSystem(String csvFile) {
        salaryData = new ArrayList<>();
        loadCsvData(csvFile);
    }

    private void loadCsvData(String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 4) {
                    salaryData.add(new SalaryEntry(
                            values[0],
                            values[1],
                            Integer.parseInt(values[2]),
                            Integer.parseInt(values[3])
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    public SalaryEntry findSalary(String department, String jobTitle) {
        return salaryData.stream()
                .filter(entry ->
                        entry.department.equalsIgnoreCase(department) &&
                                entry.jobTitle.equalsIgnoreCase(jobTitle)
                )
                .findFirst()
                .orElse(null);
    }

    public static void run() {
        SalaryLookupSystem salarySystem = new SalaryLookupSystem("salary_scales.csv");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter department (or 'quit' to exit): ");
            String department = scanner.nextLine();

            if (department.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.print("Enter job title: ");
            String jobTitle = scanner.nextLine();

            SalaryEntry result = salarySystem.findSalary(department, jobTitle);

            if (result != null) {
                System.out.println("Department: " + result.department);
                System.out.println("Job Title: " + result.jobTitle);
                System.out.println("Point Value: " + result.pointValue);
                System.out.println("Salary: €" + result.salary);
            } else {
                System.out.println("No matching salary found.");
            }
        }

        scanner.close();
    }
}