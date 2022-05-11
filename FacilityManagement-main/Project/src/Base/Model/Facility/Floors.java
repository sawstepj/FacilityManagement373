package Base.Model.Facility;

public class Floors {
    int numOfUnits;
    int floorNumber;
    Units units;

    public Floors(String fName, int fN, int nU){
        this.floorNumber = fN;
        this.numOfUnits = nU;
    }



    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getNumOfUnits() {
        return numOfUnits;
    }

    public void setNumOfUnits(int numOfUnits) {
        this.numOfUnits = numOfUnits;
    }

    public int requestAvailableCapacity(){
        return 0;
    } //num of units available on a floor

    public void setUnits(Units units) {}
}
