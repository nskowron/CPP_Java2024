import java.io.Serializable;
// import java.util.ArrayList;
// import java.util.List;

import java.util.logging.Level;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Canvas extends Pane implements Serializable
{
    //private List<Drawable> objects;
    private Drawable primarilyClicked;

    public Canvas(Selector selector)
    {
        //objects = new ArrayList<>(0);

        primarilyClicked = null;

        setMinSize(400, 300);

        setOnMouseDragged(me ->
        {
            if(me.isPrimaryButtonDown() && selector.getSelected() != null)
            {
                selector.getSelected().setTranslateX(me.getX());
                selector.getSelected().setTranslateY(me.getY());
            }
        });

        setOnMousePressed(me ->
        {
            if(primarilyClicked != null)
            {
                selector.select(primarilyClicked);
            }
            else
            {
                selector.unselect();
            }
        });

        setOnScroll(se ->
        {
            Drawable selected = selector.getSelected();
            if(selected != null)
            {
                if(se.isControlDown())
                {
                    selected.setRotate(selected.getRotate() + (Math.PI * 0.01 * se.getDeltaY()));
                }
                else
                {
                    selected.setWidth(selected.getWidth() * (1 + 0.01 * se.getDeltaY()));
                    selected.setHeight(selected.getHeight() * (1 + 0.01 * se.getDeltaY()));
                }
            }
        });
    }

    public void add(Drawable object, Node objectNode)
    {
        objectNode.setOnMousePressed(me ->
        {
            if(primarilyClicked == null)
            {
                primarilyClicked = object;
            }
        });

        objectNode.setOnMouseReleased(me ->
        {
            primarilyClicked = null;
        });

        getChildren().add(objectNode);
        //add list of drawables
    }

    public void remove(Drawable object, Node objectNode)
    {
        objectNode.setOnMousePressed(null);
        objectNode.setOnMouseReleased(null);

        getChildren().remove(objectNode);
        //itd
    }


    // public List<Drawable> getObjects()
    // {
    //     return objects;
    // }
}
