package Base.Model.Facility;

public class Units extends Floors {
    int capacity;
    boolean isAvailable;


    public Units(String fName,int fN, int nU, boolean available) {

        super(fName,fN, nU);
        this.isAvailable = available;
    }


    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public boolean getAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public int getFloorNumber() {
        return floorNumber;
    }

    @Override
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
