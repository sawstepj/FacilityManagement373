package Base.Model.Facility;

import Base.Interfaces.Facility;
import Base.Interfaces.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Detail implements Facility {
    private int numberOfFloors;
    private int numberOfUnits;
    private int floor;
    private int unit;
    private String fName;
    List<Floors> floorsList;
    List<Floors> unitsList;


    public Detail(String fName, int numberOfFloors, int numberOfUnits){
        this.numberOfUnits = numberOfUnits;
        this.numberOfFloors = numberOfFloors;
        this.fName = fName;
        this.floorsList = new ArrayList<>();
        this.unitsList = new ArrayList<>();
    }

    public int getFloor(){
        return floor;
    }
    public int getUnit(){
        return unit;
    }
    public void setFloor(int floor) { this.floor = floor; }
    public void setUnit(int unit) {
        this.unit = unit;
    }
    public void setNumberOfFloors(int numberOfFloors){
        this.numberOfFloors= numberOfFloors;
    }
    public void setNumberOfUnits(int numberOfUnits){
        this.numberOfUnits = numberOfUnits;
    }
    public void addFloor(Floors floor){
        floorsList.add(floor);
    }
    public void addUnit(Units unit){
        unitsList.add(unit);
    }
    public void deleteFloor(Floors floor){
        floorsList.remove(floor);
    }
    public void deleteUnit(Units unit){
        unitsList.remove(unit);
    }
    public void setFName(String fName){
        this.fName = fName;
    }
    public String getfName() { return fName; }

    @Override
    public void getInfo(Facility facility) {
        System.out.println("Facility name: " + fName);
        System.out.println("Number of floors: " + numberOfFloors);
        System.out.println("Number of units: " + numberOfUnits);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDetail(this);
    }
}
