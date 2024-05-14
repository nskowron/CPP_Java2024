import java.io.Serializable;

public class DrawableObjectData implements Serializable
{
    public final String type;

    public final double width;
    public final double height;

    public double translateX;
    public double translateY;

    public double scaleX;
    public double scaleY;

    public double angle;


    public double fillR;
    public double fillG;
    public double fillB;
    public double fillA;

    public DrawableObjectData(final String type, final double width, final double height)
    {
        this.type = type;

        this.width = width;
        this.height = height;
    }
}
