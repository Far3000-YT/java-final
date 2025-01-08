package base;

public class StaffCabin extends Employee {
    private String qualification;

    public StaffCabin(String ID, String name, String address, String contact, String numberEmp, String hiringDate, String qualification) {
        super(ID, name, address, contact, numberEmp, hiringDate);
        this.qualification = qualification;
    }

    public void assignFlight(String flightNumber) {
        System.out.println("Cabin staff assigned to flight " + flightNumber);
    }

    public void obtainVol(String flightDetails) {
        System.out.println("Cabin staff obtaining flight details: " + flightDetails);
    }

    @Override
    public String getRole() {
        return "Cabin Staff";
    }

    public String getQualification() {
        return qualification;
    }
}