import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

/**
 * @brief Represents a popup edit menu containing buttons.
 *
 * This class extends the JavaFX VBox layout to create a popup edit menu that contains a set of buttons.
 */
public class PopupEditMenu extends VBox {

    /**
     * @brief Constructs a new PopupEditMenu at the specified position with the given buttons.
     *
     * This constructor initializes the popup edit menu with the provided position coordinates and an array of buttons.
     *
     * @param x       The x-coordinate position of the popup edit menu.
     * @param y       The y-coordinate position of the popup edit menu.
     * @param buttons An array of Button objects to be added to the popup edit menu.
     */
    public PopupEditMenu(double x, double y, Button[] buttons) {
        setLayoutX(x); // Set the x-coordinate position of the popup edit menu
        setLayoutY(y); // Set the y-coordinate position of the popup edit menu

        for (Button button : buttons) {
            getChildren().add(button); // Add each button to the popup edit menu
        }
    }
}
