import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.logging.Level;

/**
 * @brief Button for selecting objects on the canvas.
 *
 * This class represents a button that, when clicked, sets the mode of the controller to SELECT,
 * allowing users to select objects on the canvas.
 */
public class SelectButton extends OptionButton {

    /**
     * @brief Constructs a SelectButton with the specified icon path and controller.
     *
     * This constructor creates a SelectButton with the specified icon path and sets up its action event
     * handler to set the mode of the controller to SELECT when clicked.
     *
     * @param pathToIcon The path to the icon image for the button.
     * @param controller The controller managing the canvas and object selection.
     */
    public SelectButton(final String pathToIcon, Controller controller) {
        super(pathToIcon);

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                PaintLogger.logger.log(Level.INFO, "Select button clicked");

                controller.setMode(Mode.SELECT);
            }
        });
    }
}
