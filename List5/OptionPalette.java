import javafx.scene.layout.GridPane;

public class OptionPalette extends GridPane
{
    private int size;

    public OptionPalette()
    {
        size = 0;
    }

    public void add(OptionButton button)
    {
        add(button, size, 0);
        ++size;
    }
}
