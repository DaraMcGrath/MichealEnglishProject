package models;

public abstract class Employee {
    private final SalaryLookupSystem SalaryLookupSystem;
    private String id;
    private String name;
    private String password;
    private String role;
    private boolean isFullTime;
    private double grossSalary;
    //private SalaryLookupSystem salaryLookupSystem;

    public Employee(String id, String name, String role, double grossSalary) {
        this.id = id;
        this.name = name;
        this.password = "password";
        this.role = role;
        this.isFullTime = true;
        this.grossSalary = grossSalary;
        this.SalaryLookupSystem = new SalaryLookupSystem("src/salary-scales.csv");
    }

    public Employee(String id, String name, String password, String role, double grossSalary,  boolean isFullTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.grossSalary = grossSalary;
        this.isFullTime = isFullTime;
        this.SalaryLookupSystem = new SalaryLookupSystem("src/salary-scales.csv");
    }

    public Employee(String data){
        String[] dataArray = data.split(",");
        this.name = dataArray[0];
        this.id = dataArray[1];
        this.password = "password";
        this.role = dataArray[2];
        this.isFullTime = true;
        this.grossSalary = Double.parseDouble(dataArray[3]);
        this.SalaryLookupSystem = new SalaryLookupSystem("src/salary-scales.csv");
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public String getDetails() {
        return "Name: " + name + ", Position: " + role + ", Full Time: " + (isFullTime ? "Yes" : "No");
    }

    public boolean authenticate(String username, String password2) {
        return this.name.equals(username) && this.password.equals(password2);
    }

}