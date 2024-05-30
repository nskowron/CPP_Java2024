import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.Map;

/**
 * @brief Class responsible for setting up the Paint application GUI.
 *
 * This class constructs the graphical user interface (GUI) for the Paint application.
 * It creates and configures various UI components such as the canvas, color picker, menu, and option palette.
 */
public class PaintGUI {

    /**
     * @brief Constructor for the PaintGUI class.
     *
     * Initializes the GUI components, sets up event handling, and displays the GUI.
     *
     * @param stage The primary stage for the application.
     * @param handledObjects A map of drawable object suppliers for instantiating drawable objects.
     */
    public PaintGUI(Stage stage, Map<String, DrawableObjectSupplier> handledObjects) {
        // Create the root BorderPane
        BorderPane root = new BorderPane();

        // Instantiate the DrawableObjectInstantiator and DrawableObjectDataLoader
        DrawableObjectInstantiator instantiator = new DrawableObjectInstantiator(handledObjects);
        DrawableObjectDataLoader loader = new DrawableObjectDataLoader();

        // Create the color picker with an initial color (RED)
        ColorPicker colorPicker = new ColorPicker(Color.RED);

        // Create the canvas, selector, drawer, and controller
        Canvas canvas = new Canvas();
        Selector selector = new Selector();
        Drawer drawer = new Drawer(instantiator, canvas, colorPicker);
        Controller controller = new Controller(root, canvas, selector, drawer, colorPicker);

        // Create the option palette and add drawing buttons for each handled object type
        OptionPalette optionPalette = new OptionPalette();
        optionPalette.add(new SelectButton("icons/select.png", controller));
        for (String type : handledObjects.keySet()) {
            optionPalette.add(new DrawingButton("icons/" + type + ".png", type, drawer, controller, selector));
        }

        // Create the top panel containing the menu and edit panel
        VBox topPanel = new VBox();
        GridPane editPanel = new GridPane();
        editPanel.add(optionPalette, 0, 0);
        editPanel.add(colorPicker, 1, 0);

        // Set Hgrow to make the option palette fill the available horizontal space
        GridPane.setHgrow(optionPalette, Priority.ALWAYS);

        // Create and configure the main menu
        MainMenu menu = new MainMenu(stage, loader, instantiator, canvas);

        // Add the menu and edit panel to the top panel
        topPanel.getChildren().addAll(menu, editPanel);

        // Set the top panel and canvas to the root BorderPane
        root.setTop(topPanel);
        root.setCenter(canvas);

        // Create the scene and set it to the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // Set stage title and display the stage
        stage.setTitle("Paint");
        stage.show();
    }
}
