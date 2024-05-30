import javafx.event.*;
import javafx.scene.input.MouseEvent;

import java.util.logging.Level;

// @brief Enum to represent different modes of the application
public enum Mode {

    SELECT() {
        // For SELECT mode, no event filtering is required
        @Override
        public EventHandler<Event> getEventFilter() {
            return event -> {}; // Empty event filter
        }
    },
    
    DRAW() {
        // For DRAW mode, handle mouse events to draw shapes
        @Override
        public EventHandler<Event> getEventFilter() throws IllegalStateException {
            // Check if the drawer has been set
            if (drawer == null) {
                throw new IllegalStateException("Drawer has not been set");
            }

            // Event handler for DRAW mode
            return new EventHandler<Event>() {
                private Drawable drawnShape;

                @Override
                public void handle(Event event) {
                    // Handle MOUSE_PRESSED event
                    if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                        event.consume();
                        MouseEvent me = (MouseEvent) event;

                        // If left mouse button pressed, start drawing
                        if (me.isPrimaryButtonDown()) {
                            PaintLogger.logger.log(Level.INFO, "Started drawing");

                            // Draw the shape at the mouse position
                            drawnShape = drawer.draw(me.getX(), me.getY());
                        }
                    }
                    // Handle MOUSE_DRAGGED event
                    else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                        MouseEvent me = (MouseEvent) event;
                        if (me.isPrimaryButtonDown()) {
                            event.consume();

                            // Resize the shape as the mouse is dragged
                            drawnShape.setWidth(2 * (me.getX() - drawnShape.getTranslateX()));
                            drawnShape.setHeight(2 * (me.getY() - drawnShape.getTranslateY()));
                        }
                    }
                }
            };
        }
    };

    // Reference to the drawer for drawing shapes
    protected static Drawer drawer;

    // Abstract method to get the event filter for each mode
    // @brief Get the event filter for each mode
    public abstract EventHandler<Event> getEventFilter();

    // Method to set the drawer
    // @brief Set the drawer for drawing shapes
    public static void setDrawer(Drawer newDrawer) {
        drawer = newDrawer;
    }
}
