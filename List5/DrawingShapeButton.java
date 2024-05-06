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
    private Canvas canvas;

    public DrawingShapeButton(String pathToIcon, OptionPalette optionPalette, DrawingShape shape, Canvas canvas, Node selectedColor)
    {
        super(pathToIcon, optionPalette);

        this.canvas = canvas;

        onMouseDragged = new ResizeEventHandler()
        {
            private double originalWidth;
            private double originalHeight;

            @Override
            public void handle(MouseEvent me)
            {
                if(me.isPrimaryButtonDown())
                {
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
                canvas.Select(shapeDrawn);

                PaintLogger.logger.log(Level.INFO, "New shape drawn");
            }
        };

        setOnAction(new OptionButton.ActionEventHandler()
        {
            @Override
            public void handle(ActionEvent ae)
            {
                super.handle(ae);

                canvas.setOnMousePressed(onMousePressed);
                canvas.setOnMouseDragged(onMouseDragged);
                canvas.setOnMouseReleased(onMouseReleased);
            }
        });
    }

    @Override
    public void EndAction()
    {
        canvas.setOnMousePressed(null);
        canvas.setOnMouseDragged(null);
        canvas.setOnMouseReleased(null);
    }
}
