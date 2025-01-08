package base;

import java.util.ArrayList;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalDateTime;
    private String status;
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public Flight(String flightNumber, String origin, String destination, String departureTime, String arrivalDateTime, String status) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalDateTime = arrivalDateTime;
        this.status = status;
    }

    public void planFlight() {
        this.status = "Planned";
        System.out.println("Flight " + flightNumber + " has been planned.");
    }

    public void cancelFlight() {
        this.status = "Cancelled";
        System.out.println("Flight " + flightNumber + " has been cancelled.");
    }

    public void modifyFlight(String newDepartureTime, String newArrivalDateTime) {
        this.departureTime = newDepartureTime;
        this.arrivalDateTime = newArrivalDateTime;
        System.out.println("Flight " + flightNumber + " modified.");
    }

    public ArrayList<Passenger> listingPassenger() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public String getStatus() {
        return status;
    }
}