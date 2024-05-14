import javafx.event.*;
import javafx.scene.input.MouseEvent;

import java.util.logging.Level;

public enum Mode
{
    SELECT()
    {
        // @Override
        // public EventHandler<Event> getEventFilter() throws IllegalStateException
        // {
        //     if(selector == null)
        //     {
        //         throw new IllegalStateException("Selector has not been set");
        //     }

        //     return event ->
        //     {
        //         //filter out press events
        //         if(event.getEventType() == MouseEvent.MOUSE_PRESSED)
        //         {
        //             event.consume();

        //             //could also check every object if contains x and y
        //             if(event.getSource() instanceof Drawable)
        //             {
        //                 selector.select((Drawable)event.getSource());
        //             }
        //             else
        //             {
        //                 selector.unselect();
        //             }
        //         }
        //     };
        // }

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

                        PaintLogger.logger.log(Level.INFO, "Started drawing");

                        MouseEvent me = (MouseEvent)event;
                        drawnShape = drawer.draw(me.getX(), me.getY());
                        
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

    private Mode()
    {

    }

    public abstract EventHandler<Event> getEventFilter(); //throws IllegalStateException;

    public static void setDrawer(Drawer newDrawer)
    {
        drawer = newDrawer;
    }
}
