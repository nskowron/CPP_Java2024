import javafx.scene.paint.Color;

public class TriangleSupplier implements DrawableObjectSupplier
{
    public Drawable get(DrawableObjectData data) throws IllegalArgumentException
    {
        if(!data.type.equals("Triangle"))
        {
            throw new IllegalArgumentException("Wrong type of Drawable object, expected Triangle, got " + data.type);
        }

        Drawable triangle = new DrawableTriangle(0, data.height * 0.5, data.width * 0.5, -data.height * 0.5, -data.width * 0.5, -data.height * 0.5);
        triangle.setTranslateX(data.translateX);
        triangle.setTranslateY(data.translateY);
        triangle.setWidth(data.width * data.scaleX);
        triangle.setHeight(data.height * data.scaleY);
        triangle.setRotate(data.angle);
        triangle.setFill(new Color(data.fillR, data.fillG, data.fillB, data.fillA));
        triangle.setStroke(triangle.getFill());
        triangle.setStrokeWidth(0);
        return triangle;
    }
}
