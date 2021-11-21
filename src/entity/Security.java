package entity;

public class Security {
    private String securityID;
    private String fullName;
    private double baseSalary;
    private double salary;
    private int leaves;
    private int remainLeaves;
    public Security(String managerID, String fullName, double base) {
        this.securityID = managerID;
        this.fullName = fullName;
        this.baseSalary = base;
        this.leaves = 0;
        this.remainLeaves = 3;
    }

    public String getSecurityID() {
        return securityID;
    }
}
