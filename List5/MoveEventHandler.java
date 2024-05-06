import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public interface MoveEventHandler extends EventHandler<MouseEvent>
{
    public void SetOriginalX(double x);
    public void SetOriginalY(double y);
}
