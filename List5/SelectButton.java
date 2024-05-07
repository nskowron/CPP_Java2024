import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.logging.Level;

public class SelectButton extends OptionButton
{
    public SelectButton(String pathToIcon, Canvas canvas)
    {
        super(pathToIcon);

        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent ae)
            {
                canvas.mode = Canvas.Mode.SELECT;

                PaintLogger.logger.log(Level.INFO, "Select button clicked");
            }
        });
    }
}
