import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.*;

public class PaintGUI
{
    public PaintGUI(Stage stage)
    {
        VBox root = new VBox();
        
        OptionPalette optionPalette = new OptionPalette();
        Canvas canvas = new Canvas();

        DrawingShapeButton ellipse = new DrawingShapeButton("icons/ellipse.png", optionPalette, new DrawingEllipse(0, 0, 100), canvas, null);
        DrawingShapeButton rectangle = new DrawingShapeButton("icons/rectangle.png", optionPalette, new DrawingRectangle(0, 0, 100), canvas, null);
        DrawingShapeButton triangle = new DrawingShapeButton("icons/triangle.png", optionPalette, new DrawingTriangle(0, 0, 100), canvas, null);
        
        SelectButton select = new SelectButton("icons/select.png", optionPalette, canvas);

        OptionButton[] optionButtons = {select, ellipse, rectangle, triangle};
        optionPalette.AddAll(optionButtons);

        root.getChildren().add(optionPalette);
        root.getChildren().add(canvas);

        VBox.setVgrow(canvas, Priority.ALWAYS);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Paint");
        stage.show();
    }
}
