import java.util.Map;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import javafx.scene.transform.*;

public abstract class DrawingShape extends Group
{
    protected final Shape shape;
    //private Shape shadow;
    //private Rotator rotator;

    protected final double originalWidth;
    protected final double originalHeight;

    private final Translate translate;
    private final Rotate rotate;
    private final Scale scale;

    public Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > shapeInputHandlers;

    public DrawingShape(Shape shape)
    {
        this.shape = shape;

        originalWidth = shape.getBoundsInParent().getWidth();
        originalHeight = shape.getBoundsInParent().getHeight();

        translate = new Translate(0, 0);
        rotate = new Rotate(0);
        scale = new Scale(1, 1);
        
        this.getTransforms().addAll(translate, rotate);
        shape.getTransforms().add(scale);

        this.getChildren().add(shape);
    }

    public double GetX()
    {
        return translate.getX();
    }

    public double GetY()
    {
        return translate.getY();
    }

    public double GetWidth()
    {
        return scale.getX() * originalWidth;
    }

    public double GetHeight()
    {
        return scale.getY() * originalHeight;
    }

    public double GetAngle()
    {
        return rotate.getAngle();
    }

    public abstract DrawingShape Clone();

    public void Translate(double new_x, double new_y)
    {
        translate.setX(new_x);
        translate.setY(new_y);
    }

    public void Resize(double new_width, double new_height)
    {
        scale.setX(new_width / originalWidth);
        scale.setY(new_height / originalHeight);
    }

    public void Rotate(double new_angle)
    {
        rotate.setAngle(new_angle);
    }

    public void SetInputHandlers(InputHandler inputHandler, Canvas canvas)
    {
        shapeInputHandlers = inputHandler.GetDrawingShapeInputs(this, canvas);
        shape.setOnMousePressed(inputHandler.GetDefaultInputHandler(shapeInputHandlers, canvas));
        shape.setOnMouseDragged(inputHandler.GetDefaultInputHandler(shapeInputHandlers, canvas));
        shape.setOnMouseReleased(inputHandler.GetDefaultInputHandler(shapeInputHandlers, canvas));
    }
}
