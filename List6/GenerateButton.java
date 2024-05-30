import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

public class GenerateButton extends Button
{
    public GenerateButton(ScrollPane scroll, TextField width, TextField height, TextField sleepTime, TextField probability)
    {
        super("Generate");

        setOnAction(ae ->
        {
            try
            {
                scroll.setContent(new CellGrid(Integer.parseInt(width.getText()), Integer.parseInt(height.getText()), Long.parseLong(sleepTime.getText()), Double.parseDouble(probability.getText())));
            }
            catch(NumberFormatException e)
            {
                ErrorHandler.showError("Invalid Data", "Data should be of type:\nwidth[int], height[int], sleepTime[long], probability[double].");
            }
            catch(IllegalArgumentException e)
            {
                ErrorHandler.showError("Invalid Data", e.getMessage());
            }
        });
    }
}
