import javafx.scene.input.MouseEvent;

public class Drawer implements ShapeManager
{
    private DrawingShape drawingTemplate;
    private DrawingShape newShape;
    private Canvas canvas;
    private InputHandler inputHandler;

    public Drawer(Canvas canvas, InputHandler inputHandler)
    {
        drawingTemplate = null;
        newShape = null;
        this.canvas = canvas;
        this.inputHandler = inputHandler;
    }

    @Override
    public DrawingShape GetCurrentShape()
    {
        return newShape;
    }

    @Override
    public void Manage(DrawingShape shape)
    {

    }

    @Override
    public void ManageNew(MouseEvent me)
    {
        newShape = drawingTemplate.Clone();
        newShape.GetInputHandlers().putAll(inputHandler.GetDrawingShapeInputHandlers(newShape));
        newShape.SetInputHandling(inputHandler, canvas);

        newShape.Translate(me.getX(), me.getY());
        newShape.Resize(0, 0);
        newShape.SetState(DrawingShape.State.RESIZING);
        
        canvas.getChildren().addLast(newShape);
    }

    public void SetDrawingTemplate(final DrawingShape template)
    {
        drawingTemplate = template;
    }

    public void StartDrawing()
    {
        newShape = drawingTemplate.Clone();
        newShape.SetState(DrawingShape.State.RESIZING);
    }

    public void StopDrawing()
    {
        newShape.SetState(DrawingShape.State.IDLE);
        newShape = null;
    }
}
