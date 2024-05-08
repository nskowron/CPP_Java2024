import javafx.scene.shape.Polygon;
import java.lang.Math;

public class DrawingSquare extends DrawingShape
{
    private double radius;

    public DrawingSquare(double radius)
    {
        super(new Polygon(-radius * 0.5 * Math.sqrt(2), radius * 0.5 * Math.sqrt(2),
                          radius * 0.5 * Math.sqrt(2), radius * 0.5 * Math.sqrt(2),
                          radius * 0.5 * Math.sqrt(2), -radius * 0.5 * Math.sqrt(2),
                          -radius * 0.5 * Math.sqrt(2), -radius * 0.5 * Math.sqrt(2)));

        this.radius = radius;
    }

    @Override
    public DrawingShape Clone()
    {
        DrawingSquare clone = new DrawingSquare(radius);

        clone.Translate(this.GetX(), this.GetX());
        clone.Resize(this.GetWidth(), this.GetHeight());
        clone.Rotate(this.GetAngle());

        return clone;
    }
}
