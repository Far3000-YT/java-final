package base;

public class Aircraft {
    private String registration;
    private String model;
    private int capacity;

    public Aircraft(String registration, String model, int capacity) {
        this.registration = registration;
        this.model = model;
        this.capacity = capacity;
    }

    public void assignFlight(String flightNumber) {
        System.out.println("Aircraft " + registration + " assigned to flight " + flightNumber);
    }

    public boolean checkAvailability(String flightNumber) {
        System.out.println("Checking availability for flight " + flightNumber);
        return true;
    }

    public String getRegistration() {
        return registration;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }
}