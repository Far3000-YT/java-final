package base;

import java.util.ArrayList;

public class Data {
    private ArrayList<Passenger> passengers;
    private ArrayList<Flight> flights;
    private ArrayList<Book> bookings;
    private ArrayList<Employee> employees;
    private ArrayList<Aircraft> aircrafts;
    private ArrayList<Airport> airports;

    public Data() {
        passengers = new ArrayList<>();
        flights = new ArrayList<>();
        bookings = new ArrayList<>();
        employees = new ArrayList<>();
        aircrafts = new ArrayList<>();
        airports = new ArrayList<>();
    }

    // Getters and Setters
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public ArrayList<Book> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Book> bookings) {
        this.bookings = bookings;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(ArrayList<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public ArrayList<Airport> getAirports() {
        return airports;
    }

    public void setAirports(ArrayList<Airport> airports) {
        this.airports = airports;
    }
}