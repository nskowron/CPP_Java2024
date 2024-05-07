import javafx.scene.shape.Ellipse;

public class DrawingCircle extends DrawingShape
{
    private double radius;

    public DrawingCircle(double radius, Canvas canvas)
    {
        super(new Ellipse(0, 0, radius, radius), canvas);

        this.radius = radius;
    }

    @Override
    public DrawingShape Clone()
    {
        DrawingCircle clone = new DrawingCircle(radius, canvas);

        //consider giving final values as arguments
        clone.Translate(this.GetX(), this.GetX());
        clone.Resize(this.GetWidth() - shape.getBoundsInLocal().getWidth(), this.GetHeight() - shape.getBoundsInLocal().getHeight());
        clone.Rotate(rotate.getAngle());

        return clone;
    }
}
