import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.logging.Level;

public class DrawingShapeButton extends OptionButton
{
    public DrawingShapeButton(final String pathToIcon, final DrawingShape shape, Drawer drawer, Canvas canvas)
    {
        super(pathToIcon);
        
        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent ae)
            {
                PaintLogger.logger.log(Level.INFO, "Drawing button clicked");

                canvas.SetMode(Canvas.Mode.DRAW);
                drawer.SetDrawingTemplate(shape);
            }
        });
    }
}
