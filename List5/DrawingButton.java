import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.logging.Level;

/**
 * Represents a button used for selecting a drawing tool.
 */
public class DrawingButton extends OptionButton {

    /**
     * Constructs a new DrawingButton with the specified parameters.
     * @param pathToIcon The path to the icon for the button.
     * @param type The type of shape to be drawn.
     * @param drawer The drawer used for drawing shapes.
     * @param controller The controller for managing the application's mode.
     * @param selector The selector for selecting objects on the canvas.
     * @brief Constructs a new DrawingButton.
     */
    public DrawingButton(final String pathToIcon, final String type, Drawer drawer, Controller controller, Selector selector) {
        super(pathToIcon);
        
        // Set action event handler for the button
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                // Log button click event
                PaintLogger.logger.log(Level.INFO, "Drawing button clicked");

                // Unselect any currently selected object
                selector.unselect();
                
                // Set the type of shape to be drawn
                drawer.setType(type);
                
                // Set the application mode to drawing mode
                controller.setMode(Mode.DRAW);
            }
        });
    }
}
