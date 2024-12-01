package models;

public abstract class Employee {
    private String id;
    private String name;
    private String role; // Full-time, Part-time
    private double grossSalary;
    private SalaryLookupSystem lookupSystem;

    public Employee(String id, String name, String role, double grossSalary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.grossSalary = grossSalary;
        this.lookupSystem = new SalaryLookupSystem("src/salary-scales.csv");
    }

    public Employee(String data){
        String[] dataArray = data.split(",");
        this.name = dataArray[0];
        this.id = dataArray[1];
        this.role = dataArray[2];
        this.grossSalary = Double.parseDouble(dataArray[3]);
    }

    public abstract double calculateNetSalary();

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public double getGrossSalary() { return grossSalary; }
    public String toCSVString() {
        return String.format("%s,%s,%s,%.2f",getId(),getName(),getRole(),getGrossSalary());
    }

    public String getUsername() {
        return getName();
    }

}
