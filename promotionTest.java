//package EMDProject;
import java.util.Scanner;
public class promotionTest{
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the employee ID: ");
            String name = scanner.nextLine();
            System.out.println("Enter the employee name: ");
            String surname = scanner.nextLine();
            System.out.println("Enter the employees Role :");
            String role = scanner.nextLine();
            System.out.println("Enter the employees Department :");
            String department = scanner.nextLine();
            System.out.println("Enter the employee salary: ");
            double salary = scanner.nextDouble();
        System.out.println(name + surname + role + salary);

        if(role == "President" || role == "Vice President"){
            System.out.println("There is no promotion for a greater Salary Scale available");
        } else {

        }
    }
}
