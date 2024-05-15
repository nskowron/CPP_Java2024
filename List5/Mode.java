import javafx.event.*;
import javafx.scene.input.MouseEvent;

import java.util.logging.Level;

public enum Mode
{
    SELECT()
    {
        @Override
        public EventHandler<Event> getEventFilter()
        {
            return event -> {};
        }
    },
    DRAW()
    {
        @Override
        public EventHandler<Event> getEventFilter() throws IllegalStateException
        {
            if(drawer == null)
            {
                throw new IllegalStateException("Drawer has not been set");
            }

            return new EventHandler<Event>()
            {
                private Drawable drawnShape;

                @Override
                public void handle(Event event)
                {
                    if(event.getEventType() == MouseEvent.MOUSE_PRESSED)
                    {
                        event.consume();
                        
                        MouseEvent me = (MouseEvent)event;

                        if(me.isPrimaryButtonDown())
                        {
                            PaintLogger.logger.log(Level.INFO, "Started drawing");

                            drawnShape = drawer.draw(me.getX(), me.getY());
                        }
                    }
                    else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED)
                    {
                        MouseEvent me = (MouseEvent)event;
                        if(me.isPrimaryButtonDown())
                        {
                            event.consume();

                            drawnShape.setWidth(2 * (me.getX() - drawnShape.getTranslateX()));
                            drawnShape.setHeight(2 * (me.getY() - drawnShape.getTranslateY()));
                        }
                    }
                }
            };
        }
    };

    protected static Drawer drawer;

    public abstract EventHandler<Event> getEventFilter();

    public static void setDrawer(Drawer newDrawer)
    {
        drawer = newDrawer;
    }
}
