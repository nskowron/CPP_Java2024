import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;

public class ColorChooser extends Button
{
    private ColorPicker colorPicker;

    public ColorChooser(Pane root)
    {
        double x = 25;
        double y = 25;

        setMinHeight(y);
        setMinWidth(x);
        setMaxHeight(y);
        setMaxWidth(x);

        setHeight(y);
        setWidth(x);

        colorPicker = new ColorPicker(Color.BLACK);
        styleProperty().bindBidirectional(colorPicker.valueProperty(), new StringConverter<Color>()
        {
            @Override
            public String toString(Color color) {
                return String.format("#%02X%02X%02X",
                        (int) (color.getRed() * 255),
                        (int) (color.getGreen() * 255),
                        (int) (color.getBlue() * 255));
            }

            @Override
            public Color fromString(String string) {
                return Color.web(string);
            }
        });

        setOnAction(event ->
        {
            root.getChildren().add(colorPicker);
        });
    }

    public Color getChosen()
    {
        return colorPicker.getValue();
    }
}
