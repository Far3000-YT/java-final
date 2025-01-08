package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AirportPanel extends JPanel {
    private AirlineGUI airlineGUI;
    private JTextField nameField, cityField, descriptionField;
    private JTextArea outputArea;

    public AirportPanel(AirlineGUI airlineGUI) {
        this.airlineGUI = airlineGUI;
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        nameField = new JTextField();
        cityField = new JTextField();
        descriptionField = new JTextField();

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("City:"));
        inputPanel.add(cityField);
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Airport");
        JButton showButton = new JButton("Show Airports");
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
                addAirport();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAirports();
            }
        });
    }

    private void addAirport() {
        String name = nameField.getText();
        String city = cityField.getText();
        String description = descriptionField.getText();

        if (name.isEmpty() || city.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Airport airport = new Airport(name, city, description);
        airlineGUI.getData().getAirports().add(airport);
        clearInputFields();
        outputArea.append("Airport added: " + name + " in " + city + "\n");
    }

    private void showAirports() {
        outputArea.setText("");
        ArrayList<Airport> airports = airlineGUI.getData().getAirports();
        if (airports.isEmpty()) {
            outputArea.append("No airports added yet.\n");
            return;
        }
        for (Airport a : airports) {
            outputArea.append("Name: " + a.getName() + ", City: " + a.getCity() + ", Description: " + a.getDescription() + "\n");
        }
    }

    private void clearInputFields() {
        nameField.setText("");
        cityField.setText("");
        descriptionField.setText("");
    }
}