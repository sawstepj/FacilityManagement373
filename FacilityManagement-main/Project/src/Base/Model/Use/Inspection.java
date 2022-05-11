package Base.Model.Use;

import Base.Interfaces.Facility;

public class Inspection implements Facility {

    String inspectionType;
    SafetyInspection safetyInspection;
    CleanInspection cleanInspection;

    public Inspection(String type){
        this.inspectionType = type;
    }

    public Inspection() {}

    public boolean inspectionPassFail(boolean inspectionStatus) {
        boolean inspectionStatus1;
        return inspectionStatus1 = inspectionStatus;
    }

    @Override
    public void getInfo(Facility facility) {

    }

    public void setSafetyInspection(SafetyInspection safetyInspection) {
        this.safetyInspection = safetyInspection;
    }

    public void setCleanInspection(CleanInspection cleanInspection) {
        this.cleanInspection = cleanInspection;
    }
}

