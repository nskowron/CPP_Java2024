import java.util.HashMap;
import java.util.logging.Level;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class InputHandler
{
    public InputHandler() throws InstantiationError
    {
        throw new InstantiationError("Cannot create instance of static class InputHandler");
    }

    private static double scaleOriginalWidth;
    private static double scaleOriginalHeight;

    private static double translateOriginalX;
    private static double translateOriginalY;

    public static void SetCanvasInputs(Canvas canvas)
    {
        canvas.inputHandlers = new HashMap<>(0);

        canvas.inputHandlers.put(MouseEvent.MOUSE_PRESSED, new HashMap<>(0));
        canvas.inputHandlers.put(MouseEvent.MOUSE_DRAGGED, new HashMap<>(0));
        canvas.inputHandlers.put(MouseEvent.MOUSE_RELEASED, new HashMap<>(0));

        canvas.inputHandlers.get(MouseEvent.MOUSE_PRESSED).put(Canvas.Mode.DRAW, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                canvas.newShape = canvas.drawingTemplate.Clone();
                scaleOriginalWidth = canvas.newShape.GetWidth();
                scaleOriginalHeight = canvas.newShape.GetHeight();

                //add own transforms
                canvas.newShape.GetShape().getTransforms().add(new Translate(me.getX(), me.getY()));
                canvas.newShape.GetShape().getTransforms().add(new Scale(0, 0));
                //setfill

                canvas.Add(canvas.newShape);
            }
        });

        canvas.inputHandlers.get(MouseEvent.MOUSE_DRAGGED).put(Canvas.Mode.DRAW, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                if(me.isPrimaryButtonDown())
                {
                    //seriously, add own transforms
                    Scale scale = (Scale)canvas.newShape.GetShape().getTransforms().getLast();

                    scale.setX(2 * (me.getX() - canvas.newShape.GetX()) / scaleOriginalWidth);
                    scale.setY(2 * (me.getY() - canvas.newShape.GetY()) / scaleOriginalHeight);
                }
            }
        });

        canvas.inputHandlers.get(MouseEvent.MOUSE_RELEASED).put(Canvas.Mode.DRAW, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                canvas.Select(canvas.newShape);

                PaintLogger.logger.log(Level.INFO, "New shape drawn");
            }
        });
    }

    public static void SetDrawingShapeInputs(DrawingShape shape, Canvas canvas)
    {
        shape.inputHandlers = new HashMap<>(0);

        shape.inputHandlers.put(MouseEvent.MOUSE_PRESSED, new HashMap<>(0));
        shape.inputHandlers.put(MouseEvent.MOUSE_DRAGGED, new HashMap<>(0));
        shape.inputHandlers.put(MouseEvent.MOUSE_RELEASED, new HashMap<>(0));

        shape.inputHandlers.get(MouseEvent.MOUSE_PRESSED).put(Canvas.Mode.SELECT, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                translateOriginalX = shape.GetX();
                translateOriginalY = shape.GetY();

                //for the love of god add own transforms
                shape.GetShape().getTransforms().addFirst(new Translate(0, 0));

                canvas.Select(shape);
            }
        });

        shape.inputHandlers.get(MouseEvent.MOUSE_DRAGGED).put(Canvas.Mode.SELECT, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                //i swear i'll add own transforms...
                Translate translate = (Translate)shape.GetShape().getTransforms().getFirst();
                translate.setX(me.getX() - translateOriginalX);
                translate.setY(me.getY() - translateOriginalY);

                PaintLogger.logger.log(Level.INFO, "Translate added");
            }
        });
    }
}
