import javafx.scene.layout.Pane;

import java.util.logging.Level;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Canvas extends Pane
{
    public DrawingShape selectedShape;
    private List<DrawingShape> shapes;

    public Canvas()
    {
        selectedShape = null;

        //FOR NOW
        shapes = new ArrayList<DrawingShape>(0);

        this.setMinHeight(300);
        this.setMinWidth(400);
    }

    public void Add(DrawingShape shape)
    {
        shapes.add(shape);
        this.getChildren().add(shape.GetShape());
    }

    public void Delete(DrawingShape shape)
    {
        if(selectedShape == shape)
        {
            this.Unselect();
        }

        this.getChildren().remove(shape.GetShape());
        shapes.remove(shape);
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
