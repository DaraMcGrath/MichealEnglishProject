package models;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    private boolean payClaimSubmitted;

    // Constructor with explicit parameters
    public PartTimeEmployee(String id, String name, double hourlyRate, int hoursWorked, boolean payClaimSubmitted) {
        super(id, name, "Part-time", 0); // Role is "Part-time", gross salary is 0 for now
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.payClaimSubmitted = payClaimSubmitted;
    }

    // Constructor to initialize from a CSV line
    public PartTimeEmployee(String csvLine) {
        super(csvLine); // Initializes id, name, role, and grossSalary from CSV
        String[] data = csvLine.split(",");
        this.hourlyRate = Double.parseDouble(data[4]);
        this.hoursWorked = Integer.parseInt(data[5]);
        this.payClaimSubmitted = Boolean.parseBoolean(data[6]);
    }

    @Override
    public double calculateNetSalary() {
        return hourlyRate * hoursWorked; // Example calculation for Part-time employees
    }

    @Override
    public String toCSVString() {
        return String.format("%s,%.2f,%d,%b", super.toCSVString(), hourlyRate, hoursWorked, payClaimSubmitted);
    }

    @Override
    public String toString() {
        return String.format("PartTimeEmployee{%s, hourlyRate=%.2f, hoursWorked=%d, payClaimSubmitted=%b}",
                super.toString(), hourlyRate, hoursWorked, payClaimSubmitted);
    }
}

