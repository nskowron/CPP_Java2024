import java.util.Map;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import javafx.scene.transform.*;

import java.util.logging.Level;

public abstract class DrawingShape extends Group
{
    protected Shape shape;
    //private Shape shadow;
    //private Rotator rotator;

    //for now?
    protected Canvas canvas;

    protected Translate translate;
    protected Rotate rotate;
    protected Scale scale;

    //private double originalWidth
    //private double originalHeight

    public Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > shapeInputHandlers;

    public DrawingShape(Shape shape, final Canvas canvas)
    {
        this.shape = shape;

        //probably should set them somewhere else to
        //not make DrawingShape dependent on a canvas
        this.canvas = canvas;
        //will help with cloning
        shapeInputHandlers = InputHandler.GetDrawingShapeInputs(this, canvas);
        EventHandler<MouseEvent> eventHandler = InputHandler.GetDefaultInputHandler(this.shapeInputHandlers, canvas);
        shape.setOnMousePressed(eventHandler);
        shape.setOnMouseDragged(eventHandler);
        shape.setOnMouseReleased(eventHandler);

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
        return shape.getBoundsInParent().getWidth();
    }

    public double GetHeight()
    {
        return shape.getBoundsInParent().getHeight();
    }

    public abstract DrawingShape Clone();

    public void Translate(double x, double y)
    {
        translate.setX(translate.getX() + x);
        translate.setY(translate.getY() + y);
    }

    public void Resize(double x, double y)
    {
        scale.setX(2 * ((GetWidth() + x) / shape.getBoundsInLocal().getWidth()));
        scale.setY(2 * ((GetHeight() + y) / shape.getBoundsInLocal().getHeight()));
    }

    public void Rotate(double angle)
    {

    }

    //public void SetInputHandlers(map, canvas)
}
