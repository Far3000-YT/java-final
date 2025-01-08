package base;

import java.util.ArrayList;

public class Passenger extends Person {
    private String passport;
    private ArrayList<Book> books = new ArrayList<>();

    public Passenger(String ID, String name, String address, String contact, String passport) {
        super(ID, name, address, contact);
        this.passport = passport;
    }

    public void bookFlight(Book book) {
        books.add(book);
        System.out.println("Flight booked with reservation number: " + book.getReservationNumber());
    }

    public void cancelFlight(Book book) {
        books.remove(book);
        System.out.println("Flight canceled with reservation number: " + book.getReservationNumber());
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String getInfos() {
        return "Passenger [passport=" + passport + ", books=" + books + "]";
    }
}