import javafx.scene.paint.Paint;

/**
 * Represents an interface for objects that can be colored.
 */
public interface Colorable {

    /**
     * Gets the fill color of the object.
     * @return The fill color of the object.
     * @brief Gets the fill color of the object.
     */
    public Paint getFill();

    /**
     * Gets the stroke color of the object.
     * @return The stroke color of the object.
     * @brief Gets the stroke color of the object.
     */
    public Paint getStroke();

    /**
     * Gets the stroke width of the object.
     * @return The stroke width of the object.
     * @brief Gets the stroke width of the object.
     */
    public double getStrokeWidth();


    /**
     * Sets the fill color of the object.
     * @param paint The fill color to be set.
     * @brief Sets the fill color of the object.
     */
    public void setFill(Paint paint);

    /**
     * Sets the stroke color of the object.
     * @param paint The stroke color to be set.
     * @brief Sets the stroke color of the object.
     */
    public void setStroke(Paint paint);

    /**
     * Sets the stroke width of the object.
     * @param width The stroke width to be set.
     * @brief Sets the stroke width of the object.
     */
    public void setStrokeWidth(double width);
}
