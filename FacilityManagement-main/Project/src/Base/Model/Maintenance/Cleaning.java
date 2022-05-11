package Base.Model.Maintenance;

import Base.Interfaces.EmployeeType;
import Base.Model.Facility.Location;

import java.util.Date;

public class Cleaning extends MaintenanceRequest {
    int urgency;
    String requestingParty;
    Date d1;
    Location loc;
    String mainName;
    String status = "In progress";

    public Cleaning(int urgency, String mainName, String requestingParty, int downTime, Location r, EmployeeType employeeType){
        super(urgency,mainName, requestingParty, downTime, r, employeeType);
        this.urgency = urgency;
        this.requestingParty = requestingParty;
        this.loc = r;
        this.mainName = mainName;

    }

    @Override
    public String employeeTyping() {
        return "Cleaning performed by: " + employeeType.type();
    }

    public String getRequestingParty(){
        return requestingParty;
    }

    public void setRequestingParty(String requestingParty) {
        this.requestingParty = requestingParty;
    }


    public void setD1(Date d1) {
        this.d1 = d1;
    }

    public void setLoc(Location loc){this.loc = loc; }
    public Location getLoc(){return loc;}
    public int getDownTime(){return appDownTime;}

    public double getCost(){
        int u = getUrgency();
        int downTime = getDownTime();
        return calcMaintenanceCost(u, downTime);
    }

    public Date getDate(){
        return d1;
    }



    public double calcMaintenanceCost(int urgency, int appDownTime){
        if(urgency < 2 && appDownTime < 4){
            return 45.00;
        }
        if(urgency >=2 && appDownTime >=2){
            return 50.00;
        }
        else{
            return 0;
        }
    }
    @Override
    public void update() {
        System.out.println( "Maintenance Status: " + status);

    }
    public double calcProblemRate(){
        double cost = getCost();
        //Pest control problem rate is determined based off cost and urgency
        // higher cost, higher urgency --> higher problem rate
        // problem calc for each unit/extra and then aggregated for the whole facility
        // problem rate is a percentage
        double problemRate = 0.0;
        if(cost ==  45.00 || urgency < 2){
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
    public String toString() {
        return "Cleaning{" +
                "urgency=" + urgency +
                ", requestingParty='" + requestingParty + '\'' +
                ", d1=" + d1 +
                ", loc=" + loc +
                ", mainName='" + mainName + '\'' +
                '}';
    }
}
