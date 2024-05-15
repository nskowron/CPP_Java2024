import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public interface Controllable
{
    public void setOnMousePressed(EventHandler<? super MouseEvent> handler);
}
