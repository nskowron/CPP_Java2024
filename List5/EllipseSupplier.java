import javafx.scene.paint.Color;

public class EllipseSupplier implements DrawableObjectSupplier
{
    public Drawable get(DrawableObjectData data) throws IllegalArgumentException
    {
        if(!data.type.equals("Ellipse"))
        {
            throw new IllegalArgumentException("Wrong type of Drawable object, expected Ellipse, got " + data.type);
        }

        Drawable ellipse = new DrawableEllipse(data.width / 2.0, data.height / 2.0);
        ellipse.setTranslateX(data.translateX);
        ellipse.setTranslateY(data.translateY);
        ellipse.setWidth(data.width * data.scaleX);
        ellipse.setHeight(data.height * data.scaleY);
        ellipse.setRotate(data.angle);
        ellipse.setFill(new Color(data.fillR, data.fillG, data.fillB, data.fillA));
        ellipse.setStroke(ellipse.getFill());
        ellipse.setStrokeWidth(0);
        return ellipse;
    }
}
