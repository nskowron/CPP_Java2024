import javafx.scene.shape.Polygon;
import java.lang.Math;

public class DrawingTriangle extends DrawingShape
{
    private double radius;

    public DrawingTriangle(double radius)
    {
        super(new Polygon(0, radius,
                          radius * 0.5 * Math.sqrt(3), -radius * 0.5,
                          -radius * 0.5 * Math.sqrt(3), -radius * 0.5));

        this.radius = radius;
    }

    @Override
    public DrawingShape Clone()
    {
        DrawingTriangle clone = new DrawingTriangle(radius);

        clone.Translate(this.GetX(), this.GetX());
        clone.Resize(this.GetWidth(), this.GetHeight());
        clone.Rotate(this.GetAngle());

        return clone;
    }
}
