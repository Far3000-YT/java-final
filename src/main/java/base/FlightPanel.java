package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FlightPanel extends JPanel {
    private AirlineGUI airlineGUI;
    private JTextField flightNumberField, originField, destinationField, departureTimeField, arrivalTimeField, statusField;
    private JTextArea outputArea;

    public FlightPanel(AirlineGUI airlineGUI) {
        this.airlineGUI = airlineGUI;
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        flightNumberField = new JTextField();
        originField = new JTextField();
        destinationField = new JTextField();
        departureTimeField = new JTextField();
        arrivalTimeField = new JTextField();
        statusField = new JTextField();

        inputPanel.add(new JLabel("Flight Number:"));
        inputPanel.add(flightNumberField);
        inputPanel.add(new JLabel("Origin:"));
        inputPanel.add(originField);
        inputPanel.add(new JLabel("Destination:"));
        inputPanel.add(destinationField);
        inputPanel.add(new JLabel("Departure Time:"));
        inputPanel.add(departureTimeField);
        inputPanel.add(new JLabel("Arrival Time:"));
        inputPanel.add(arrivalTimeField);
        inputPanel.add(new JLabel("Status:"));
        inputPanel.add(statusField);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Flight");
        JButton showButton = new JButton("Show Flights");
        buttonPanel.add(addButton);
        buttonPanel.add(showButton);

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
                addFlight();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFlights();
            }
        });
    }

    private void addFlight() {
        String flightNumber = flightNumberField.getText();
        String origin = originField.getText();
        String destination = destinationField.getText();
        String departureTime = departureTimeField.getText();
        String arrivalTime = arrivalTimeField.getText();
        String status = statusField.getText();

        if (flightNumber.isEmpty() || origin.isEmpty() || destination.isEmpty() || departureTime.isEmpty() || arrivalTime.isEmpty() || status.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Flight flight = new Flight(flightNumber, origin, destination, departureTime, arrivalTime, status);
        airlineGUI.getData().getFlights().add(flight);
        clearInputFields();
        outputArea.append("Flight added: " + flightNumber + "\n");
    }

    private void showFlights() {
        outputArea.setText("");
        ArrayList<Flight> flights = airlineGUI.getData().getFlights();
        if (flights.isEmpty()) {
            outputArea.append("No flights added yet.\n");
            return;
        }
        for (Flight f : flights) {
            outputArea.append("Flight Number: " + f.getFlightNumber() + ", Origin: " + f.getOrigin() + ", Destination: " + f.getDestination() + ", Departure Time: " + f.getDepartureTime() + ", Arrival Time: " + f.getArrivalDateTime() + ", Status: " + f.getStatus() + "\n");
        }
    }

    private void clearInputFields() {
        flightNumberField.setText("");
        originField.setText("");
        destinationField.setText("");
        departureTimeField.setText("");
        arrivalTimeField.setText("");
        statusField.setText("");
    }
}