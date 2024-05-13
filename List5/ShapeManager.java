import javafx.scene.input.MouseEvent;

public interface ShapeManager
{
    public DrawingShape GetCurrentShape();
    public void Manage(DrawingShape shape);
    public void ManageNew(MouseEvent me);
}
