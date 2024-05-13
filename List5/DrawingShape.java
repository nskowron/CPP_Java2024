import java.util.HashMap;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import javafx.scene.transform.*;

public abstract class DrawingShape extends Group
{
    public enum State
    {
        IDLE, MOVING, RESIZING, ROTATING;
    }

    protected final Shape shape;
    protected Rotator rotator;

    protected State state;

    protected final double originalWidth;
    protected final double originalHeight;

    private final Translate translate;
    private final Rotate rotate;
    private final Scale scale;

    //public Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > shapeInputHandlers;
    protected Map<State, EventHandler<InputEvent> > inputHandlers;

    public DrawingShape(Shape shape)
    {
        this.shape = shape;

        state = State.IDLE;

        originalWidth = shape.getBoundsInParent().getWidth();
        originalHeight = shape.getBoundsInParent().getHeight();

        translate = new Translate(0, 0);
        rotate = new Rotate(0);
        scale = new Scale(1, 1);
        
        this.getTransforms().addAll(translate, rotate);
        shape.getTransforms().add(scale);

        this.rotator = new Rotator("icons/rotate.png", this.GetX(), this.GetY(), 100, 10);

        this.getChildren().add(shape);
        this.getChildren().add(rotator);

        this.inputHandlers = new HashMap<>(0);
    }

    public Map<State, EventHandler<InputEvent> > GetInputHandlers()
    {
        return inputHandlers;
    }

    public void SetState(State newState) throws IllegalStateException
    {
        if(newState == State.IDLE || state == State.IDLE)
        {
            state = newState;
        }
        else
        {
            throw new IllegalStateException("Could not switch between states " + state + " and " + newState);
        }
    }

    public State GetState()
    {
        return state;
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

    public void SetInputHandling(InputHandler inputHandler, Canvas canvas)
    {
        inputHandler.SetDrawingShapeInputHandling(this, shape, rotator, canvas);
    }

    // public void SetInputHandlers(InputHandler inputHandler, Canvas canvas)
    // {
    //     shapeInputHandlers = inputHandler.GetDrawingShapeInputs(this, canvas);
    //     shape.setOnMousePressed(inputHandler.GetDefaultInputHandler(shapeInputHandlers, canvas));
    //     shape.setOnMouseDragged(inputHandler.GetDefaultInputHandler(shapeInputHandlers, canvas));
    //     shape.setOnMouseReleased(inputHandler.GetDefaultInputHandler(shapeInputHandlers, canvas));
    // }
}
