package Base.Model.Maintenance;

import Base.Interfaces.EmployeeType;
import Base.Interfaces.MaintenanceInterface;
import Base.Model.Facility.Location;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class MaintenanceRequest implements MaintenanceInterface {

    // Urgency with set urgency int values from 0 -> 4
    // 0 being least urgent to 3 being extremely urgent
    int urgency;
    String requestingParty;
    // Approximate down - time of maintenance in hours
    int appDownTime;
    Location l1;
    Date d1;
    String mainName;
    MaintenanceSchedule mS;

    protected EmployeeType employeeType;

    //Implementing Observer pattern
    List<MaintenanceRequest> observers = new ArrayList<MaintenanceRequest>();
    String status;



    public abstract String employeeTyping();

    public MaintenanceRequest(int u, String mainName, String rQ, int downTime, Location l, EmployeeType employeeType){
        this.urgency = u;
        this.requestingParty = rQ;
        // Approximate down - time of maintenance in hours
        // the longer the downtime the higher the cost of maintenance will be
        this.appDownTime = downTime;
        this.l1 = l;
        this.mainName = mainName;
        this.employeeType = employeeType;

    }

    public String getState() {
        return status;
    }

    public void setState(String status) {
        this.status = status;
        notifyAllObservers();
    }

    public void attach(MaintenanceRequest observer){
        observers.add(observer);
    }
    public void update(){
        System.out.println("Original state" + this.getState());
    }
    public void notifyAllObservers(){
        for (MaintenanceRequest observer : observers) {
            observer.update();
        }
    }



    @Override
    public void getInfo() {
        System.out.println("Maintenance request name: " + this.getName());
        System.out.print("Maintenance requester: " +this.getRequestingParty());
        System.out.println("Maintenance Location: " + this.getLocation());
        System.out.println("Maintenance urgency: " + this.getUrgency());
    }

    public void setLocation(Location l){
        this.l1 = l;
    }
    public Location getLocation(){
        return l1;
    }
    public Date getDate(){
        return d1;
    }
    public void setDate(Date d){
        this.d1 = d;
    }
    public void setUrgency(int urgency){
        this.urgency = urgency;
    }
    public void setName(String mainName){this.mainName = mainName;}
    public String getName(){return mainName;}

    public MaintenanceSchedule getmS() {
        return mS;
    }
    public void setmS(MaintenanceSchedule mS){
        this.mS = mS;
    }

    public String getRequestingParty(){
        return requestingParty;
    }

    public void setRequestingParty(String requestingParty) {
        this.requestingParty = requestingParty;
    }

    public int getUrgency() {
        return urgency;
    }

    public double calcFacilityMaintenanceCost(double cleaningCost, double gKCost, double HVACCost, double pestControlCost, double plumbingCost){
        return cleaningCost + gKCost + HVACCost + pestControlCost + plumbingCost;
    }

    public double calcProblemRate(int cleaningRate, int gKRate, int HVACRate, int pestControlRate, int plumbingRate){
        return cleaningRate + gKRate + HVACRate + pestControlRate + plumbingRate;
    }
    public int calcDownTime(int cleaningDownTime, int gKDownTime, int HVACDownTime, int pestControlDownTime, int plumbingDownTime){
        return cleaningDownTime + gKDownTime + HVACDownTime + pestControlDownTime + plumbingDownTime;
    }
    public void listFacilityProblems(){
        String name = this.getName();
        Location l = this.getLocation();
        if(name.equalsIgnoreCase("Cleaning")){
            //Location retrieved from main class
            System.out.println("Cleaning required on " + l.toString());
            System.out.println("Requested by: " + this.getRequestingParty());
        }
        if(name.equalsIgnoreCase("PestControl")){
            //Location retrieved from main class
            System.out.println("Pest problem, pest control required" + l.toString());
            System.out.println("Requested by: " + this.getRequestingParty());
        }
        if(name.equalsIgnoreCase("HVAC")){
            //Location retrieved from main class
            System.out.println("Heating and air conditioning problem, HVAC support required" + l.toString());
            System.out.println("Requested by: " + this.getRequestingParty());
        }
        if(name.equalsIgnoreCase("Plumbing")){
            //Location retrieved from main class
            System.out.println("Plumbing problem, plumbing support required" + l.toString());
            System.out.println("Requested by: " + this.getRequestingParty());
        }
        if(name.equalsIgnoreCase("GroundsKeeping")){
            //Location retrieved from main class
            System.out.println("Grounds Keeping required" + l.toString());
            System.out.println("Requested by: " + this.getRequestingParty());
        }
    }

    @Override
    public String toString() {
        return "MaintenanceRequest{" +
                "urgency=" + urgency +
                ", requestingParty='" + requestingParty + '\'' +
                ", appDownTime=" + appDownTime +
                ", l1=" + l1 +
                ", d1=" + d1 +
                ", mainName='" + mainName + '\'' +
                '}';
    }

}
