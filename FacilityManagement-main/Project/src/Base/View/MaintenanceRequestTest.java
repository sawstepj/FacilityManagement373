package Base.View;

import Base.Interfaces.EmployeeType;
import Base.Model.Maintenance.BuildingEmployee;
import Base.Model.Maintenance.MaintenanceRequest;
import Base.Model.Facility.Location;
import org.junit.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceRequestTest {

    int unitNumber = 1;
    int floorNumber = 2;
    int urgency = 1;
    String mainName = "Cleaning";
    String rQ = "Tenant";
    int downTime = 2;
    String date = "2016-02-14";
    Date d =  Base.Model.Facility.Date.parseDate(date);
    Location l = new Location(unitNumber,floorNumber);
    EmployeeType employeeType = new BuildingEmployee();


    @Test
    public void testInformationRetrieval() {
        MaintenanceRequest mR = new MaintenanceRequest(urgency, mainName, rQ, downTime, l, employeeType) {
            @Override
            public String employeeTyping() {
                return employeeType.type();
            }
        };
        assertEquals("Cleaning",mR.getName());
        assertEquals("Tenant",mR.getRequestingParty());
        assertEquals(1,mR.getUrgency());
        assertNotNull(mR.getLocation());
        assertNotNull(mR.getDate());
        assertEquals("Building Employee", mR.employeeTyping());
    }


}
