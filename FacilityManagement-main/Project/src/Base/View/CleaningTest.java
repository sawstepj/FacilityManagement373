package Base.View;

import Base.Interfaces.EmployeeType;
import Base.Model.Maintenance.Cleaning;
import Base.Model.Facility.Location;
import Base.Model.Maintenance.Contractor;
import Base.Model.Maintenance.MaintenanceRequest;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CleaningTest {
    int unitNumber = 1;
    int floorNumber = 2;
    int urgency = 1;
    String mainName = "Cleaning";
    String rQ = "Tenant";
    int downTime = 2;
    String date = "2016-02-14";
    Date d =  Base.Model.Facility.Date.parseDate(date);
    Location l = new Location(unitNumber,floorNumber);
    EmployeeType employeeType = new Contractor();



    @Test
    void testCost() {
        Cleaning c = new Cleaning(urgency,mainName,rQ,downTime,l,employeeType);
        assertEquals(45.00, c.calcMaintenanceCost(urgency,downTime));
    }

    @Test
    void testProblemRate() {
        Cleaning c = new Cleaning(urgency,mainName,rQ,downTime,l,employeeType);
        assertEquals(5.0, c.calcProblemRate());
    }

    @Test
    void calcDownTime() {
        Cleaning c = new Cleaning(urgency,mainName,rQ,downTime,l,employeeType);
        assertEquals(4.0, c.calcDownTime());

    }

    @org.junit.Test
    public void whenBridgePatternInvoked_thenConfigSuccess(){
        Cleaning c = new Cleaning(urgency,mainName,rQ,downTime,l,employeeType);
            EmployeeType e = new Contractor();
        assertEquals(c.employeeTyping(), "Cleaning performed by: Contractor");
    }
}