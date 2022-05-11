package Base.Model.Use;

import Base.Interfaces.Facility;
import Base.Interfaces.Use;
import Base.Model.Facility.Location;

public class User implements Use {
    private Facility type;
    private Location location;

    public Location getLocation() {
        return location;
    }


    @Override
    public void getInfo() {

    }

}
