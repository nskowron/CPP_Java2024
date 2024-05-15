import javafx.event.*;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Controls interaction between the canvas and UI elements.
 */
public class Controller {

    // Current mode of the controller
    private Mode mode;

    // Reference to the canvas
    private Canvas canvas;

    // Event filter for the canvas
    private EventHandler<Event> filter;

    // Reference to the drawable object primarily clicked
    private Drawable primarilyClicked;

    /**
     * Constructs a new Controller object.
     * @param root The root pane of the application.
     * @param canvas The canvas where drawing occurs.
     * @param selector The selector for selecting objects on the canvas.
     * @param drawer The drawer for drawing objects on the canvas.
     * @param colorPicker The color picker for selecting colors.
     * @brief Constructs a new Controller object to manage interactions between canvas and UI elements.
     */
    public Controller(Pane root, Canvas canvas, Selector selector, Drawer drawer, ColorPicker colorPicker) {
        filter = e -> {};

        // Set drawer for the drawing mode
        Mode.setDrawer(drawer);
        this.canvas = canvas;
        canvas.addController(this);

        // Set default mode to SELECT
        this.setMode(Mode.SELECT);

        // Handle mouse drag events for moving selected objects
        canvas.setOnMouseDragged(me -> {
            if(me.isPrimaryButtonDown() && selector.getSelected() != null) {
                selector.getSelected().setTranslateX(me.getX());
                selector.getSelected().setTranslateY(me.getY());
            }
        });

        // Handle mouse press events for object selection and editing
        canvas.setOnMousePressed(me -> {
            if(primarilyClicked != null) {
                selector.select(primarilyClicked);

                if(me.isSecondaryButtonDown()) {
                    // Create edit menu for the primarily clicked object
                    Button editMenuButtons[] = {new FillButton(primarilyClicked, colorPicker), new DeleteButton(primarilyClicked)};
                    PopupEditMenu editMenu = new PopupEditMenu(me.getX(), me.getY(), editMenuButtons);

                    // Add edit menu to the root pane
                    root.getChildren().add(editMenu);

                    // Close edit menu on root mouse press
                    root.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent me) {
                            root.getChildren().remove(editMenu);
                            root.removeEventFilter(MouseEvent.MOUSE_PRESSED, this);
                        }
                    });
                }
            } else {
                selector.unselect();
            }
        });

        // Handle mouse release events
        canvas.setOnMouseReleased(me -> {
            primarilyClicked = null;
        });

        // Handle mouse scroll events for object rotation and scaling
        canvas.setOnScroll(se -> {
            Drawable selected = selector.getSelected();
            if(selected != null) {
                if(se.isControlDown()) {
                    selected.setRotate(selected.getRotate() + (Math.PI * 0.05 * se.getDeltaY()));
                } else {
                    selected.setWidth(selected.getWidth() * (1 + 0.003 * se.getDeltaY()));
                    selected.setHeight(selected.getHeight() * (1 + 0.003 * se.getDeltaY()));
                }
            }
        });
    }

    /**
     * Sets the mode of the controller.
     * @param newMode The new mode to be set.
     * @brief Sets the mode of the controller.
     */
    public void setMode(Mode newMode) {
        // Remove existing event filter
        canvas.removeEventFilter(EventType.ROOT, filter);

        // Set new mode and event filter
        mode = newMode;
        filter = mode.getEventFilter();
        canvas.addEventFilter(EventType.ROOT, filter);
    }

    /**
     * Adds a controllable object to the canvas.
     * @param object The controllable object to be added.
     * @brief Adds a controllable object to the canvas.
     */
    public void addControllable(Drawable object) {
        // Set mouse press event handler for object
        object.setOnMousePressed(me -> {
            if(primarilyClicked == null) {
                primarilyClicked = object;
            }
        });
    }

    /**
     * Removes a controllable object from the canvas.
     * @param object The controllable object to be removed.
     * @brief Removes a controllable object from the canvas.
     */
    public void removeControllable(Drawable object) {
        // Remove mouse press event handler for object
        object.setOnMousePressed(null);
    }
}
