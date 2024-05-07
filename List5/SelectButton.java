import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.transform.Translate;

import java.util.logging.Level;

public class SelectButton extends OptionButton
{
    // private EventHandler<MouseEvent> onMousePressed;
    // private MoveEventHandler onMouseDragged;

    //private Canvas canvas;

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

        //this.canvas = canvas;

        // onMousePressed = new EventHandler<MouseEvent>()
        // {
        //     @Override
        //     public void handle(MouseEvent me)
        //     {
        //         PaintLogger.logger.log(Level.INFO, "Canvas pressed");

        //         canvas.Unselect();
        //     }
        // };

        // //implement initial offset?
        // onMouseDragged = new MoveEventHandler()
        // {
        //     private double originalX;
        //     private double originalY;

        //     @Override
        //     public void handle(MouseEvent me)
        //     {
        //         if(me.isPrimaryButtonDown() && canvas.selectedShape != null)
        //         {
        //             Translate translate = (Translate)canvas.selectedShape.GetShape().getTransforms().getFirst();

        //             //houston we have a math problem
        //             translate.setX(me.getX() - originalX);
        //             translate.setY(me.getY() - originalY);
        //         }
        //     }

        //     @Override
        //     public void SetOriginalX(double x)
        //     {
        //         this.originalX = x;
        //     }

        //     @Override
        //     public void SetOriginalY(double y)
        //     {
        //         this.originalY = y;
        //     }
        // };

        // this.setOnAction(new OptionButton.ActionEventHandler()
        // {
        //     @Override
        //     public void handle(ActionEvent ae)
        //     {
        //         super.handle(ae);

        //         for(DrawingShape shape : canvas.GetDrawingShapes())
        //         {
        //             shape.GetShape().setOnMousePressed(new EventHandler<MouseEvent>()
        //             {
        //                 @Override
        //                 public void handle(MouseEvent me)
        //                 {
        //                     canvas.setOnMousePressed(null);

        //                     onMouseDragged.SetOriginalX(shape.GetX());
        //                     onMouseDragged.SetOriginalY(shape.GetY());

        //                     shape.GetShape().getTransforms().addFirst(new Translate(0, 0));

        //                     canvas.Select(shape);
        //                 }
        //             });

        //             shape.GetShape().setOnMouseReleased(new EventHandler<MouseEvent>()
        //             {
        //                 @Override
        //                 public void handle(MouseEvent me)
        //                 {
        //                     Translate translate = (Translate)shape.GetShape().getTransforms().getFirst();
        //                     if(translate.getX() == 0 && translate.getY() == 0)
        //                     {
        //                         //could think of merging all transforms in final to have only 3
        //                         //DrawingShape: SetScale(d, d), AddScale(void) ?
        //                         //and set transforms as private then
        //                         shape.GetShape().getTransforms().removeFirst();
        //                     }

        //                     canvas.setOnMousePressed(onMousePressed);
        //                 }
        //             });
        //         }

        //         canvas.setOnMousePressed(onMousePressed);
        //         canvas.setOnMouseDragged(onMouseDragged);
        //     }
        // });
    }

    // @Override
    // public void EndAction()
    // {
    //     for(DrawingShape shape : canvas.GetDrawingShapes())
    //     {
    //         shape.GetShape().setOnMousePressed(null);
    //         shape.GetShape().setOnMouseReleased(null);
    //     }

    //     canvas.setOnMousePressed(null);
    //     canvas.setOnMouseDragged(null);
    // }
}
