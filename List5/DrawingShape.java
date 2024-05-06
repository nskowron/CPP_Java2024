import javafx.scene.shape.Shape;

public abstract class DrawingShape implements IDrawingShape
{
    public DrawingShape(double x, double y, double parameter) throws IllegalArgumentException
    {
        if(x < 0 || y < 0)
        {
            throw new IllegalArgumentException("Coordinates cannot be negative, got: " + x + ", " + y);
        }
        if(parameter < 0)
        {
            throw new IllegalArgumentException("Measurements cannot be negative, got: " + parameter);
        }
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
