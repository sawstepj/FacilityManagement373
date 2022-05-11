package Base.Model.Facility;

public class Gym extends ExtraFacilities {
    String facilityType;


    public Gym(String name, Location location, int nF) {
        super(name, location, nF);
    }



    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }
}
