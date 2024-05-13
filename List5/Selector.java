import javafx.scene.paint.Color;

public class Selector
{
    private Drawable selectedObject;
    private Canvas canvas;

    public Selector(Canvas canvas)
    {
        selectedObject = null;
        this.canvas = canvas;
    }

    public Drawable getSelected()
    {
        return selectedObject;
    }

    public void select(Drawable object)
    {
        this.unselect();

        object.delete();
        object.draw(canvas);

        object.setStroke(new Color(0.678, 0.847, 0.902, 1.0));
        object.setStrokeWidth(5);
        
        selectedObject = object;
    }

    public void unselect()
    {
        selectedObject.setStroke(selectedObject.getFill());
        selectedObject.setStrokeWidth(0);

        selectedObject = null;
    }
}
