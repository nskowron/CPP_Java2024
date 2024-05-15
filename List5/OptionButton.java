import javafx.scene.control.Button;
import javafx.scene.image.*;

/**
 * @brief Abstract class for creating buttons with icons.
 * 
 * This class provides a template for creating buttons with icons. 
 */
public abstract class OptionButton extends Button {

    /**
     * @brief Constructor for OptionButton.
     * 
     * Constructs an OptionButton with the provided path to the icon.
     * 
     * @param pathToIcon The path to the icon image.
     */
    public OptionButton(final String pathToIcon) {
        double x = 30; // Width of the button
        double y = 25; // Height of the button

        try {
            // Load the icon image from the provided path
            Image icon = new Image(getClass().getResourceAsStream(pathToIcon));
            ImageView iconView = new ImageView(icon);
            // Set the dimensions of the icon
            iconView.setFitWidth(x);
            iconView.setFitHeight(y);

            // Set the icon as the graphic content of the button
            this.setGraphic(iconView);
        } catch (NullPointerException | IllegalArgumentException e) {
            // If the icon image cannot be loaded, display an error message and set the text of the button to the path
            this.setText(pathToIcon);
            ErrorHandler.showError("Icon not found", "Icon " + pathToIcon + " required by OptionButton has not been found");
        }

        // Set the minimum, maximum, and preferred dimensions of the button
        setMinHeight(y);
        setMinWidth(x);
        setMaxHeight(y);
        setMaxWidth(x);
        setHeight(y);
        setWidth(x);
    }
}
