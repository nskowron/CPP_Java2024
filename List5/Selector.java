import javafx.scene.input.MouseEvent;

public class Selector implements ShapeManager
{
    private DrawingShape selectedShape;
    private Canvas canvas;

    public Selector(Canvas canvas)
    {
        selectedShape = null;
        this.canvas = canvas;
    }

    @Override
    public DrawingShape GetCurrentShape()
    {
        return selectedShape;
    }

    @Override
    public void Manage(DrawingShape shape)
    {
        this.Unselect();

        if(shape != null)
        {
            selectedShape = shape;
            selectedShape.SetState(DrawingShape.State.MOVING);
            
            canvas.getChildren().remove(selectedShape);
            canvas.getChildren().addLast(selectedShape);
        }
    }

    @Override
    public void ManageNew(MouseEvent me)
    {
        this.Unselect();
    }

    public void Unselect()
    {
        //do stuff
        selectedShape = null;
    }
}
