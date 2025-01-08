package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EmployeePanel extends JPanel {
    private AirlineGUI airlineGUI;
    private JTextField idField, nameField, addressField, contactField, numberEmpField, hiringDateField, specificField;
    private JComboBox<String> roleComboBox;
    private JTextArea outputArea;

    public EmployeePanel(AirlineGUI airlineGUI) {
        this.airlineGUI = airlineGUI;
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(8, 2));
        idField = new JTextField();
        nameField = new JTextField();
        addressField = new JTextField();
        contactField = new JTextField();
        numberEmpField = new JTextField();
        hiringDateField = new JTextField();
        specificField = new JTextField(); // Field for license or qualification
        roleComboBox = new JComboBox<>(new String[]{"Airplane Pilot", "Staff Cabin"});

        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Contact:"));
        inputPanel.add(contactField);
        inputPanel.add(new JLabel("Employee Number:"));
        inputPanel.add(numberEmpField);
        inputPanel.add(new JLabel("Hiring Date:"));
        inputPanel.add(hiringDateField);
        inputPanel.add(new JLabel("Role:"));
        inputPanel.add(roleComboBox);
        inputPanel.add(new JLabel("License/Qualification:"));
        inputPanel.add(specificField);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Employee");
        JButton showButton = new JButton("Show Employees");
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
                addEmployee();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEmployees();
            }
        });
    }

    private void addEmployee() {
        String id = idField.getText();
        String name = nameField.getText();
        String address = addressField.getText();
        String contact = contactField.getText();
        String numberEmp = numberEmpField.getText();
        String hiringDate = hiringDateField.getText();
        String specific = specificField.getText();
        String role = (String) roleComboBox.getSelectedItem();

        if (id.isEmpty() || name.isEmpty() || address.isEmpty() || contact.isEmpty() || numberEmp.isEmpty() || hiringDate.isEmpty() || specific.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Employee employee;
        if (role.equals("Airplane Pilot")) {
            employee = new AirplanePilot(id, name, address, contact, numberEmp, hiringDate, specific, 0); // Assuming 0 flight hours for new pilot
        } else {
            employee = new StaffCabin(id, name, address, contact, numberEmp, hiringDate, specific);
        }

        airlineGUI.getData().getEmployees().add(employee);
        clearInputFields();
        outputArea.append("Employee added: " + name + " (" + role + ")\n");
    }

    private void showEmployees() {
        outputArea.setText("");
        ArrayList<Employee> employees = airlineGUI.getData().getEmployees();
        if (employees.isEmpty()) {
            outputArea.append("No employees added yet.\n");
            return;
        }
        for (Employee emp : employees) {
            String specificInfo = "";
            if (emp instanceof AirplanePilot) {
                specificInfo = ", License: " + ((AirplanePilot) emp).getLicense();
            } else if (emp instanceof StaffCabin) {
                specificInfo = ", Qualification: " + ((StaffCabin) emp).getQualification();
            }
            outputArea.append("ID: " + emp.getID() + ", Name: " + emp.getName() + ", Role: " + emp.getRole() + specificInfo + "\n");
        }
    }

    private void clearInputFields() {
        idField.setText("");
        nameField.setText("");
        addressField.setText("");
        contactField.setText("");
        numberEmpField.setText("");
        hiringDateField.setText("");
        specificField.setText("");
    }
}