import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public interface ResizeEventHandler extends EventHandler<MouseEvent>
{
    public void SetOriginalWidth(double width);
    public void SetOriginalHeight(double height);
}
