package Base.View;

import Base.Model.Facility.Location;
import Base.Model.Use.UseSchedule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseScheduleTest {
    boolean availability = false;
    int unitNum = 1;
    int floorNum = 4;
    Location l1 = new Location(unitNum, floorNum);
    String unitType = "Unit";
    int useInterval = 3;
    boolean requiresInspection = true;
    int numberOfUsers = 10;
    int capacity = 20;

    String typeName = "Gym";

    @Test
    void setObjectsTest() {
        UseSchedule useSched = new UseSchedule(unitType, typeName, l1, availability, numberOfUsers);
        assertEquals("Unit",useSched.getUnitType());
        assertEquals(10,useSched.getUsers());
        assertEquals(3, useSched.getUseInterval());
    }

}