import javafx.scene.layout.Pane;

import java.util.List;
import java.util.ArrayList;

public class Canvas extends Pane
{
    public DrawingShape selectedShape;
    private List<DrawingShape> shapes;

    public Canvas()
    {
        selectedShape = null;

        //FOR NOW
        shapes = new ArrayList<DrawingShape>(0);

        setMinHeight(300);
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

    // public List<DrawingShape> GetDrawingShapes()
    // {
    //     return Collections.unmodifiableList(shapes);
    // }

    public void Select(DrawingShape shape)
    {
        this.Unselect();

        selectedShape = shape;
        //do stuff
    }

    public void Unselect()
    {
        //do stuff
        selectedShape = null;
    }
}
