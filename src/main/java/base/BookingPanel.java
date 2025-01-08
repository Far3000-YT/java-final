package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookingPanel extends JPanel {
    private AirlineGUI airlineGUI;
    private JTextField reservationNumberField, dateReservationField, statusField;
    private JTextArea outputArea;

    public BookingPanel(AirlineGUI airlineGUI) {
        this.airlineGUI = airlineGUI;
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        reservationNumberField = new JTextField();
        dateReservationField = new JTextField();
        statusField = new JTextField();

        inputPanel.add(new JLabel("Reservation Number:"));
        inputPanel.add(reservationNumberField);
        inputPanel.add(new JLabel("Date Reservation:"));
        inputPanel.add(dateReservationField);
        inputPanel.add(new JLabel("Status:"));
        inputPanel.add(statusField);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Booking");
        JButton showButton = new JButton("Show Bookings");
        JButton confirmButton = new JButton("Confirm Booking");
        JButton cancelButton = new JButton("Cancel Booking");
        buttonPanel.add(addButton);
        buttonPanel.add(showButton);
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add components to the panel
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Action Listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBooking();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBookings();
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmBooking();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelBooking();
            }
        });
    }

    private void addBooking() {
        String reservationNumber = reservationNumberField.getText();
        String dateReservation = dateReservationField.getText();
        String status = statusField.getText();

        if (reservationNumber.isEmpty() || dateReservation.isEmpty() || status.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Book booking = new Book(reservationNumber, dateReservation, status);
        airlineGUI.getData().getBookings().add(booking);
        clearInputFields();
        outputArea.append("Booking added: " + reservationNumber + "\n");
    }

    private void showBookings() {
        outputArea.setText("");
        ArrayList<Book> bookings = airlineGUI.getData().getBookings();
        if (bookings.isEmpty()) {
            outputArea.append("No bookings added yet.\n");
            return;
        }
        for (Book b : bookings) {
            outputArea.append("Reservation Number: " + b.getReservationNumber() + ", Date Reservation: " + b.getDateReservation() + ", Status: " + b.getStatus() + "\n");
        }
    }

    private void confirmBooking() {
        String reservationNumber = reservationNumberField.getText();
        if (reservationNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter reservation number to confirm", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Book b : airlineGUI.getData().getBookings()) {
            if (b.getReservationNumber().equals(reservationNumber)) {
                b.confirmReservation();
                outputArea.append("Booking confirmed: " + reservationNumber + "\n");
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Booking not found", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void cancelBooking() {
        String reservationNumber = reservationNumberField.getText();
        if (reservationNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter reservation number to cancel", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<Book> bookings = airlineGUI.getData().getBookings();
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getReservationNumber().equals(reservationNumber)) {
                bookings.get(i).cancelReservation();
                bookings.remove(i);
                outputArea.append("Booking canceled: " + reservationNumber + "\n");
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Booking not found", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void clearInputFields() {
        reservationNumberField.setText("");
        dateReservationField.setText("");
        statusField.setText("");
    }
}