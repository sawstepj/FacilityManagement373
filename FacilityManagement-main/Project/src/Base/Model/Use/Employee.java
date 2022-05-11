package Base.Model.Use;

public class Employee extends User {
    private int employeeId;
    private String employeeName;
    private double weeklySalary;
    private double netSalary;

    public Employee(int employeeId, String employeeName, double salary){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.weeklySalary = salary;
    }

    public Employee() {}

    public double calculateWeeklyPay(int weeklySalary, int overtimeHours){
        return weeklySalary + ((weeklySalary/6.0/8.0) * 1.5 * overtimeHours);
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
