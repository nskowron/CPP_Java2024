import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.logging.Level;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Canvas extends Pane
{
    public enum Mode
    {
        IDLE, DRAW, SELECT;
    }

    private Mode mode;
    private Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > inputHandlers;
    private Map<Mode, ShapeManager> shapeManagers;

    //we can bind children to it
    //private List<DrawingShape> shapes;

    public Canvas(InputHandler inputHandler)
    {
        mode = Mode.IDLE;

        shapeManagers = new HashMap<>(0);

        //FOR NOW
        //shapes = new ArrayList<DrawingShape>(0);

        inputHandler.SetCanvasInputHandling(this);

        this.setMinHeight(300);
        this.setMinWidth(400);
    }

    // public List<DrawingShape> GetDrawingShapes()
    // {
    //     return Collections.unmodifiableList(shapes);
    // }

    public Map<Mode, ShapeManager> GetShapeManagers()
    {
        return shapeManagers;
    }

    public Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > GetInputHandlers()
    {
        return inputHandlers;
    }

    public void SetMode(Mode newMode) throws IllegalStateException
    {
        DrawingShape currentShape = shapeManagers.get(mode).GetCurrentShape();
        if(currentShape != null && currentShape.GetState() != DrawingShape.State.IDLE)
        {
            throw new IllegalStateException("Cannot change mode when drawing shape is working");
        }

        mode = newMode;
    }

    public Mode GetMode()
    {
        return mode;
    }

    // public void SetInputHandlers(InputHandler inputHandler)
    // {
    //     inputHandlers = inputHandler.GetCanvasInputs(this);
    //     this.setOnMousePressed(inputHandler.GetDefaultInputHandler(inputHandlers, this));
    //     this.setOnMouseDragged(inputHandler.GetDefaultInputHandler(inputHandlers, this));
    //     this.setOnMouseReleased(inputHandler.GetDefaultInputHandler(inputHandlers, this));
    // }
}
