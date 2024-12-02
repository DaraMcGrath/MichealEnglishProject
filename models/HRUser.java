package models;

public class HRUser {
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