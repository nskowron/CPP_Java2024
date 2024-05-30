import javafx.scene.control.ColorPicker;

/**
 * Represents a button used for filling a drawable object with a selected color.
 */
public class FillButton extends PopupEditButton {

    /**
     * Constructs a new FillButton with the specified parameters.
     * @param object The drawable object to be filled.
     * @param colorPicker The color picker for selecting fill color.
     * @brief Constructs a new FillButton with the specified parameters.
     */
    public FillButton(Drawable object, ColorPicker colorPicker) {
        super("fill");

        // Set action event handler for the button
        setOnAction(event -> {
            // Set the fill color of the drawable object to the value selected from the color picker
            object.setFill(colorPicker.getValue());
        });
    }
}
