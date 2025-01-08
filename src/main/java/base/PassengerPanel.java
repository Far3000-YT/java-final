package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PassengerPanel extends JPanel {
    private AirlineGUI airlineGUI;
    private JTextField idField, nameField, addressField, contactField, passportField;
    private JTextArea outputArea;

    public PassengerPanel(AirlineGUI airlineGUI) {
        this.airlineGUI = airlineGUI;
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        idField = new JTextField();
        nameField = new JTextField();
        addressField = new JTextField();
        contactField = new JTextField();
        passportField = new JTextField();

        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Contact:"));
        inputPanel.add(contactField);
        inputPanel.add(new JLabel("Passport:"));
        inputPanel.add(passportField);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Passenger");
        JButton showButton = new JButton("Show Passengers");
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
                addPassenger();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPassengers();
            }
        });
    }

    private void addPassenger() {
        String id = idField.getText();
        String name = nameField.getText();
        String address = addressField.getText();
        String contact = contactField.getText();
        String passport = passportField.getText();

        if (id.isEmpty() || name.isEmpty() || address.isEmpty() || contact.isEmpty() || passport.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Passenger passenger = new Passenger(id, name, address, contact, passport);
        airlineGUI.getData().getPassengers().add(passenger);
        clearInputFields();
        outputArea.append("Passenger added: " + name + "\n");
    }

    private void showPassengers() {
        outputArea.setText("");
        ArrayList<Passenger> passengers = airlineGUI.getData().getPassengers();
        if (passengers.isEmpty()) {
            outputArea.append("No passengers added yet.\n");
            return;
        }
        for (Passenger p : passengers) {
            outputArea.append(p.getInfos() + "\n");
        }
    }

    private void clearInputFields() {
        idField.setText("");
        nameField.setText("");
        addressField.setText("");
        contactField.setText("");
        passportField.setText("");
    }
}