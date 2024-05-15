import javafx.scene.paint.Color;

/**
 * Supplier for creating ellipses based on DrawableObjectData.
 */
public class EllipseSupplier implements DrawableObjectSupplier {

    /**
     * Creates an ellipse based on the specified DrawableObjectData.
     * @param data The data used to create the ellipse.
     * @return The created ellipse.
     * @throws IllegalArgumentException if the specified data type is not "Ellipse".
     * @brief Creates an ellipse based on the provided data.
     */
    public Drawable get(DrawableObjectData data) throws IllegalArgumentException {
        // Check if the data type matches "Ellipse"
        if(!data.type.equals("Ellipse")) {
            throw new IllegalArgumentException("Wrong type of Drawable object, expected Ellipse, got " + data.type);
        }

        // Create a new DrawableEllipse with half the specified width and height
        Drawable ellipse = new DrawableEllipse(data.width / 2.0, data.height / 2.0);

        // Set translation, scale, rotation, fill color, and stroke properties
        ellipse.setTranslateX(data.translateX);
        ellipse.setTranslateY(data.translateY);
        ellipse.setWidth(data.width * data.scaleX);
        ellipse.setHeight(data.height * data.scaleY);
        ellipse.setRotate(data.angle);
        ellipse.setFill(new Color(data.fillR, data.fillG, data.fillB, data.fillA));
        ellipse.setStroke(ellipse.getFill());
        ellipse.setStrokeWidth(0);

        return ellipse;
    }
}
