import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.logging.Level;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

//use set input hanlers like shape?
public class Canvas extends Pane
{
    public enum Mode
    {
        DRAW, SELECT;
    }

    public Map<EventType<MouseEvent>, Map<Canvas.Mode, EventHandler<MouseEvent> > > inputHandlers;

    public Mode mode;
    public DrawingShape drawingTemplate;

    public DrawingShape selectedShape;
    public DrawingShape newShape;

    //we can bind children to it
    private List<DrawingShape> shapes;

    public Canvas()
    {
        selectedShape = null;
        newShape = null;

        //FOR NOW
        shapes = new ArrayList<DrawingShape>(0);

        this.setMinHeight(300);
        this.setMinWidth(400);

        inputHandlers = InputHandler.GetCanvasInputs(this);
        EventHandler<MouseEvent> eventHandler = InputHandler.GetDefaultInputHandler(this.inputHandlers, this);
        this.setOnMousePressed(eventHandler);
        this.setOnMouseDragged(eventHandler);
        this.setOnMouseReleased(eventHandler);
    }

    public List<DrawingShape> GetDrawingShapes()
    {
        return Collections.unmodifiableList(shapes);
    }

    public void Select(DrawingShape shape)
    {
        this.Unselect();

        selectedShape = shape;
        //do stuff

        PaintLogger.logger.log(Level.INFO, "Shape selected");
    }

    public void Unselect()
    {
        //do stuff
        selectedShape = null;

        PaintLogger.logger.log(Level.INFO, "Shape unselected");
    }
}
