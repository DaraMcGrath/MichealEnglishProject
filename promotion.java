//package EMDProject;

public class promotion {
    private int number;
    private String role;
    private String department;
    private double salary;
    public promotion(String role, String department, double salary){
        this.department=department;
        this.role=role;
        this.salary=salary;
    }

    public int getNumber() {
        return number;
    }
    public String getDepartment() {
        return department;
    }
    public String getRole() {
        return role;
    }
    public double getSalary() {
        return salary;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String CreateJob(String department, String role, double salary){
        return department;
    }

    public String CreateJob(Department department, String role, double number,double salary){
        return role;
    }
}
