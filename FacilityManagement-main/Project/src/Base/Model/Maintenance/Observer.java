package Base.Model.Maintenance;

public abstract class Observer {
    MaintenanceRequest subject;
    public abstract void update();
}
