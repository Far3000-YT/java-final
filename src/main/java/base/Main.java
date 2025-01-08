package base;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AirlineGUI airlineGUI = new AirlineGUI();
            airlineGUI.setVisible(true);
        });
    }
}

// to update the data.json file basically close the program