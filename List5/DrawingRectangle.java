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

    public DrawingRectangle(double x, double y, double parameter) throws IllegalArgumentException
    {
        super(x, y, parameter);

        this.x = x;
        this.y = y;
        this.parameter = parameter;

        double[] indices = {(x - parameter), (y - parameter), (x - parameter), (y + parameter), 
                            (x + parameter), (y + parameter), (x + parameter), (y - parameter)};

        this.rectangle = new Polygon(indices);

        PaintLogger.logger.log(Level.INFO, "Rectangle created");
    }

    public Shape GetShape()
    {
        return this.rectangle;
    }

    public void Select()
    {
        //create a shadow
        //create a rotator
    }

    public DrawingShape Clone()
    {
        DrawingShape copy = new DrawingRectangle(x, y, parameter);
        copy.GetShape().getTransforms().addAll(this.rectangle.getTransforms());
        copy.GetShape().setFill(this.rectangle.getFill());
        return copy;
    }
}

