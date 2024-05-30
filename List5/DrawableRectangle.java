import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;

/**
 * Represents a drawable rectangle shape.
 * Extends Polygon and implements Drawable interface.
 */
public class DrawableRectangle extends Polygon implements Drawable {

    // Original width and height of the rectangle
    private final double originalWidth;
    private final double originalHeight;

    // Reference to the canvas on which the rectangle is drawn
    private Canvas canvas;

    /**
     * Constructs a new DrawableRectangle object with the specified width and height.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     * @brief Constructs a new DrawableRectangle object with the specified dimensions.
     */
    public DrawableRectangle(double width, double height) {
        super(-width * 0.5, -height * 0.5, -width * 0.5, height * 0.5, width * 0.5, height * 0.5, width * 0.5, -height * 0.5);

        // Initialize original width and height based on the provided dimensions
        originalWidth = width;
        originalHeight = height;

        // Initialize canvas reference to null
        canvas = null;
    }

    /**
     * Gets the data associated with the drawable rectangle.
     * @return The data associated with the drawable rectangle.
     * @brief Gets the data associated with the drawable rectangle.
     */
    public DrawableObjectData getData() {
        // Create a new DrawableObjectData instance with rectangle properties
        DrawableObjectData data = new DrawableObjectData("Rectangle", originalWidth, originalHeight);
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
     * Draws the rectangle on the specified canvas.
     * @param canvas The canvas on which to draw the rectangle.
     * @brief Draws the rectangle on the specified canvas.
     */
    public void draw(Canvas canvas) {
        this.canvas = canvas;
        canvas.add(this);
    }

    /**
     * Redraws the rectangle on the canvas.
     * @brief Redraws the rectangle on the canvas.
     */
    public void redraw() {
        if(canvas != null) {
            canvas.remove(this);
            canvas.add(this);
        }
    }

    /**
     * Deletes the rectangle from the canvas.
     * @brief Deletes the rectangle from the canvas.
     */
    public void delete() {
        if(canvas != null) {
            canvas.remove(this);
            canvas = null;
        }
    }

    /**
     * Gets the width of the rectangle.
     * @return The width of the rectangle.
     * @brief Gets the width of the rectangle.
     */
    public double getWidth() {
        return originalWidth * getScaleX();
    }

    /**
     * Gets the height of the rectangle.
     * @return The height of the rectangle.
     * @brief Gets the height of the rectangle.
     */
    public double getHeight() {
        return originalHeight * getScaleY();
    }

    /**
     * Sets the width of the rectangle.
     * @param newWidth The new width to be set.
     * @throws IllegalArgumentException if the original width is zero and the new width is non-zero.
     * @brief Sets the width of the rectangle.
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
     * Sets the height of the rectangle.
     * @param newHeight The new height to be set.
     * @throws IllegalArgumentException if the original height is zero and the new height is non-zero.
     * @brief Sets the height of the rectangle.
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
