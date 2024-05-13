import javafx.event.*;

public class State
{
    private Mode mode;
    private Canvas canvas;
    private EventHandler<Event> filter;

    public State(Canvas canvas)
    {
        this.canvas = canvas;
        filter = null;
        this.setMode(Mode.IDLE);
    }

    public void setMode(Mode newMode)
    {
        mode = newMode;
        canvas.removeEventFilter(EventType.ROOT, filter);
        filter = mode.getEventFilter();
        canvas.addEventFilter(EventType.ROOT, filter);
    }
}
