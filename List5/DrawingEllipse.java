import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

import java.util.logging.Level;

public class DrawingEllipse extends DrawingShape
{
    private Ellipse ellipse;

    //mozna wprowadzic structa
    private double x;
    private double y;
    private double parameter;

    //
    private Canvas canvas;

    public DrawingEllipse(double x, double y, double parameter, Canvas canvas) throws IllegalArgumentException
    {
        super(x, y, parameter, canvas);
        this.canvas = canvas;

        this.x = x;
        this.y = y;
        this.parameter = parameter;

        this.ellipse = new Ellipse(x, y, parameter, parameter);
        shape = ellipse;

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>()
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

        shape.setOnMousePressed(eventHandler);
        shape.setOnMouseDragged(eventHandler);
        shape.setOnMouseReleased(eventHandler);

        PaintLogger.logger.log(Level.INFO, "Ellipse created");
    }

    public Shape GetShape()
    {
        return this.ellipse;
    }

    public DrawingShape Clone()
    {
        DrawingShape copy = new DrawingEllipse(x, y, parameter, canvas);
        copy.GetShape().getTransforms().addAll(this.ellipse.getTransforms());
        copy.GetShape().setFill(this.ellipse.getFill());
        return copy;
    }
}
