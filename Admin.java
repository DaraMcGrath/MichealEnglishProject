import java.util.*;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password, "ADMIN");
    }

    public void addEmployee(List<Employee> employees, Employee newEmployee) {
        employees.add(newEmployee);
        System.out.println("Employee added successfully: " + newEmployee.getUsername());
    }
}
