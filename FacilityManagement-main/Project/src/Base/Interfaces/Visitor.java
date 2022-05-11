package Base.Interfaces;

import Base.Model.Facility.Detail;
import Base.Model.Facility.Manager;

public interface Visitor {
    void visitDetail(Detail detail);
    void visitManager(Manager manager);
}
