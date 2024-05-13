import java.io.Serializable;

import javafx.scene.shape.Ellipse;

public class DrawableEllipse extends Ellipse implements Serializable
{
    private DrawableObjectData data;

    public DrawableEllipse(double radiusX, double radiusY)
    {
        super(0, 0, radiusX, radiusY);

        data = new DrawableObjectData("Ellipse", radiusX, radiusY);
    }

    public DrawableEllipse(DrawableObjectData data)
    {

    }
}
