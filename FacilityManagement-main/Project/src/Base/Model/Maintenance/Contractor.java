package Base.Model.Maintenance;

import Base.Interfaces.EmployeeType;

public class Contractor implements EmployeeType {

    @Override
    public String type() {
        return "Contractor";
    }
}
