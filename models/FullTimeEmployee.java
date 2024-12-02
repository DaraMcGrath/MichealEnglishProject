package models;

public class FullTimeEmployee extends Employee {
    private double healthInsurance;
    private double unionFee;

    public FullTimeEmployee(String id, String name,  String position, boolean isFullTime) {
        // PLACEHOLDER
        super(id, name, "Professor", 101447 );
        this.healthInsurance = 123456789;
        this.unionFee = 1234567;
    }

    public FullTimeEmployee(String surname, String name, String role, double salary) {
        super(surname,name,role,salary);
    }
    public FullTimeEmployee(String data){
        super(data);

    }

    public double getHealthInsurance() {
        return healthInsurance;
    }

    public double getUnionFee() {
        return unionFee;
    }

    public void setHealthInsurance(double healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public void setUnionFee(double unionFee) {
        this.unionFee = unionFee;
    }


    @Override
    public double calculateNetSalary() {
        return 0;
    }

}