// Vehicle.java
public class Vehicle {
    private final String id;
    private final int wheels;

    public Vehicle(String id, int wheels) {
        this.id = id;
        this.wheels = wheels;
    }

    public String getId() {
        return id;
    }

    public int getWheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return id + " (" + wheels + " roda)";
    }
}