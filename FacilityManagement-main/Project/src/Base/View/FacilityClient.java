package Base.View;


import Base.Interfaces.EmployeeType;
import Base.Model.Facility.Date;
import Base.Model.Facility.Detail;
import Base.Model.Facility.Location;
import Base.Model.Maintenance.*;
import Base.Model.Use.UseSchedule;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;

public class FacilityClient {
    public static void main(String[] args) throws Exception {
        String textFile = "/Users/ayatdiab/IdeaProjects/FacilityManagement1/Project/src/Base/DAL/DataFile.txt";
        BufferedReader inputFile = new BufferedReader(new FileReader(textFile));
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");
        MaintenanceSchedule facMSchedule = (MaintenanceSchedule) context.getBean("maintenance");
        EmployeeType employeeType = new Contractor();
        //MaintenanceSchedule facMSchedule = new MaintenanceSchedule();
        String currentLine;
        String[] split;
        double cleaningCost = 0;
        double hvacCost = 0;
        double gkCost = 0;
        double pcCost = 0;
        double plumbingCost = 0;
        int cleaningDownTime = 0;
        int hvacDownTime = 0;
        int gKDownTime = 0;
        int pestDownTime = 0;
        int plumbingDownTime = 0;
        while ((currentLine = inputFile.readLine()) != null) {
            split = currentLine.split(",");
            //System.out.println(Arrays.toString(split));
            if (split[0].equalsIgnoreCase("Facility")) {
                String fName = split[1];
                int numFloors = Integer.parseInt(split[2]);
                int numUnits = Integer.parseInt(split[3]);
                //Detail newFacility = new Detail(fName, numFloors, numUnits);
                Detail newFacility = (Detail) context.getBean("detail");
                newFacility.setFName(fName);
                newFacility.setNumberOfFloors(numFloors);
                newFacility.setNumberOfUnits(numUnits);
                System.out.println("Facility Name: " + fName);
                System.out.println("Number of floors in facility: " + numFloors);
                System.out.println("Number of units in facility: " + numUnits);
            }
            if(split[0].equalsIgnoreCase("UseSchedule")){
                String schedName = split[1];
                String useType = split[2];
                int floorN = Integer.parseInt(split[3]);
                int unitN = Integer.parseInt(split[4]);
                Location useS = (Location) context.getBean("location");
                //Location useS = new Location(floorN, unitN);
                boolean inUse = Boolean.parseBoolean(split[5]);
                int capacity = Integer.parseInt(split[6]);
                //UseSchedule useSched = new UseSchedule(schedName,useType,useS,inUse,capacity);
                UseSchedule useSched = (UseSchedule) context.getBean("useSchedule");
                System.out.println("Usage of Facility");
                System.out.println(useSched.toString());
            }
            if (split[0].equalsIgnoreCase("MaintenanceRequest")) {
                int urgency = Integer.parseInt(split[1]);
                int downTime = Integer.parseInt(split[2]);
                String requestingParty = split[3];
                String typeName = split[4];
                int mFloor = Integer.parseInt(split[5]);
                int mUnit = Integer.parseInt(split[6]);
                //Location mLoc = new Location(mUnit, mFloor);
                Location mLoc = (Location) context.getBean("location");
                mLoc.setFloorNumber(mFloor);
                mLoc.setUnitNumber(mUnit);
                //MaintenanceRequest mR = new MaintenanceRequest(urgency, typeName, requestingParty, downTime, mLoc);
                MaintenanceRequest mR = (MaintenanceRequest) context.getBean("maintenanceR");
                // Add maintenance to schedule
                facMSchedule.addMaintenance(mR);
                facMSchedule.scheduleMaintenance(mR);
                if (typeName.equalsIgnoreCase("Cleaning")) {
                    //Cleaning c = new Cleaning(urgency, typeName, requestingParty, downTime, mLoc);
                    Cleaning c = (Cleaning) context.getBean("cleaning");
                    c.setUrgency(urgency);
                    cleaningCost += c.calcMaintenanceCost(urgency, downTime);
                    cleaningDownTime = c.calcDownTime();
                    int floorN = mLoc.getFloorNumber();
                    int unitN = mLoc.getUnitNumber();
                    String cS =  c.toString();
                    System.out.println(cS);
                } else if (typeName.equalsIgnoreCase("HVAC")) {
                    //HVAC hV = new HVAC(urgency, typeName, requestingParty, downTime, mLoc);
                    HVAC hV = (HVAC) context.getBean("hvac");
                    hV.setUrgency(urgency);
                    hvacCost += hV.calcMaintenanceCost(urgency, downTime);
                    hvacDownTime = hV.calcDownTime();
                    System.out.println("Cost for HVAC maintenance: " + hvacCost + "on " + mLoc.toString());
                    System.out.println("Facility HVAC maintenance down time: " + hvacDownTime);

                } else if (typeName.equalsIgnoreCase("GroundsKeeping")) {
                    //GroundsKeeping gK = new GroundsKeeping(urgency, typeName, requestingParty, downTime, mLoc);
                    GroundsKeeping gK = (GroundsKeeping) context.getBean("gk");
                    gKDownTime = gK.calcDownTime();
                    gkCost += gK.calcMaintenanceCost(urgency, downTime);
                } else if (typeName.equalsIgnoreCase("PestControl")) {
                    //PestControl pC = new PestControl(urgency, typeName, requestingParty, downTime, mLoc);
                    PestControl pC = (PestControl) context.getBean("pc");
                    pestDownTime = pC.calcDownTime();
                    pcCost += pC.calcMaintenanceCost(urgency, downTime);
                } else {
                    //Plumbing pl = new Plumbing(urgency, typeName, requestingParty, downTime, mLoc);
                    Plumbing pl = (Plumbing) context.getBean("plumbing");
                    plumbingCost += pl.calcMaintenanceCost(urgency, downTime);
                    plumbingDownTime = pl.calcDownTime();
                }
                double costFacility = mR.calcFacilityMaintenanceCost(cleaningCost, gkCost, hvacCost, pcCost, plumbingCost);
                System.out.println("Facility cost based of maintenances: " + costFacility);

                int fDT = mR.calcDownTime(cleaningDownTime, gKDownTime, hvacDownTime, pestDownTime, plumbingDownTime);
                System.out.println("The average downtime for facility - apartment complex is: " + fDT + " hours");

                System.out.println("Facility Problems:");
                System.out.println("HVAC repairs, cleaning, plumbing, and pest control");
            }
            // Make a maintenance request
            String mSD = "2016-02-20";
            int unitNumber = 5;
            int floorNumber = 2;
            Location l = (Location) context.getBean("location");
            //Location l = new Location(5,2);
            //MaintenanceSchedule mS = new MaintenanceSchedule();
            MaintenanceSchedule mS = (MaintenanceSchedule) context.getBean("maintenance");
            mS.makeFacilityRequest(2,"Plumbing","Manager",3,l,employeeType);
            //Prints out all maintenance requests
            //mS.listMaintenanceRequests();
        }
        inputFile.close();
    }
}