package Base.Interfaces;

public interface Facility {
    public void getInfo(Facility facility);
    void accept(Visitor visitor);
}
