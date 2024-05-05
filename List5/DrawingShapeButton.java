import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.util.logging.Level;

public class DrawingShapeButton extends OptionButton
{
    private EventHandler<MouseEvent> onMousePressed;
    private ResizeEventHandler onMouseDragged;
    private EventHandler<MouseEvent> onMouseReleased;

    private DrawingShape shapeDrawn;

    public DrawingShapeButton(DrawingShape shape, Canvas canvas, Node selectedColor)
    {
        super();

        onMouseDragged = new ResizeEventHandler()
        {
            private double originalWidth;
            private double originalHeight;

            @Override
            public void handle(MouseEvent me)
            {
                if(me.isPrimaryButtonDown())
                {
                    //drawnshape
                    // DrawingShape shape = canvas.GetDrawingShapes().getLast();
                    // Scale scale = (Scale)shape.GetShape().getTransforms().getLast();

                    // scale.setX(2 * (me.getX() - shape.GetX()) / originalWidth);
                    // scale.setY(2 * (me.getY() - shape.GetY()) / originalHeight);

                    Scale scale = (Scale)shapeDrawn.GetShape().getTransforms().getLast();

                    scale.setX(2 * (me.getX() - shapeDrawn.GetX()) / originalWidth);
                    scale.setY(2 * (me.getY() - shapeDrawn.GetY()) / originalHeight);
                }
            }

            @Override
            public void SetOriginalWidth(double width)
            {
                this.originalWidth = width;
            }

            @Override
            public void SetOriginalHeight(double height)
            {
                this.originalHeight = height;
            }
        };

        onMousePressed = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                DrawingShape copy = shape.Clone();
                onMouseDragged.SetOriginalWidth(copy.GetWidth());
                onMouseDragged.SetOriginalHeight(copy.GetHeight());

                //
                shapeDrawn = copy;

                copy.GetShape().getTransforms().add(new Translate(me.getX(), me.getY()));
                copy.GetShape().getTransforms().add(new Scale(0, 0));
                //setfill

                canvas.Add(copy);
            }
        };

        onMouseReleased = new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent me)
            {
                //drawnshape
                canvas.Select(canvas.GetDrawingShapes().getLast());

                PaintLogger.logger.log(Level.INFO, "New shape drawn");
            }
        };

        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent ae)
            {
                canvas.setOnMousePressed(onMousePressed);
                canvas.setOnMouseDragged(onMouseDragged);
                canvas.setOnMouseReleased(onMouseReleased);
            }
        });
    }
}
