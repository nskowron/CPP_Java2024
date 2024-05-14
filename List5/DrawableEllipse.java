import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;

import java.util.logging.Level;

public class DrawableEllipse extends Ellipse implements Drawable
{
    private final double originalWidth;
    private final double originalHeight;

    private Canvas canvas;

    public DrawableEllipse(double radiusX, double radiusY)
    {
        super(0, 0, radiusX, radiusY);

        originalWidth = 2 * radiusX;
        originalHeight = 2 * radiusY;

        canvas = null;
    }

    public DrawableObjectData getData()
    {
        DrawableObjectData data = new DrawableObjectData("Ellipse", originalWidth, originalHeight);
        data.translateX = getTranslateX();
        data.translateY = getTranslateY();
        data.scaleX = getScaleX();
        data.scaleY = getScaleY();
        data.angle = getRotate();
        
        try
        {
            Color fill = (Color)getFill();
            data.fillR = fill.getRed();
            data.fillG = fill.getGreen();
            data.fillB = fill.getBlue();
            data.fillA = fill.getOpacity();
        }
        catch(ClassCastException e)
        {

        }

        return data;
    }

    public void draw(Canvas canvas)
    {
        this.canvas = canvas;
        canvas.add(this, this);
    }

    public void redraw()
    {
        if(canvas != null);
        {
            canvas.getChildren().remove(this);
            canvas.getChildren().addLast(this);
        }
    }

    public void delete()
    {
        if(canvas != null);
        {
            canvas.remove(this, this);
            canvas = null;
        }
    }

    public double getWidth()
    {
        return originalWidth * getScaleX();
    }

    public double getHeight()
    {
        return originalHeight * getScaleY();
    }

    public void setWidth(double newWidth) throws IllegalArgumentException
    {
        if(originalWidth == 0 && newWidth != 0)
        {
            throw new IllegalArgumentException("Cannot change width of a 1D object");
        }
        if(originalWidth != 0)
        {
            setScaleX(newWidth / originalWidth);
        }
    }

    public void setHeight(double newHeight) throws IllegalArgumentException
    {
        if(originalHeight == 0 && newHeight != 0)
        {
            throw new IllegalArgumentException("Cannot change width of a 1D object");
        }
        if(originalHeight != 0)
        {
            setScaleY(newHeight / originalHeight);
        }
    }
}
