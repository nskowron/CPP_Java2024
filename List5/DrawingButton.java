import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.logging.Level;

public class DrawingButton extends OptionButton
{
    public DrawingButton(final String pathToIcon, final Drawable object, Drawer drawer, State state)
    {
        super(pathToIcon);
        
        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent ae)
            {
                PaintLogger.logger.log(Level.INFO, "Drawing button clicked");

                drawer.setTemplate(object);
                state.setMode(Mode.DRAW);
            }
        });
    }
}