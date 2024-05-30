import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * Represents a canvas for drawing objects in a JavaFX application.
 */
public class Canvas extends Pane implements Serializable {

    // List to hold drawable objects on the canvas
    private List<Drawable> objects;
    
    // Reference to the controller associated with the canvas
    private Controller controller;

    /**
     * Constructs a new Canvas object.
     * Initializes the list of objects and sets the minimum size of the canvas.
     * @brief Initializes a new Canvas object with a list of objects and sets the minimum size.
     */
    public Canvas() {
        objects = new ArrayList<>(0);
        setMinSize(400, 300); // Set minimum size for the canvas
    }

    /**
     * Associates a controller with the canvas.
     * @param controller The controller to be associated with the canvas.
     * @brief Associates a controller with the canvas.
     */
    public void addController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Adds a drawable object to the canvas.
     * If the object is an instance of Node, it's also added to the canvas's children.
     * @param object The drawable object to be added to the canvas.
     * @brief Adds a drawable object to the canvas and to the controller if it's a Node.
     */
    public void add(Drawable object) {
        // Add the object to the list of objects
        objects.add(object);
        
        // Add the object to the controller for management
        controller.addControllable(object);
        
        // If the object is a JavaFX Node, add it to the canvas's children
        if(object instanceof Node) {
            getChildren().add((Node)object);
        }
    }

    /**
     * Removes a drawable object from the canvas.
     * If the object is an instance of Node, it's also removed from the canvas's children.
     * @param object The drawable object to be removed from the canvas.
     * @brief Removes a drawable object from the canvas and from the controller if it's a Node.
     */
    public void remove(Drawable object) {
        // If the object is a JavaFX Node, remove it from the canvas's children
        if(object instanceof Node) {
            getChildren().remove((Node)object);
        }
        
        // Remove the object from the controller
        controller.removeControllable(object);
        
        // Remove the object from the list of objects
        objects.remove(object);
    }

    /**
     * Returns the list of drawable objects on the canvas.
     * @return The list of drawable objects currently on the canvas.
     * @brief Returns the list of drawable objects on the canvas.
     */
    public List<Drawable> getObjects() {
        return objects;
    }
}
