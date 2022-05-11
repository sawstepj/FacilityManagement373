package Base.Model.Facility;

import Base.Interfaces.Visitor;

public class FacilityVisitor implements Visitor {

    @Override
    public void visitDetail(Detail detail) {
        System.out.println("Retrieving lease for unit: " + detail.getUnit()); ;
    }

    @Override
    public void visitManager(Manager manager) {
        System.out.println("Retrieving facility: " + manager.getFacility()); ;
    }
}
