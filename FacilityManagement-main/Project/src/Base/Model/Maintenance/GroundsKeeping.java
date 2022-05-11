package Base.Model.Maintenance;


import Base.Interfaces.EmployeeType;
import Base.Model.Facility.Location;

import java.util.Date;

public class GroundsKeeping extends MaintenanceRequest {

    int urgency;
    String requestingParty;
    Date d1;
    Location loc;
    String mainName;
    String status = "In progress";



    public GroundsKeeping(int u, String mainName, String rQ, int downTime, Location r, EmployeeType employeeType) {
        super(u, mainName,rQ, downTime, r, employeeType);
        this.urgency = u;
        this.requestingParty = rQ;
        this.loc = r;
        this.mainName = mainName;
    }

    @Override
    public String employeeTyping() {
        return "Grounds keeping performed by: " + employeeType.type();
    }

    public double getCost(){
        int u = getUrgency();
        int downTime = getDownTime();
        return calcMaintenanceCost(u, downTime);
    }
    public int getDownTime(){return appDownTime;}
    public int getUrgency(){
        return urgency;
    }
    public void setUrgency(int urgency){
        this.urgency = urgency;
    }
    public String getRequestingParty(){
        return requestingParty;
    }

    public void setRequestingParty(String requestingParty) {
        this.requestingParty = requestingParty;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }
    public Date getD1(){
        return d1;
    }

    public void setD1(Date d1) {
        this.d1 = d1;
    }

    public double calcMaintenanceCost(int urgency, int appDownTime){
        if(urgency < 2 && appDownTime < 2){
            return 50.00;
        }
        if(urgency >=2 && appDownTime >=2){
            return 100.00;
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
        if(cost == 100.00){
            problemRate = 10.0;
            return problemRate;
        }
        else{
            problemRate = 20.0;
            return problemRate;
        }
    }
    public int calcDownTime(){
        if(urgency < 2){
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
        return "GroundsKeeping{" +
                "urgency=" + urgency +
                ", requestingParty='" + requestingParty + '\'' +
                ", d1=" + d1 +
                ", loc=" + loc +
                ", mainName='" + mainName + '\'' +
                '}';
    }
}
