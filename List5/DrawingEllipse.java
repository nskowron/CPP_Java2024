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

    public DrawingEllipse(double x, double y, double parameter) throws IllegalArgumentException
    {
        super(x, y, parameter);

        this.x = x;
        this.y = y;
        this.parameter = parameter;

        this.ellipse = new Ellipse(x, y, parameter, parameter);

        PaintLogger.logger.log(Level.INFO, "Ellipse created");
    }

    public Shape GetShape()
    {
        return this.ellipse;
    }

    public void Select()
    {
        //create a shadow
        //create a rotator
    }

    public DrawingShape Clone()
    {
        DrawingShape copy = new DrawingEllipse(x, y, parameter);
        copy.GetShape().getTransforms().addAll(this.ellipse.getTransforms());
        copy.GetShape().setFill(this.ellipse.getFill());
        return copy;
    }
}
