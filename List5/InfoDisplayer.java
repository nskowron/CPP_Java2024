import javafx.scene.control.Alert;

/**
 * Utility class for displaying information messages.
 */
public class InfoDisplayer {

    // Private constructor to prevent instantiation
    private InfoDisplayer() throws InstantiationError {
        throw new InstantiationError("Cannot create instance of a static class InfoDisplayer");
    }

    /**
     * @brief Displays an information message in an alert dialog.
     * @param title The title of the information dialog.
     * @param info The information message to display.
     */
    public static void display(String title, String info) {
        // Create a new alert dialog with information type
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        // Set the title and content of the alert
        alert.setTitle(title);
        alert.setHeaderText(null); // No header text
        alert.setContentText(info);

        // Show the alert dialog and wait for user interaction
        alert.showAndWait();
    }
}
