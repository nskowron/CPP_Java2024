import javafx.scene.control.Button;

/**
 * @brief Represents a button used in a popup edit menu.
 *
 * This class extends the JavaFX Button class to provide a customized button for use in popup edit menus.
 */
public class PopupEditButton extends Button {

    /**
     * @brief Constructs a new PopupEditButton with the specified name.
     *
     * This constructor initializes the button with the given name and sets its dimensions.
     *
     * @param name The name or label of the button.
     */
    public PopupEditButton(String name) {
        super(name);

        double x = 80; // Default width for the button
        double y = 25; // Default height for the button

        setMinHeight(y); // Set the minimum height of the button
        setMinWidth(x); // Set the minimum width of the button
        setMaxHeight(y); // Set the maximum height of the button
        setMaxWidth(x); // Set the maximum width of the button

        setHeight(y); // Set the height of the button
        setWidth(x); // Set the width of the button
    }
}
