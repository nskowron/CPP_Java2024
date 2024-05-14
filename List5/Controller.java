import javafx.event.*;

import java.util.logging.Level;

public class Controller
{
    private Mode mode;
    private Canvas canvas;
    private EventHandler<Event> filter;

    public Controller(Canvas canvas, Drawer drawer)
    {
        this.canvas = canvas;
        filter = e -> {};

        Mode.setDrawer(drawer);
        this.setMode(Mode.SELECT);
    }

    public void setMode(Mode newMode)
    {
        canvas.removeEventFilter(EventType.ROOT, filter);

        mode = newMode;
        filter = mode.getEventFilter();
        canvas.addEventFilter(EventType.ROOT, filter);
    }
}
