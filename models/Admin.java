package models;

import java.util.List;

public class Admin {
    private String username;
    private String password;

    /** Generates admin **/
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
