import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.logging.Level;

public class DrawingButton extends OptionButton
{
    public DrawingButton(final String pathToIcon, final String type, Drawer drawer, Controller controller, Selector selector)
    {
        super(pathToIcon);
        
        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent ae)
            {
                PaintLogger.logger.log(Level.INFO, "Drawing button clicked");

                selector.unselect();
                drawer.setType(type);
                controller.setMode(Mode.DRAW);
            }
        });
    }
}