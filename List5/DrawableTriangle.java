import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;

/**
 * Represents a drawable triangle shape.
 * Extends Polygon and implements Drawable interface.
 */
public class DrawableTriangle extends Polygon implements Drawable {

    // Original width and height of the triangle
    private final double originalWidth;
    private final double originalHeight;

    // Reference to the canvas on which the triangle is drawn
    private Canvas canvas;

    /**
     * Constructs a new DrawableTriangle object with the specified coordinates.
     * @param x1 X-coordinate of the first vertex.
     * @param y1 Y-coordinate of the first vertex.
     * @param x2 X-coordinate of the second vertex.
     * @param y2 Y-coordinate of the second vertex.
     * @param x3 X-coordinate of the third vertex.
     * @param y3 Y-coordinate of the third vertex.
     * @brief Constructs a new DrawableTriangle object with the specified vertex coordinates.
     */
    public DrawableTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        super(x1, y1, x2, y2, x3, y3);

        // Calculate original width and height based on vertex coordinates
        originalWidth = Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
        originalHeight = Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3));

        // Initialize canvas reference to null
        canvas = null;
    }

    /**
     * Gets the data associated with the drawable triangle.
     * @return The data associated with the drawable triangle.
     * @brief Gets the data associated with the drawable triangle.
     */
    public DrawableObjectData getData() {
        // Create a new DrawableObjectData instance with triangle properties
        DrawableObjectData data = new DrawableObjectData("Triangle", originalWidth, originalHeight);
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
     * Draws the triangle on the specified canvas.
     * @param canvas The canvas on which to draw the triangle.
     * @brief Draws the triangle on the specified canvas.
     */
    public void draw(Canvas canvas) {
        this.canvas = canvas;
        canvas.add(this);
    }

    /**
     * Redraws the triangle on the canvas.
     * @brief Redraws the triangle on the canvas.
     */
    public void redraw() {
        if(canvas != null) {
            canvas.remove(this);
            canvas.add(this);
        }
    }

    /**
     * Deletes the triangle from the canvas.
     * @brief Deletes the triangle from the canvas.
     */
    public void delete() {
        if(canvas != null) {
            canvas.remove(this);
            canvas = null;
        }
    }

    /**
     * Gets the width of the triangle.
     * @return The width of the triangle.
     * @brief Gets the width of the triangle.
     */
    public double getWidth() {
        return originalWidth * getScaleX();
    }

    /**
     * Gets the height of the triangle.
     * @return The height of the triangle.
     * @brief Gets the height of the triangle.
     */
    public double getHeight() {
        return originalHeight * getScaleY();
    }

    /**
     * Sets the width of the triangle.
     * @param newWidth The new width to be set.
     * @throws IllegalArgumentException if the original width is zero and the new width is non-zero.
     * @brief Sets the width of the triangle.
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
     * Sets the height of the triangle.
     * @param newHeight The new height to be set.
     * @throws IllegalArgumentException if the original height is zero and the new height is non-zero.
     * @brief Sets the height of the triangle.
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
