package Base.Model.Facility;

import Base.Interfaces.Visitor;

import java.util.ArrayList;
import java.util.List;

public class ExtraFacilities {
    Location location;
    int capacity;
    String type;
    List<String> extraFacilities = new ArrayList<>();
    Gym gym;
    Laundry laundry;


    public ExtraFacilities(String type, Location location, int capacity) {
        this.type = type;
        this.location = location;
        this.capacity = capacity;
    }


    public Location getLocation(){
        return location;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public void addExtraFacility(String type){
        extraFacilities.add(type);
    }
    public void removeExtraFacility(String type) { extraFacilities.remove(type); }
    public void listExtraFacilities(){
        for (String t: extraFacilities){
            System.out.println(t);
        }
    }


    public void setGym(Gym gym) {}

    public void setLaundry(Laundry laundry) {}
}
