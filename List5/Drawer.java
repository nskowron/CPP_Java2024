import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import java.util.logging.Level;

/**
 * Draws shapes on a canvas.
 */
public class Drawer {

    // Instantiator for creating Drawable objects
    private DrawableObjectInstantiator instantiator;

    // Type of shape to be drawn
    private String type;

    // Canvas to draw shapes on
    private Canvas canvas;

    // Color picker for selecting fill color
    private ColorPicker colorPicker;
    
    /**
     * Constructs a new Drawer with the specified parameters.
     * @param instantiator The instantiator for creating Drawable objects.
     * @param canvas The canvas to draw shapes on.
     * @param colorPicker The color picker for selecting fill color.
     * @brief Constructs a new Drawer.
     */
    public Drawer(DrawableObjectInstantiator instantiator, Canvas canvas, ColorPicker colorPicker) {
        this.instantiator = instantiator;
        this.canvas = canvas;
        this.colorPicker = colorPicker;
        type = null;
    }

    /**
     * Draws a shape at the specified coordinates.
     * @param x The x-coordinate of the shape.
     * @param y The y-coordinate of the shape.
     * @return The drawn Drawable object.
     * @brief Draws a shape at the specified coordinates.
     */
    public Drawable draw(double x, double y) {
        // Create DrawableObjectData for the shape
        DrawableObjectData data = new DrawableObjectData(type, 100, 100);
        data.translateX = x;
        data.translateY = y;
        data.scaleX = 0;
        data.scaleY = 0;
        data.angle = 0;

        // Get fill color from the color picker
        Color color = colorPicker.getValue();
        data.fillR = color.getRed();
        data.fillG = color.getGreen();
        data.fillB = color.getBlue();
        data.fillA = color.getOpacity();

        // Instantiate a Drawable object and draw it on the canvas
        Drawable drawnObject = instantiator.instantiate(data);
        drawnObject.draw(canvas);

        // Log the drawing operation
        PaintLogger.logger.log(Level.INFO, "Drawn shape at " + drawnObject.getTranslateX() + ", " + drawnObject.getTranslateY());

        return drawnObject;
    }

    /**
     * Sets the type of shape to be drawn.
     * @param type The type of shape.
     * @throws IllegalArgumentException if the specified type is not valid.
     * @brief Sets the type of shape to be drawn.
     */
    public void setType(String type) throws IllegalArgumentException {
        try {
            // Attempt to instantiate a Drawable object with the specified type
            instantiator.instantiate(new DrawableObjectData(type, 0, 0));
        } catch(IllegalArgumentException e) {
            // Throw an exception if the type is not valid
            throw new IllegalArgumentException("Could not draw type " + type);
        }
        
        this.type = type;
    }
}
