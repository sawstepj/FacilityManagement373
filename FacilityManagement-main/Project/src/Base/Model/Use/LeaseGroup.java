package Base.Model.Use;

public class LeaseGroup {
    private int numberOfTenants;
    private int leaseDuration;
    private Leases leases;


    public LeaseGroup(int numberOfTenants, int leaseDuration){
        this.numberOfTenants = numberOfTenants;
        this.leaseDuration = leaseDuration;
    }

    public LeaseGroup() {}

    public void setLeaseDuration(int leaseDuration) {
        this.leaseDuration = leaseDuration;
    }

    public int getLeaseDuration() {
        return leaseDuration;
    }

    public void setNumberOfTenants(int numberOfTenants) {
        this.numberOfTenants = numberOfTenants;
    }

    public int getNumberOfTenants() {
        return numberOfTenants;
    }

    public void setLeases(Leases leases) {
        this.leases = leases;
    }
}
