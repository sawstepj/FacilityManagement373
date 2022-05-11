package Base.Model.Facility;

public class Location {
    int unitNumber;
    int floorNumber;

    public Location(int fN, int uN){
        this.floorNumber = fN;
        this.unitNumber = uN;

    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    @Override
    public String toString() {
        return "Location {" +
                "unitNumber = " + unitNumber +
                ", floorNumber = " + floorNumber +
                '}';
    }
}
