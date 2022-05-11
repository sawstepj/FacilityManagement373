package Base.Model.Maintenance;

import Base.Interfaces.EmployeeType;

public class BuildingEmployee implements EmployeeType {

    @Override
    public String type() {
        return "Building Employee";
    }
}
