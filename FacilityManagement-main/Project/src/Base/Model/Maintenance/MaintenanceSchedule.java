package Base.Model.Maintenance;

import Base.Interfaces.EmployeeType;
import Base.Model.Facility.Location;

import java.util.*;

public class MaintenanceSchedule {

    public List <MaintenanceRequest> requestsList;
    HashMap<Date,String>mSchedule;


    public MaintenanceSchedule(){
        requestsList = new ArrayList<MaintenanceRequest>();
        mSchedule = new HashMap<Date,String>();
    }
    public List<MaintenanceRequest> getRequestsList(){
        return requestsList;
    }
    public HashMap<Date,String> getHashmap(){
        return mSchedule;
    }


    public void makeFacilityRequest(int urgency, String name, String requestingParty, int downTime, Location l, EmployeeType employeeType){
        MaintenanceRequest mR = new MaintenanceRequest(urgency, name, requestingParty, downTime, l, employeeType) {
            @Override
            public String employeeTyping() {
                return employeeType.type();
            }
        };
        mR.setLocation(l);
        mR.setRequestingParty(requestingParty);
        mR.setName(name);
        mR.setUrgency(urgency);
        requestsList.add(mR);
    }

    public void scheduleMaintenance(MaintenanceRequest mR){
        Date d = mR.getDate();
        String getRName = mR.getName();
        mSchedule.put(d,getRName);


    }

    public void listMaintenance(MaintenanceRequest r){
        System.out.println("Maintenance request name: " + r.getName());
        System.out.print("Maintenance requester: " +r.getRequestingParty());
        System.out.println("Maintenance Location: " + r.getLocation());
        System.out.println("Maintenance urgency: " + r.getUrgency());
    }

    public void listMaintenanceRequests(){

        System.out.println(Arrays.toString(requestsList.toArray()));
    }

    public void addMaintenance(MaintenanceRequest mR){
        requestsList.add(mR);
    }

}
