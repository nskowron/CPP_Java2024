import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.logging.Level;

public class DrawingRectangle extends DrawingShape
{
    private Polygon rectangle;

    //mozna wprowadzic structa
    private double x;
    private double y;
    private double parameter;

    //
    private Canvas canvas;

    public DrawingRectangle(double x, double y, double parameter, Canvas canvas) throws IllegalArgumentException
    {
        super(x, y, parameter, canvas);

        this.x = x;
        this.y = y;
        this.parameter = parameter;

        this.canvas = canvas;


        double[] indices = {(x - parameter), (y - parameter), (x - parameter), (y + parameter), 
                            (x + parameter), (y + parameter), (x + parameter), (y - parameter)};

        this.rectangle = new Polygon(indices);

        shape = rectangle;

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                PaintLogger.logger.log(Level.INFO, "Shape is working...");

                if(inputHandlers.get(me.getEventType()) != null)
                {
                    if(inputHandlers.get(me.getEventType()).get(canvas.mode) != null)
                    {
                        inputHandlers.get(me.getEventType()).get(canvas.mode).handle(me);
                    }
                }
            }
        };

        shape.setOnMousePressed(eventHandler);
        shape.setOnMouseDragged(eventHandler);
        shape.setOnMouseReleased(eventHandler);

        PaintLogger.logger.log(Level.INFO, "Rectangle created");
    }

    public Shape GetShape()
    {
        return this.rectangle;
    }

    public DrawingShape Clone()
    {
        DrawingShape copy = new DrawingRectangle(x, y, parameter, canvas);
        copy.GetShape().getTransforms().addAll(this.rectangle.getTransforms());
        copy.GetShape().setFill(this.rectangle.getFill());
        return copy;
    }
}

