import java.util.HashMap;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

import java.util.logging.Level;

public class InputHandler
{
    public Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > GetCanvasInputs(final Canvas canvas)
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
                canvas.newShape.SetInputHandlers(new InputHandler(), canvas);

                canvas.newShape.Translate(me.getX(), me.getY());
                canvas.newShape.Resize(0, 0);
                canvas.newShape.Rotate(0);
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
                    canvas.newShape.Resize(2 * (me.getX() - canvas.newShape.GetX()), 2 * (me.getY() - canvas.newShape.GetY()));
                }
            }
        });

        inputHandlers.get(MouseEvent.MOUSE_RELEASED).put(Canvas.Mode.DRAW, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                // canvas.Select(canvas.newShape);

                PaintLogger.logger.log(Level.INFO, "New shape drawn");
            }
        });

        inputHandlers.get(MouseEvent.MOUSE_DRAGGED).put(Canvas.Mode.SELECT, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                if(canvas.selectedShape != null)
                {
                    canvas.selectedShape.Translate(me.getX(), me.getY());
                }
            }
        });

        return inputHandlers;
    }

    public Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > GetDrawingShapeInputs(final DrawingShape dShape, final Canvas canvas)
    {
        Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > inputHandlers = new HashMap<>(0);

        inputHandlers.put(MouseEvent.MOUSE_PRESSED, new HashMap<>(0));
        //inputHandlers.put(MouseEvent.MOUSE_DRAGGED, new HashMap<>(0));
        //inputHandlers.put(MouseEvent.MOUSE_RELEASED, new HashMap<>(0));

        inputHandlers.get(MouseEvent.MOUSE_PRESSED).put(Canvas.Mode.SELECT, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                canvas.Select(dShape);
            }
        });

        return inputHandlers;
    }

    //could use some sort of nametype for this map...
    public EventHandler<MouseEvent> GetDefaultInputHandler(Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > inputHandlers, Canvas canvas)
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
