import javafx.scene.paint.Color;

import java.util.logging.Level;

public class Selector
{
    private Drawable selectedObject;

    public Selector()
    {
        selectedObject = null;
    }

    public Drawable getSelected()
    {
        return selectedObject;
    }

    public void select(Drawable object)
    {
        this.unselect();

        object.redraw();

        object.setStroke(new Color(0.259, 0.576, 0.961, 1.0));
        object.setStrokeWidth(3);
        
        PaintLogger.logger.log(Level.INFO, "Selecting");
        selectedObject = object;
    }

    public void unselect()
    {
        PaintLogger.logger.log(Level.INFO, "Unselecting");
        if(selectedObject != null)
        {
            selectedObject.setStroke(selectedObject.getFill());
            selectedObject.setStrokeWidth(0);

            selectedObject = null;
        }
    }
}
