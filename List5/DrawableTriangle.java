import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;

public class DrawableTriangle extends Polygon implements Drawable
{
    private final double originalWidth;
    private final double originalHeight;

    private Canvas canvas;

    public DrawableTriangle(double x1, double y1, double x2, double y2, double x3, double y3)
    {
        super(x1, y1, x2, y2, x3, y3);

        originalWidth = Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
        originalHeight = Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3));

        canvas = null;
    }

    public DrawableObjectData getData()
    {
        DrawableObjectData data = new DrawableObjectData("Triangle", originalWidth, originalHeight);
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
            //don't save non-colors
        }

        return data;
    }

    public void draw(Canvas canvas)
    {
        this.canvas = canvas;
        canvas.add(this);
    }

    public void redraw()
    {
        if(canvas != null);
        {
            canvas.remove(this);
            canvas.add(this);
        }
    }

    public void delete()
    {
        if(canvas != null);
        {
            canvas.remove(this);
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

