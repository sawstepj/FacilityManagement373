package Base.Model.Use;

public class Tenant extends User{
    private int numOfDependents;
    private int monthlyCharge;
    private int monthlyUtilityCost;
    private int monthlyMaintenanceCost;
    private User user;
    private Employee employee;

    public int calculateUserCost(int numOfDependents, int monthlyCharge, int monthlyMaintenanceCost, int monthlyUtilityCost){
        return (monthlyCharge + monthlyUtilityCost + monthlyMaintenanceCost) / numOfDependents;
    }

    public int getNumOfDependents(){
        return numOfDependents;
    }

    public void setNumDependents(int numOfDependents){
        this.numOfDependents = numOfDependents;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
