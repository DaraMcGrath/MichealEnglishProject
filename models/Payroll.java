package models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Payroll {
    public void generatePayslips(List<Employee> employees, String outputFile) {
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (Employee emp : employees) {
                double netSalary = emp.calculateNetSalary();
                Payslip payslip = new Payslip(emp.getId(), java.time.LocalDate.now(), emp.getGrossSalary(), netSalary);
                writer.write(payslip.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing payslips: " + e.getMessage());
        }
    }
}
