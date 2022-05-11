package Base.Model.Use;


import Base.Model.Facility.Location;

public class SafetyInspection extends Inspection {
    Location location;

    public SafetyInspection(String type) {
        super(type);
    }

    public SafetyInspection() {
        super();
    }

    public Location getLocation(){
        return location;
    }
}
