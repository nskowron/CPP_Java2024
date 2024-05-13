import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.logging.Level;

public class SelectButton extends OptionButton
{
    public SelectButton(final String pathToIcon, State state)
    {
        super(pathToIcon);

        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent ae)
            {
                PaintLogger.logger.log(Level.INFO, "Select button clicked");

                state.setMode(Mode.SELECT);
            }
        });
    }
}