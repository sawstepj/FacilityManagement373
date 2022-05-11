package Base.Model.Maintenance;

import Base.Interfaces.EmployeeType;
import Base.Model.Facility.Location;

import java.util.Date;

public class Plumbing extends MaintenanceRequest {
    int urgency;
    String requestingParty;
    Date d1;
    Location loc;
    String mainName;


    @Override
    public String employeeTyping() {
        return "Plumbing performed by: " + employeeType.type();
    }

    public Plumbing(int u, String mainName, String rQ, int downTime, Location r, EmployeeType employeeType) {
        super(u,mainName, rQ, downTime, r, employeeType);

    String status = "Completed";
    public Plumbing(int u,String mainName, String rQ, int downTime, Location r) {
        super(u,mainName, rQ, downTime, r);

        this.urgency = u;
        this.requestingParty = rQ;
        this.loc = r;
        this.mainName = mainName;
    }

    public String getRequestingParty(){
        return requestingParty;
    }

    public void setRequestingParty(String requestingParty) {
        this.requestingParty = requestingParty;
    }
    public int getDownTime(){return appDownTime;}
    public void setD1(Date d1) {
        this.d1 = d1;
    }

    public void setLoc(Location loc){this.loc = loc; }
    public Location getLoc(){return loc;}

    public double getCost(){
        int u = getUrgency();
        int downTime = getDownTime();
        return calcMaintenanceCost(u, downTime);
    }

    public Date getDate(){
        return d1;
    }

    public double calcMaintenanceCost(int urgency, int appDownTime){
        if(urgency < 2 && appDownTime < 2){
            return 60.00;
        }
        if(urgency >=2 && appDownTime >=2){
            return 90.00;
        }
        else{
            return 0;
        }
    }

    public double calcProblemRate(){
        double cost = getCost();
        //Pest control problem rate is determined based off cost and urgency
        // higher cost, higher urgency --> higher problem rate
        // problem calc for each unit/extra and then aggregated for the whole facility
        // problem rate is a percentage
        double problemRate = 0.0;
        if(cost ==  60.00 || urgency < 2){
            problemRate = 5.0;
            return problemRate;
        }
        else{
            problemRate = 10.0;
            return problemRate;
        }
    }
    public int calcDownTime(){
        if(urgency < 1){
            return appDownTime;
        }
        else{
            return appDownTime * 2;
        }
    }
    @Override
    public void update() {
        System.out.println( "Maintenance Status: " + status);

    }

    @Override
    public String toString() {
        return "Plumbing{" +
                "urgency=" + urgency +
                ", requestingParty='" + requestingParty + '\'' +
                ", d1=" + d1 +
                ", loc=" + loc +
                ", mainName='" + mainName + '\'' +
                '}';
    }
}