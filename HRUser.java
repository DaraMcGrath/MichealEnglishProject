public class HRUser extends User {

    public HRUser(String username, String password) {
        super(username, password, "HR");
    }

    public void promoteEmployee(Employee employee) {
        if (employee.isFullTime()) {
            System.out.println("Promoting " + employee.getUsername() + "...");
            System.out.println("Promotion successful for " + employee.getUsername() + "!");
        } else {
            System.out.println("Cannot promote part-time employees.");
        }
    }
}
