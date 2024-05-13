import java.util.HashMap;
import java.util.Map;

import javafx.scene.shape.Shape;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import java.util.logging.Level;

public class InputHandler
{
    // public void SetCanvasInputs(Canvas canvas)
    // {
    //     Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > inputHandlers = new HashMap<>(0);

    //     inputHandlers.put(MouseEvent.MOUSE_PRESSED, new HashMap<>(0));
    //     inputHandlers.put(MouseEvent.MOUSE_DRAGGED, new HashMap<>(0));
    //     inputHandlers.put(MouseEvent.MOUSE_RELEASED, new HashMap<>(0));

    //     inputHandlers.get(MouseEvent.MOUSE_PRESSED).put(Canvas.Mode.DRAW, new EventHandler<MouseEvent>()
    //     {
    //         @Override
    //         public void handle(MouseEvent me)
    //         {
    //             canvas.newShape = canvas.drawingTemplate.Clone();
    //             canvas.newShape.SetInputHandlers(new InputHandler(), canvas);

    //             canvas.newShape.Translate(me.getX(), me.getY());
    //             canvas.newShape.Resize(0, 0);
    //             canvas.newShape.Rotate(0);
    //             //setfill

    //             canvas.getChildren().add(canvas.newShape);

    //             PaintLogger.logger.log(Level.INFO, "Canvas clicked");
    //         }
    //     });

    //     inputHandlers.get(MouseEvent.MOUSE_DRAGGED).put(Canvas.Mode.DRAW, new EventHandler<MouseEvent>()
    //     {
    //         @Override
    //         public void handle(MouseEvent me)
    //         {
    //             if(me.isPrimaryButtonDown())
    //             {
    //                 canvas.newShape.Resize(2 * (me.getX() - canvas.newShape.GetX()), 2 * (me.getY() - canvas.newShape.GetY()));
    //             }
    //         }
    //     });

    //     inputHandlers.get(MouseEvent.MOUSE_RELEASED).put(Canvas.Mode.DRAW, new EventHandler<MouseEvent>()
    //     {
    //         @Override
    //         public void handle(MouseEvent me)
    //         {
    //             // canvas.Select(canvas.newShape);

    //             PaintLogger.logger.log(Level.INFO, "New shape drawn");
    //         }
    //     });

    //     inputHandlers.get(MouseEvent.MOUSE_DRAGGED).put(Canvas.Mode.SELECT, new EventHandler<MouseEvent>()
    //     {
    //         @Override
    //         public void handle(MouseEvent me)
    //         {
    //             if(canvas.selectedShape != null)
    //             {
    //                 canvas.selectedShape.Translate(me.getX(), me.getY());
    //             }
    //         }
    //     });

    //     return inputHandlers;
    // }

    public void SetCanvasInputHandling(Canvas canvas)
    {
        canvas.setOnMousePressed(me ->
        {
            DrawingShape currentShape = canvas.GetShapeManagers().get(canvas.GetMode()).GetCurrentShape();
            if(currentShape == null || currentShape.GetState() == DrawingShape.State.IDLE)
            {
                canvas.GetShapeManagers().get(canvas.GetMode()).ManageNew(me);
            }
        });

        canvas.setOnMouseReleased(me ->
        {
            PaintLogger.logger.log(Level.INFO, "Released");

            DrawingShape currentShape = canvas.GetShapeManagers().get(canvas.GetMode()).GetCurrentShape();

            if(currentShape != null)
            {
                currentShape.SetState(DrawingShape.State.IDLE);
            }
        });

        canvas.setOnMouseDragged(this.GetCanvasDefaultEventHandler(canvas));
        canvas.setOnScroll(this.GetCanvasDefaultEventHandler(canvas));
    }

