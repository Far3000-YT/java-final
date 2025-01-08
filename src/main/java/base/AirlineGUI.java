package base;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AirlineGUI extends JFrame {
    private static final String DATA_FILE = "src/main/resources/data.json";
    private Data data;

    public AirlineGUI() {
        // Set up the main frame
        setTitle("Airline Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Load data from JSON file
        loadData();

        // Create a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create and add panels to the tabbed pane
        tabbedPane.addTab("Passengers", new PassengerPanel(this));
        tabbedPane.addTab("Flights", new FlightPanel(this));
        tabbedPane.addTab("Bookings", new BookingPanel(this));
        tabbedPane.addTab("Employees", new EmployeePanel(this));
        tabbedPane.addTab("Aircraft", new AircraftPanel(this));
        tabbedPane.addTab("Airports", new AirportPanel(this));

        // Add the tabbed pane to the frame
        add(tabbedPane);

        // Save data to JSON file on close
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                saveData();
            }
        });
    }

    // Add this getter method:
    public Data getData() {
        return data;
    }

    private void loadData() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(DATA_FILE)) {
            data = gson.fromJson(reader, Data.class);
        } catch (IOException e) {
            System.err.println("Error loading data from JSON: " + e.getMessage());
            data = new Data(); // Initialize with empty data
        }

        if (data == null) {
            data = new Data();
        }
    }

    private void saveData() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter(DATA_FILE)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            System.err.println("Error saving data to JSON: " + e.getMessage());
        }
    }
}