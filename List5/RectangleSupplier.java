import javafx.scene.paint.Color;

/**
 * @brief Supplies instances of DrawableRectangle objects.
 *
 * This class implements the DrawableObjectSupplier interface to provide instances of DrawableRectangle objects
 * based on the provided DrawableObjectData.
 */
public class RectangleSupplier implements DrawableObjectSupplier {

    /**
     * @brief Gets a DrawableRectangle object based on the provided data.
     *
     * This method creates and configures a DrawableRectangle object based on the provided DrawableObjectData.
     *
     * @param data The DrawableObjectData containing information to configure the DrawableRectangle.
     * @return A DrawableRectangle object configured based on the provided data.
     * @throws IllegalArgumentException if the type of Drawable object in the data is not "Rectangle".
     */
    public Drawable get(DrawableObjectData data) throws IllegalArgumentException {
        if (!data.type.equals("Rectangle")) {
            throw new IllegalArgumentException("Wrong type of Drawable object, expected Rectangle, got " + data.type);
        }

        Drawable rectangle = new DrawableRectangle(data.width, data.height);
        rectangle.setTranslateX(data.translateX);
        rectangle.setTranslateY(data.translateY);
        rectangle.setWidth(data.width * data.scaleX);
        rectangle.setHeight(data.height * data.scaleY);
        rectangle.setRotate(data.angle);
        rectangle.setFill(new Color(data.fillR, data.fillG, data.fillB, data.fillA));
        rectangle.setStroke(rectangle.getFill());
        rectangle.setStrokeWidth(0);
        return rectangle;
    }
}
