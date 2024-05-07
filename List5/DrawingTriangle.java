import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

import java.util.logging.Level;

import java.lang.Math;

public class DrawingTriangle extends DrawingShape
{
    private Polygon triangle;

    //mozna wprowadzic structa
    private double x;
    private double y;
    private double parameter;

    //
    private Canvas canvas;

    public DrawingTriangle(double x, double y, double parameter, Canvas canvas) throws IllegalArgumentException
    {
        super(x, y, parameter, canvas);

        this.x = x;
        this.y = y;
        this.parameter = parameter;

        double[] indices = {(x), (y + parameter), 
                            (x + parameter * Math.sin(Math.toRadians(60.0))), (y - parameter * 0.5),
                            (x - parameter * Math.sin(Math.toRadians(60.0))), (y - parameter * 0.5)};
                            
        this.triangle = new Polygon(indices);

        shape = triangle;

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

        PaintLogger.logger.log(Level.INFO, "Triangle created");
    }

    public Shape GetShape()
    {
        return this.triangle;
    }

    public DrawingShape Clone()
    {
        DrawingShape copy = new DrawingTriangle(x, y, parameter, canvas);
        copy.GetShape().getTransforms().addAll(this.triangle.getTransforms());
        copy.GetShape().setFill(this.triangle.getFill());
        return copy;
    }
}

