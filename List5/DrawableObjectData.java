import java.io.Serializable;

/**
 * Represents data associated with a drawable object.
 * Implements Serializable for object serialization.
 */
public class DrawableObjectData implements Serializable {

    // Type of the drawable object
    public final String type;

    // Width and height of the drawable object
    public final double width;
    public final double height;

    // Translation properties
    public double translateX;
    public double translateY;

    // Scaling properties
    public double scaleX;
    public double scaleY;

    // Rotation angle
    public double angle;

    // Fill color components
    public double fillR;
    public double fillG;
    public double fillB;
    public double fillA;

    /**
     * Constructs a new DrawableObjectData object with the specified type, width, and height.
     * @param type The type of the drawable object.
     * @param width The width of the drawable object.
     * @param height The height of the drawable object.
     * @brief Constructs a new DrawableObjectData object with the specified parameters.
     */
    public DrawableObjectData(final String type, final double width, final double height) {
        this.type = type;
        this.width = width;
        this.height = height;
    }
}
