package models;

import java.time.LocalDate;

public class Payslip {
    private String employeeId;
    private LocalDate date;
    private double grossSalary;
    private double netSalary;

    public Payslip(String employeeId, LocalDate date, double grossSalary, double netSalary) {
        this.employeeId = employeeId;
        this.date = date;
        this.grossSalary = grossSalary;
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return employeeId + "," + date + "," + grossSalary + "," + netSalary;
    }
}

