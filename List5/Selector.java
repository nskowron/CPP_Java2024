import javafx.scene.paint.Color;

import java.util.logging.Level;

/**
 * @brief A class for managing the selection of objects on the canvas.
 *
 * This class provides functionality for selecting and unselecting drawable objects on the canvas.
 */
public class Selector {

    private Drawable selectedObject;

    /**
     * @brief Constructs a new Selector object.
     *
     * Initializes the selectedObject to null.
     */
    public Selector() {
        selectedObject = null;
    }

    /**
     * @brief Gets the currently selected drawable object.
     *
     * @return The currently selected drawable object, or null if no object is selected.
     */
    public Drawable getSelected() {
        return selectedObject;
    }

    /**
     * @brief Selects the specified drawable object.
     *
     * Selects the specified drawable object and visually indicates the selection by changing its stroke color
     * and width.
     *
     * @param object The drawable object to select.
     */
    public void select(Drawable object) {
        this.unselect();

        object.redraw();

        object.setStroke(new Color(0.259, 0.576, 0.961, 1.0));
        object.setStrokeWidth(2);

        PaintLogger.logger.log(Level.INFO, "Selecting");
        selectedObject = object;
    }

    /**
     * @brief Unselects the currently selected drawable object.
     *
     * If there is a selected object, this method removes the visual indication of selection
     * by resetting its stroke color and width, and sets the selected object to null.
     */
    public void unselect() {
        PaintLogger.logger.log(Level.INFO, "Unselecting");
        if (selectedObject != null) {
            selectedObject.setStroke(selectedObject.getFill());
            selectedObject.setStrokeWidth(0);

            selectedObject = null;
        }
    }
}
