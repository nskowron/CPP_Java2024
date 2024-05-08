import javafx.scene.layout.GridPane;

public class OptionPalette extends GridPane
{
    public void AddAll(OptionButton[] buttons)
    {
        for(int i = 0; i < buttons.length; ++i)
        {
            this.add(buttons[i], i, 0);
        }
    }
}
