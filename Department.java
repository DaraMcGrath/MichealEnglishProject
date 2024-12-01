import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Department {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Myron Butler\\Downloads\\Micheal English Project\\Micheal English Project\\src\\salary-scales-csv.txt";
        ArrayList<String> linesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                linesList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] linesArray = linesList.toArray(new String[0]);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your role :");
        String EmpRole = scanner.nextLine();

        System.out.println("Enter your salary :");
        String EmpSalary = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < linesArray.length; i++) {
            String row = linesArray[i];
            String[] columns = row.split(",");

            if (columns.length >= 4 && columns[1].equals(EmpRole) && columns[3].equals(EmpSalary)) {
                System.out.println("Current Salary" + row);
                found = true;

                if (i + 1 < linesArray.length) {
                    String nextRow = linesArray[i + 1];
                    String[] nextColumns = nextRow.split(",");

                    if (nextColumns.length >= 4) {
                        if (nextColumns[2].equals("1")) {
                            System.out.println("Salary scale cap reached");
                        } else {
                            System.out.println("Promoted Salary}: " + nextRow);
                        }
                    }
                }
                break;
            }
        }

        if (!found) {
            System.out.println("No matching rows found for the given criteria.");
        }
        scanner.close();
    }
}
