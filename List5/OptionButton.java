import javafx.scene.control.Button;
import javafx.scene.image.*;

public abstract class OptionButton extends Button
{
    public OptionButton(final String pathToIcon)
    {
        double x = 30;
        double y = 25;
        
        try
        {
            Image icon = new Image(getClass().getResourceAsStream(pathToIcon));
            ImageView iconView = new ImageView(icon);
            iconView.setFitWidth(x);
            iconView.setFitHeight(y);

            this.setGraphic(iconView);
        }
        catch(NullPointerException | IllegalArgumentException e)
        {
            this.setText(pathToIcon);
            ErrorHandler.showError("Icon not found", "Icon " + pathToIcon + " required by OptionButton has not been found");
        }

        setMinHeight(y);
        setMinWidth(x);
        setMaxHeight(y);
        setMaxWidth(x);

        setHeight(y);
        setWidth(x);
    }
}
