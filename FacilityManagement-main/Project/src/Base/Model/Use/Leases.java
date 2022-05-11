package Base.Model.Use;

import java.util.HashMap;

public class Leases {
    private int leaseGroupID;
    HashMap<Integer, LeaseGroup> leaseList;

    public Leases(int leaseGroupID, HashMap<Integer, LeaseGroup> leaseList){
        this.leaseGroupID = leaseGroupID;
        this.leaseList = leaseList;
    }

    public Leases() {}

    public void addLease(int leaseGroupID, LeaseGroup group){
        leaseList.put(leaseGroupID, group);
    }

    public void removeLease(int leaseGroupID, LeaseGroup group){
        leaseList.remove(leaseGroupID, group);
    }
}
