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

    public DrawingTriangle(double x, double y, double parameter) throws IllegalArgumentException
    {
        super(x, y, parameter);

        this.x = x;
        this.y = y;
        this.parameter = parameter;

        double[] indices = {(x), (y + parameter), 
                            (x + parameter * Math.sin(Math.toRadians(60.0))), (y - parameter * 0.5),
                            (x - parameter * Math.sin(Math.toRadians(60.0))), (y - parameter * 0.5)};
                            
        this.triangle = new Polygon(indices);

        PaintLogger.logger.log(Level.INFO, "Triangle created");
    }

    public Shape GetShape()
    {
        return this.triangle;
    }

    public DrawingShape Clone()
    {
        DrawingShape copy = new DrawingTriangle(x, y, parameter);
        copy.GetShape().getTransforms().addAll(this.triangle.getTransforms());
        copy.GetShape().setFill(this.triangle.getFill());
        return copy;
    }
}

