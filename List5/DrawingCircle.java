import javafx.scene.shape.Ellipse;

public class DrawingCircle extends DrawingShape
{
    private double radius;

    public DrawingCircle(double radius)
    {
        super(new Ellipse(0, 0, radius, radius));

        this.radius = radius;
    }

    @Override
    public DrawingShape Clone()
    {
        DrawingCircle clone = new DrawingCircle(radius);

        clone.Translate(this.GetX(), this.GetX());
        clone.Resize(this.GetWidth(), this.GetHeight());
        clone.Rotate(this.GetAngle());

        return clone;
    }
}
