import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class PopupEditMenu extends VBox
{
    public PopupEditMenu(double x, double y, Button buttons[])
    {
        setLayoutX(x);
        setLayoutY(y);

        for(Button button : buttons)
        {
            getChildren().add(button);
        }
    }
}
