import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class PaintGUI
{
    public PaintGUI(Stage stage)
    {
        BorderPane root = new BorderPane();

        Canvas canvas = new Canvas();
        canvas.SetInputHandlers(new InputHandler());

        DrawingShapeButton ellipse = new DrawingShapeButton("icons/ellipse.png", new DrawingCircle(100), canvas);
        DrawingShapeButton rectangle = new DrawingShapeButton("icons/rectangle.png", new DrawingSquare(100), canvas);
        DrawingShapeButton triangle = new DrawingShapeButton("icons/triangle.png", new DrawingTriangle(100), canvas);
        
        SelectButton select = new SelectButton("icons/select.png", canvas);

        OptionButton[] optionButtons = {select, ellipse, rectangle, triangle};
        OptionPalette optionPalette = new OptionPalette();
        optionPalette.AddAll(optionButtons);

        root.setTop(optionPalette);
        root.setCenter(canvas);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Paint");
        stage.show();
    }
}
