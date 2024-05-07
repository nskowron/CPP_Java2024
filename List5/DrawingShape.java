import java.util.Map;
import java.util.HashMap;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

import java.util.logging.Level;

public abstract class DrawingShape extends Shape
{
    public Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > inputHandlers;

    protected Shape shape;

    public DrawingShape(double x, double y, double parameter, Canvas canvas) throws IllegalArgumentException
    {
        if(x < 0 || y < 0)
        {
            throw new IllegalArgumentException("Coordinates cannot be negative, got: " + x + ", " + y);
        }
        if(parameter < 0)
        {
            throw new IllegalArgumentException("Measurements cannot be negative, got: " + parameter);
        }

        InputHandler.SetDrawingShapeInputs(this, canvas);
    }

    public abstract Shape GetShape();
    //shadow
    //rotator

    public double GetX()
    {
        return GetShape().getBoundsInParent().getCenterX();
    }

    public double GetY()
    {
        return GetShape().getBoundsInParent().getCenterY();
    }

    public double GetWidth()
    {
        return GetShape().getBoundsInParent().getWidth();
    }

    public double GetHeight()
    {
        return GetShape().getBoundsInParent().getHeight();
    }

    public void Select()
    {
        //create a shadow
        //create a rotator
    }
    //public abstract void Unselect();

    public abstract DrawingShape Clone();
}
