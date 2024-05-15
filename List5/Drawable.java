/**
 * Represents an interface for drawable objects.
 * Extends Transformable, Colorable, and Controllable interfaces.
 */
public interface Drawable extends Transformable, Colorable, Controllable {

    /**
     * Draws the drawable object on the canvas.
     * @param canvas The canvas on which to draw the object.
     * @brief Draws the drawable object on the canvas.
     */
    public void draw(Canvas canvas);

    /**
     * Redraws the drawable object.
     * @brief Redraws the drawable object.
     */
    public void redraw();

    /**
     * Deletes the drawable object.
     * @brief Deletes the drawable object.
     */
    public void delete();

    /**
     * Gets the data associated with the drawable object.
     * @return The data associated with the drawable object.
     * @brief Gets the data associated with the drawable object.
     */
    public DrawableObjectData getData();
}
