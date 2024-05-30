import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * @brief Main class for the Paint application.
 *
 * This class serves as the entry point for the Paint application.
 * It initializes the logger, creates the GUI, and launches the JavaFX application.
 */
public final class PaintApp extends Application {

    /**
     * @brief Main method to launch the application.
     *
     * Initializes the logger, logs initialization message, and launches the JavaFX application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        PaintLogger.Config(); // Initialize the logger
        PaintLogger.logger.log(Level.INFO, "Paint created, logger initialised"); // Log initialization message

        Application.launch(args); // Launch the JavaFX application
    }

    /**
     * @brief Entry point for the JavaFX application.
     *
     * Initializes the GUI by creating a map of drawable object suppliers and passing
     * it to the PaintGUI constructor.
     *
     * @param stage The primary stage for the application.
     */
    @Override
    public void start(Stage stage) {
        // Create a map of drawable object suppliers
        Map<String, DrawableObjectSupplier> handledObjects = new HashMap<>();
        handledObjects.put("Ellipse", new EllipseSupplier());
        handledObjects.put("Triangle", new TriangleSupplier());
        handledObjects.put("Rectangle", new RectangleSupplier());

        // Create the PaintGUI with the primary stage and the map of drawable object suppliers
        new PaintGUI(stage, handledObjects);
    }
}
