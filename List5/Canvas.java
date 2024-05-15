import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Canvas extends Pane implements Serializable
{
    private List<Drawable> objects;
    private Controller controller;

    public Canvas()
    {
        objects = new ArrayList<>(0);

        setMinSize(400, 300);
    }

    public void addController(Controller controller)
    {
        this.controller = controller;
    }

    public void add(Drawable object)
    {
        objects.add(object);
        controller.addControllable(object);

        if(object instanceof Node)
        {
            getChildren().add((Node)object);
        }
    }

    public void remove(Drawable object)
    {
        if(object instanceof Node)
        {
            getChildren().remove((Node)object);
        }

        controller.removeControllable(object);
        objects.remove(object);
    }


    public List<Drawable> getObjects()
    {
        return objects;
    }
}