    public void SetDrawingShapeInputHandling(DrawingShape dShape, Shape shape, Rotator rotator, final Canvas canvas) //rotator
    {
        shape.setOnMousePressed(me -> 
        {
            canvas.GetShapeManagers().get(canvas.GetMode()).Manage(dShape);

            //drawing mode?
            if(me.isSecondaryButtonDown())
            {
                //popup window
            }
        });

        rotator.setOnMousePressed(me ->
        {
            me.consume();

            dShape.SetState(DrawingShape.State.ROTATING);
        });

        // Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > inputHandlers = new HashMap<>(0);

        // inputHandlers.put(MouseEvent.MOUSE_PRESSED, new HashMap<>(0));
        // //inputHandlers.put(MouseEvent.MOUSE_DRAGGED, new HashMap<>(0));
        // //inputHandlers.put(MouseEvent.MOUSE_RELEASED, new HashMap<>(0));

        // inputHandlers.get(MouseEvent.MOUSE_PRESSED).put(Canvas.Mode.SELECT, new EventHandler<MouseEvent>()
        // {
        //     @Override
        //     public void handle(MouseEvent me)
        //     {
        //         canvas.Select(dShape);
        //     }
        // });

        // return inputHandlers;
    }

    public Map<DrawingShape.State, EventHandler<InputEvent> > GetDrawingShapeInputHandlers(DrawingShape dShape)
    {
        Map<DrawingShape.State, EventHandler<InputEvent> > inputHandlers = new HashMap<>(0);

        inputHandlers.put(DrawingShape.State.MOVING, ie ->
        {
            if(ie.getEventType() == MouseEvent.MOUSE_DRAGGED)
            {
                MouseEvent me = (MouseEvent)ie;
                dShape.Translate(me.getX(), me.getY());
            }
        });

        inputHandlers.put(DrawingShape.State.RESIZING, ie ->
        {
            if(ie.getEventType() == MouseEvent.MOUSE_DRAGGED)
            {
                MouseEvent me = (MouseEvent)ie;
                dShape.Resize(2 * (me.getX() - dShape.GetX()), 2 * (me.getY() - dShape.GetY()));
            }
        });

        inputHandlers.put(DrawingShape.State.ROTATING, ie ->
        {
            if(ie.getEventType() == MouseEvent.MOUSE_DRAGGED)
            {
                MouseEvent me = (MouseEvent)ie;
                if(me.getX() != dShape.GetX() && me.getY() != dShape.GetY())
                {
                    double angle = Math.atan2(me.getY() - dShape.GetY(), me.getX() - dShape.GetY());
                    dShape.Rotate(Math.toDegrees(angle) + 90.0);
                }
            }
        });

        inputHandlers.put(DrawingShape.State.IDLE, ie ->
        {
            if(ie.getEventType() == ScrollEvent.SCROLL)
            {
                ScrollEvent se = (ScrollEvent)ie;

                dShape.Resize(dShape.GetWidth() * (1 + 0.003 * se.getDeltaY()), dShape.GetHeight() * (1 + 0.003 * se.getDeltaY()));
            }
        });

        return inputHandlers;
    }

    //could use some sort of nametype for this map...
    // public EventHandler<MouseEvent> GetDefaultInputHandler(Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > inputHandlers, Canvas canvas)
    // {
    //     return new EventHandler<MouseEvent>()
    //     {
    //         @Override
    //         public void handle(MouseEvent me)
    //         {
    //             if(inputHandlers.get(me.getEventType()) != null)
    //             {
    //                 if(inputHandlers.get(me.getEventType()).get(canvas.mode) != null)
    //                 {
    //                     inputHandlers.get(me.getEventType()).get(canvas.mode).handle(me);
    //                 }
    //             }
    //         }
    //     };
    // }

    private EventHandler<InputEvent> GetCanvasDefaultEventHandler(Canvas canvas)
    {
        return new EventHandler<InputEvent>()
        {
            @Override
            public void handle(InputEvent ie)
            {
                DrawingShape currentShape = canvas.GetShapeManagers().get(canvas.GetMode()).GetCurrentShape();

                if(currentShape != null)
                {
                    EventHandler<InputEvent> shapeInputHandler = currentShape.GetInputHandlers().get(currentShape.GetState());
                    if(shapeInputHandler != null)
                    {
                        shapeInputHandler.handle(ie);
                    }
                }
            }
        };
    }
}
