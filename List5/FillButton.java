import javafx.scene.control.ColorPicker;

public class FillButton extends PopupEditButton
{
    public FillButton(Drawable object, ColorPicker colorPicker)
    {
        super("fill");

        setOnAction(event ->
        {
            object.setFill(colorPicker.getValue());
        });
    }
}
