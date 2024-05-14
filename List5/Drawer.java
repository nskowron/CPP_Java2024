import java.util.logging.Level;

public class Drawer
{
    private DrawableObjectInstantiator instantiator;
    private String type;
    private Canvas canvas;
    
    public Drawer(DrawableObjectInstantiator instantiator, Canvas canvas)
    {
        this.instantiator = instantiator;
        this.canvas = canvas;
        type = null;
    }

    public Drawable draw(double x, double y)
    {
        DrawableObjectData data = new DrawableObjectData(type, 100, 100);
        data.translateX = x;
        data.translateY = y;
        data.scaleX = 0;
        data.scaleY = 0;
        data.angle = 0;
        //set color
        data.fillR = 0;
        data.fillG = 0;
        data.fillB = 0;
        data.fillA = 1.0;

        Drawable drawnObject = instantiator.instantiate(data);
        
        drawnObject.draw(canvas);

        PaintLogger.logger.log(Level.INFO, "Drawn shape at " + drawnObject.getTranslateX() + ", " + drawnObject.getTranslateY());

        return drawnObject;
    }

    public void setType(String type) throws IllegalArgumentException
    {
        try
        {
            instantiator.instantiate(new DrawableObjectData(type, 0, 0));
        }
        catch(IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Could not draw type " + type);
        }
        
        this.type = type;
    }
}
