package base;

public class AirplanePilot extends Employee {
    private String license;
    private int flightHours;

    public AirplanePilot(String ID, String name, String address, String contact, String numberEmp, String hiringDate, String license, int flightHours) {
        super(ID, name, address, contact, numberEmp, hiringDate);
        this.license = license;
        this.flightHours = flightHours;
    }

    public void assignFlight(String flightNumber) {
        System.out.println("Pilot assigned to flight " + flightNumber);
    }

    public void obtainVol(String flightDetails) {
        System.out.println("Pilot obtaining flight details: " + flightDetails);
    }

    @Override
    public String getRole() {
        return "Airplane Pilot";
    }

    public String getLicense() {
        return license;
    }

    public int getFlightHours() {
        return flightHours;
    }
}