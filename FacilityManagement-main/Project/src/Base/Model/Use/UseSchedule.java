package Base.Model.Use;

import Base.Model.Facility.Date;
import Base.Model.Facility.ExtraFacilities;
import Base.Model.Facility.Location;
import Base.Model.Facility.Units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UseSchedule {
    private Units units;
    private ExtraFacilities extraFacility;
    private boolean availability;
    String unitType;
    private int useInterval;
    Location l1;
    private boolean requiresInspection;
    private int numberOfUsers;
    int capacity;
    private Date date;
    String typeName;
    public List<Inspection> inspectionList;
    HashMap<Date, String> iSchedule;

    public UseSchedule(String fType, String uType, Location l, boolean available, int numUsers){
        inspectionList = new ArrayList<>();
        iSchedule = new HashMap<>();
        this.unitType = fType;
        this.typeName = uType;
        this.l1 = l;
        this.availability = available;
        this.numberOfUsers = numUsers;
        this.capacity = capacity;
    }

    public UseSchedule() {}

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getName(){
        return typeName;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getUnitType() {
        return unitType;
    }

    public int getUseInterval(){
        return useInterval;
    }

    public void setUseInterval(int useInterval) {
        this.useInterval = useInterval;
    }

    public void setUsers(int u){
        this.numberOfUsers = u;
    }
    public int getUsers(){
        return numberOfUsers;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isInUseDuringInterval(int useInterval){
        if(useInterval < 2){
            return false;
        }
        return useInterval > 2;
    }

    public void listInspections(){
        System.out.println(Arrays.toString(inspectionList.toArray()));
    }
    public void listActualUsage(){
        System.out.println("Use Type: " + this.getName());
        System.out.println("Number of Users: " + this.getUsers());
        System.out.println("Usage interval: " + this.getUseInterval());

    }
    public void assignFacilityToUse(Units f){
        // This facility is no longer in use
        f.setAvailable(false);

    }
    public void vacateFacility(Units u){
        // Set availability to true - facility is now available
        u.setAvailable(true);
    }
    public double calcUsageRate(){
        if(capacity / numberOfUsers == 2){
            //Being used half of the time
            return 50.0;
        }
        if(numberOfUsers == capacity){
            //being used 100% of the time
            return 100.0;
        }
        if(numberOfUsers == 0){
            return 0.0;
        }
        return 25.0;
    }

    @Override
    public String toString() {
        return "UseSchedule{" +
                "unit=" + units +
                ", extraFacility=" + extraFacility +
                ", availability=" + availability +
                ", unitType='" + unitType + '\'' +
                ", useInterval=" + useInterval +
                ", l1=" + l1 +
                ", requiresInspection=" + requiresInspection +
                ", numberOfUsers=" + numberOfUsers +
                ", capacity=" + capacity +
                ", typeName='" + typeName + '\'' +
                ", inspectionList=" + inspectionList +
                ", iSchedule=" + iSchedule +
                '}';
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public void setExtraFacilities(ExtraFacilities extraFacilities) {
        this.extraFacility = extraFacilities;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
