package Base.Model.Use;


import Base.Model.Facility.Location;

public class CleanInspection extends Inspection {
    Location location;

    public CleanInspection(String type) {
        super(type);
    }

    public CleanInspection() {}

    public Location getLocation(){
        return location;
    }
}
