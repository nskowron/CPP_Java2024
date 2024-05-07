import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.util.logging.Level;

public class DrawingShapeButton extends OptionButton
{
    // private EventHandler<MouseEvent> onMousePressed;
    // private ResizeEventHandler onMouseDragged;
    // private EventHandler<MouseEvent> onMouseReleased;

    // private DrawingShape shapeDrawn;
    // private Canvas canvas;

    public DrawingShapeButton(String pathToIcon, final DrawingShape shape, Canvas canvas, Node selectedColor)
    {
        super(pathToIcon);
        
        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent ae)
            {
                canvas.mode = Canvas.Mode.DRAW;
                canvas.drawingTemplate = shape;
            }
        });
    }
}
