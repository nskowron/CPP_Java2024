import javafx.scene.control.Button;
import javafx.scene.image.*;

//add indication that a utton is pressed
public class OptionButton extends Button
{
    public OptionButton(String pathToIcon)
    {
        double x = 30;
        double y = 25;

        Image icon = new Image(getClass().getResourceAsStream(pathToIcon));
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(x);
        iconView.setFitHeight(y);

        this.setGraphic(iconView);

        setMinHeight(y);
        setMinWidth(x);
        setMaxHeight(y);
        setMaxWidth(x);

        setHeight(y);
        setWidth(x);
    }
}
