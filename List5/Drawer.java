import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import java.util.logging.Level;

public class Drawer
{
    private DrawableObjectInstantiator instantiator;
    private String type;
    private Canvas canvas;
    private ColorPicker colorPicker;
    
    public Drawer(DrawableObjectInstantiator instantiator, Canvas canvas, ColorPicker colorPicker)
    {
        this.instantiator = instantiator;
        this.canvas = canvas;
        this.colorPicker = colorPicker;
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

        Color color = colorPicker.getValue();
        data.fillR = color.getRed();
        data.fillG = color.getGreen();
        data.fillB = color.getBlue();
        data.fillA = color.getOpacity();

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
