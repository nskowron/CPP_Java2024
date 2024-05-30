import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;

/**
 * Represents a drawable ellipse shape.
 * Extends Ellipse and implements Drawable interface.
 */
public class DrawableEllipse extends Ellipse implements Drawable {

    // Original width and height of the ellipse
    private final double originalWidth;
    private final double originalHeight;

    // Reference to the canvas on which the ellipse is drawn
    private Canvas canvas;

    /**
     * Constructs a new DrawableEllipse object with the specified radiusX and radiusY.
     * @param radiusX The radius of the ellipse along the x-axis.
     * @param radiusY The radius of the ellipse along the y-axis.
     * @brief Constructs a new DrawableEllipse object with the specified dimensions.
     */
    public DrawableEllipse(double radiusX, double radiusY) {
        super(0, 0, radiusX, radiusY);

        // Initialize original width and height based on the provided radius
        originalWidth = 2 * radiusX;
        originalHeight = 2 * radiusY;

        canvas = null; // Initialize canvas reference to null
    }

    /**
     * Gets the data associated with the drawable ellipse.
     * @return The data associated with the drawable ellipse.
     * @brief Gets the data associated with the drawable ellipse.
     */
    public DrawableObjectData getData() {
        // Create a new DrawableObjectData instance with ellipse properties
        DrawableObjectData data = new DrawableObjectData("Ellipse", originalWidth, originalHeight);
        data.translateX = getTranslateX();
        data.translateY = getTranslateY();
        data.scaleX = getScaleX();
        data.scaleY = getScaleY();
        data.angle = getRotate();
        
        // Get fill color information if available
        try {
            Color fill = (Color)getFill();
            data.fillR = fill.getRed();
            data.fillG = fill.getGreen();
            data.fillB = fill.getBlue();
            data.fillA = fill.getOpacity();
        } catch(ClassCastException e) {
            // Ignore non-color fills
        }

        return data;
    }

    /**
     * Draws the ellipse on the specified canvas.
     * @param canvas The canvas on which to draw the ellipse.
     * @brief Draws the ellipse on the canvas.
     */
    public void draw(Canvas canvas) {
        this.canvas = canvas;
        canvas.add(this);
    }

    /**
     * Redraws the ellipse on the canvas.
     * @brief Redraws the ellipse on the canvas.
     */
    public void redraw() {
        if(canvas != null) {
            canvas.remove(this);
            canvas.add(this);
        }
    }

    /**
     * Deletes the ellipse from the canvas.
     * @brief Deletes the ellipse from the canvas.
     */
    public void delete() {
        if(canvas != null); {
            canvas.remove(this);
            canvas = null;
        }
    }

    /**
     * Gets the width of the ellipse.
     * @return The width of the ellipse.
     * @brief Gets the width of the ellipse.
     */
    public double getWidth() {
        return originalWidth * getScaleX();
    }

    /**
     * Gets the height of the ellipse.
     * @return The height of the ellipse.
     * @brief Gets the height of the ellipse.
     */
    public double getHeight() {
        return originalHeight * getScaleY();
    }

    /**
     * Sets the width of the ellipse.
     * @param newWidth The new width to be set.
     * @throws IllegalArgumentException if the original width is zero and the new width is non-zero.
     * @brief Sets the width of the ellipse.
     */
    public void setWidth(double newWidth) throws IllegalArgumentException {
        if(originalWidth == 0 && newWidth != 0) {
            throw new IllegalArgumentException("Cannot change width of a 1D object");
        }
        if(originalWidth != 0) {
            setScaleX(newWidth / originalWidth);
        }
    }

    /**
     * Sets the height of the ellipse.
     * @param newHeight The new height to be set.
     * @throws IllegalArgumentException if the original height is zero and the new height is non-zero.
     * @brief Sets the height of the ellipse.
     */
    public void setHeight(double newHeight) throws IllegalArgumentException {
        if(originalHeight == 0 && newHeight != 0) {
            throw new IllegalArgumentException("Cannot change height of a 1D object");
        }
        if(originalHeight != 0) {
            setScaleY(newHeight / originalHeight);
        }
    }
}
