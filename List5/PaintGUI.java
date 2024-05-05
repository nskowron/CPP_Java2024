import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.*;

public class PaintGUI
{
    public PaintGUI(Stage stage)
    {
        VBox root = new VBox();
        
        Canvas canvas = new Canvas();
        DrawingShapeButton button = new DrawingShapeButton(new DrawingEllipse(0, 0, 100), canvas, null);
        Pane pane = new Pane(button);
        root.getChildren().add(pane);
        root.getChildren().add(canvas);

        VBox.setVgrow(canvas, Priority.ALWAYS);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Paint");
        stage.show();
    }
}
