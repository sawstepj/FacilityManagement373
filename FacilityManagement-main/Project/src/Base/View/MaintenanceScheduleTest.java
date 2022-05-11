package Base.View;

import Base.Interfaces.EmployeeType;
import Base.Model.Maintenance.Contractor;
import Base.Model.Maintenance.MaintenanceRequest;
import Base.Model.Maintenance.MaintenanceSchedule;
import Base.Model.Facility.Location;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceScheduleTest {
    int unitNumber = 1;
    int floorNumber = 2;
    int urgency = 1;
    String mainName = "Cleaning";
    String rQ = "Tenant";
    int downTime = 2;
    String date = "2016-02-14";
    Date d =  Base.Model.Facility.Date.parseDate(date);
    Location l = new Location(unitNumber,floorNumber);
    MaintenanceSchedule mS = new MaintenanceSchedule();
    EmployeeType employeeType = new Contractor();


    @Test
    void testAdditionRequests() {
        MaintenanceRequest mR = new MaintenanceRequest(urgency, mainName, rQ, downTime, l, employeeType) {
            @Override
            public String employeeTyping() {
                return employeeType.type();
            }
        };
        List<MaintenanceRequest> l1 = mS.getRequestsList();
        l1.add(mR);
        assertEquals(1,l1.size());
    }

    @Test
    void scheduleMaintenance() {
        MaintenanceRequest mR = new MaintenanceRequest(urgency, mainName, rQ, downTime, l, employeeType) {
            @Override
            public String employeeTyping() {
                return employeeType.type();
            }
        };
        mS.scheduleMaintenance(mR);
        assertEquals("Cleaning",mR.getName());
    }

}
