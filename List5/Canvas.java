import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;

public class Canvas extends Pane implements Serializable
{
    private List<Drawable> objects;

    public Canvas()
    {
        objects = new ArrayList<>(0);


    }

    public List<Drawable> getObjects()
    {
        return objects;
    }
}
