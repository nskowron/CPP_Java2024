import javafx.scene.paint.Color;

public class RectangleSupplier implements DrawableObjectSupplier
{
    public Drawable get(DrawableObjectData data) throws IllegalArgumentException
    {
        if(!data.type.equals("Rectangle"))
        {
            throw new IllegalArgumentException("Wrong type of Drawable object, expected Rectangle, got " + data.type);
        }

        Drawable rectangle = new DrawableRectangle(data.width, data.height);
        rectangle.setTranslateX(data.translateX);
        rectangle.setTranslateY(data.translateY);
        rectangle.setWidth(data.width * data.scaleX);
        rectangle.setHeight(data.height * data.scaleY);
        rectangle.setRotate(data.angle);
        rectangle.setFill(new Color(data.fillR, data.fillG, data.fillB, data.fillA));
        rectangle.setStroke(rectangle.getFill());
        rectangle.setStrokeWidth(0);
        return rectangle;
    }
}
