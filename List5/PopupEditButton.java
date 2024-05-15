import javafx.scene.control.Button;

public class PopupEditButton extends Button
{
    public PopupEditButton(String name)
    {
        super(name);

        double x = 80;
        double y = 25;

        setMinHeight(y);
        setMinWidth(x);
        setMaxHeight(y);
        setMaxWidth(x);

        setHeight(y);
        setWidth(x);
    }
}
