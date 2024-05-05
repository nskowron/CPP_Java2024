import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.*;

public class PaintGUI
{
    public PaintGUI(Stage stage)
    {
        VBox root = new VBox();
        
        Canvas canvas = new Canvas();
        DrawingShapeButton ellipse = new DrawingShapeButton("icons/ellipse.png", new DrawingEllipse(0, 0, 100), canvas, null);
        DrawingShapeButton rectangle = new DrawingShapeButton("icons/rectangle.png", new DrawingRectangle(0, 0, 100), canvas, null);
        DrawingShapeButton triangle = new DrawingShapeButton("icons/triangle.png", new DrawingTriangle(0, 0, 100), canvas, null);
        GridPane pane = new GridPane();
        pane.add(ellipse, 0, 0);
        pane.add(rectangle, 1, 0);
        pane.add(triangle, 2, 0);

        root.getChildren().add(pane);
        root.getChildren().add(canvas);

        VBox.setVgrow(canvas, Priority.ALWAYS);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Paint");
        stage.show();
    }
}
