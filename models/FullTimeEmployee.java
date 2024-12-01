package models;

public class FullTimeEmployee extends Employee {
    private double healthInsurance;
    private double unionFee;

    public FullTimeEmployee(String id, String name, double grossSalary, double healthInsurance, double unionFee) {
        super(id, name, "Full-Time", grossSalary);
        this.healthInsurance = healthInsurance;
        this.unionFee = unionFee;
    }

    public FullTimeEmployee(String surname, String name, String role, double salary) {
        super(surname,name,role,salary);
    }
    public FullTimeEmployee(String data){
        super(data);

    }


    @Override
    public double calculateNetSalary() {
        return 0;
    }

}
