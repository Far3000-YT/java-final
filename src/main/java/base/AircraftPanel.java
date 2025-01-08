package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AircraftPanel extends JPanel {
    private AirlineGUI airlineGUI;
    private JTextField registrationField, modelField, capacityField;
    private JTextArea outputArea;

    public AircraftPanel(AirlineGUI airlineGUI) {
        this.airlineGUI = airlineGUI;
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        registrationField = new JTextField();
        modelField = new JTextField();
        capacityField = new JTextField();

        inputPanel.add(new JLabel("Registration:"));
        inputPanel.add(registrationField);
        inputPanel.add(new JLabel("Model:"));
        inputPanel.add(modelField);
        inputPanel.add(new JLabel("Capacity:"));
        inputPanel.add(capacityField);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Aircraft");
        JButton showButton = new JButton("Show Aircrafts");
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
                addAircraft();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAircrafts();
            }
        });
    }

    private void addAircraft() {
        String registration = registrationField.getText();
        String model = modelField.getText();
        String capacityString = capacityField.getText();

        if (registration.isEmpty() || model.isEmpty() || capacityString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int capacity;
        try {
            capacity = Integer.parseInt(capacityString);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Capacity must be a number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Aircraft aircraft = new Aircraft(registration, model, capacity);
        airlineGUI.getData().getAircrafts().add(aircraft);
        clearInputFields();
        outputArea.append("Aircraft added: " + registration + " (" + model + ")\n");
    }

    private void showAircrafts() {
        outputArea.setText("");
        ArrayList<Aircraft> aircrafts = airlineGUI.getData().getAircrafts();
        if (aircrafts.isEmpty()) {
            outputArea.append("No aircrafts added yet.\n");
            return;
        }
        for (Aircraft a : aircrafts) {
            outputArea.append("Registration: " + a.getRegistration() + ", Model: " + a.getModel() + ", Capacity: " + a.getCapacity() + "\n");
        }
    }

    private void clearInputFields() {
        registrationField.setText("");
        modelField.setText("");
        capacityField.setText("");
    }
}