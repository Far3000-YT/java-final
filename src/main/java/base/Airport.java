package base;

public class Airport {
    private String name;
    private String city;
    private String description;

    public Airport(String name, String city, String description) {
        this.name = name;
        this.city = city;
        this.description = description;
    }

    public void assignFlight(String flightNumber) {
        System.out.println("Flight " + flightNumber + " assigned to airport " + name);
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }
}