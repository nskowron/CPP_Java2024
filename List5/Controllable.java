import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Represents an interface for objects that can be controlled with mouse events.
 */
public interface Controllable {

    /**
     * Sets the event handler for mouse pressed event.
     * @param handler The event handler for mouse pressed event.
     * @brief Sets the event handler for mouse pressed event.
     */
    public void setOnMousePressed(EventHandler<? super MouseEvent> handler);
}
