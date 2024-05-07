import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class InputHandler
{
    public InputHandler() throws InstantiationError
    {
        throw new InstantiationError("Cannot create instance of static class InputHandler");
    }

    public static Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > GetCanvasInputs(final Canvas canvas)
    {
        Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > inputHandlers = new HashMap<>(0);

        inputHandlers.put(MouseEvent.MOUSE_PRESSED, new HashMap<>(0));
        inputHandlers.put(MouseEvent.MOUSE_DRAGGED, new HashMap<>(0));
        inputHandlers.put(MouseEvent.MOUSE_RELEASED, new HashMap<>(0));

        inputHandlers.get(MouseEvent.MOUSE_PRESSED).put(Canvas.Mode.DRAW, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                canvas.newShape = canvas.drawingTemplate.Clone();

                PaintLogger.logger.log(Level.INFO, "" + canvas.newShape.GetWidth() + ", " + canvas.newShape.GetHeight());

                canvas.newShape.Translate(me.getX(), me.getY());
                canvas.newShape.Resize(-canvas.newShape.GetWidth(), -canvas.newShape.GetHeight());
                PaintLogger.logger.log(Level.INFO, "" + canvas.newShape.GetWidth() + ", " + canvas.newShape.GetHeight());
                //setfill

                canvas.getChildren().add(canvas.newShape);

                PaintLogger.logger.log(Level.INFO, "Canvas clicked");
            }
        });

        inputHandlers.get(MouseEvent.MOUSE_DRAGGED).put(Canvas.Mode.DRAW, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                if(me.isPrimaryButtonDown())
                {
                    canvas.newShape.Resize(me.getX() - canvas.newShape.GetX() - canvas.newShape.GetWidth(), me.getY() - canvas.newShape.GetY() - canvas.newShape.GetHeight());
                }
            }
        });

        inputHandlers.get(MouseEvent.MOUSE_RELEASED).put(Canvas.Mode.DRAW, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                canvas.Select(canvas.newShape);

                PaintLogger.logger.log(Level.INFO, "New shape drawn");
            }
        });

        return inputHandlers;
    }

    public static Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > GetDrawingShapeInputs(final DrawingShape dShape, final Canvas canvas)
    {
        Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > inputHandlers = new HashMap<>(0);

        inputHandlers.put(MouseEvent.MOUSE_PRESSED, new HashMap<>(0));
        inputHandlers.put(MouseEvent.MOUSE_DRAGGED, new HashMap<>(0));
        inputHandlers.put(MouseEvent.MOUSE_RELEASED, new HashMap<>(0));

        inputHandlers.get(MouseEvent.MOUSE_PRESSED).put(Canvas.Mode.SELECT, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                canvas.Select(dShape);
            }
        });

        inputHandlers.get(MouseEvent.MOUSE_DRAGGED).put(Canvas.Mode.SELECT, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                //fix - some values are relative to shape and some to canvas
                PaintLogger.logger.log(Level.INFO, "" + me.getX() + " " + dShape.GetX());
                dShape.Translate(me.getX(), me.getY());
            }
        });

        return inputHandlers;
    }

    //could use some sort of nametype for this map...
    public static EventHandler<MouseEvent> GetDefaultInputHandler(Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > inputHandlers, Canvas canvas)
    {
        return new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                if(inputHandlers.get(me.getEventType()) != null)
                {
                    if(inputHandlers.get(me.getEventType()).get(canvas.mode) != null)
                    {
                        inputHandlers.get(me.getEventType()).get(canvas.mode).handle(me);
                    }
                }
            }
        };
    }
}
