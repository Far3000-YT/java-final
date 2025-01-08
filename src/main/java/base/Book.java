package base;

public class Book {
    private String reservationNumber;
    private String dateReservation;
    private String status;

    public Book(String reservationNumber, String dateReservation, String status) {
        this.reservationNumber = reservationNumber;
        this.dateReservation = dateReservation;
        this.status = status;
    }

    public void confirmReservation() {
        this.status = "Confirmed";
        System.out.println("Reservation " + reservationNumber + " confirmed.");
    }

    public void cancelReservation() {
        this.status = "Cancelled";
        System.out.println("Reservation " + reservationNumber + " canceled.");
    }

    public void modifyReservation(String newDate) {
        this.dateReservation = newDate;
        System.out.println("Reservation " + reservationNumber + " modified to new date: " + newDate);
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public String getStatus() {
        return status;
    }
}