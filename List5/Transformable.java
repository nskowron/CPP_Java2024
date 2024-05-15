/**
 * @brief An interface for objects that can be transformed in a 2D space.
 *
 * This interface defines methods for getting and setting translation, width, height, and rotation
 * properties of objects in a 2D space.
 */
public interface Transformable {

    /**
     * @brief Gets the X-coordinate translation of the object.
     *
     * @return The X-coordinate translation of the object.
     */
    public double getTranslateX();

    /**
     * @brief Gets the Y-coordinate translation of the object.
     *
     * @return The Y-coordinate translation of the object.
     */
    public double getTranslateY();

    /**
     * @brief Gets the width of the object.
     *
     * @return The width of the object.
     */
    public double getWidth();

    /**
     * @brief Gets the height of the object.
     *
     * @return The height of the object.
     */
    public double getHeight();

    /**
     * @brief Gets the rotation angle of the object.
     *
     * @return The rotation angle of the object.
     */
    public double getRotate();


    /**
     * @brief Sets the X-coordinate translation of the object.
     *
     * @param x The new X-coordinate translation of the object.
     */
    public void setTranslateX(double x);

    /**
     * @brief Sets the Y-coordinate translation of the object.
     *
     * @param y The new Y-coordinate translation of the object.
     */
    public void setTranslateY(double y);

    /**
     * @brief Sets the width of the object.
     *
     * @param width The new width of the object.
     */
    public void setWidth(double width);

    /**
     * @brief Sets the height of the object.
     *
     * @param height The new height of the object.
     */
    public void setHeight(double height);

    /**
     * @brief Sets the rotation angle of the object.
     *
     * @param angle The new rotation angle of the object.
     */
    public void setRotate(double angle);
}
