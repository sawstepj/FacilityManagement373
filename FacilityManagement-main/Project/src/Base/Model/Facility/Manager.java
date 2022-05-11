package Base.Model.Facility;

import Base.Interfaces.Facility;
import Base.Interfaces.Visitor;

public class Manager extends Detail {
    Facility facility;

    public Manager(String name,int numberOfUnits, int numberOfFloors) {
        super(name, numberOfUnits, numberOfFloors);
    }

    public Facility getFacility(){ return facility; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitManager(this);
    }
}
