import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class PaintGUI
{
    public PaintGUI(Stage stage)
    {
        BorderPane root = new BorderPane();

        InputHandler inputHandler = new InputHandler();

        Canvas canvas = new Canvas(inputHandler);

        Drawer drawer = new Drawer(canvas, inputHandler);
        Selector selector = new Selector(canvas);
        
        canvas.GetShapeManagers().put(Canvas.Mode.DRAW, drawer);
        canvas.GetShapeManagers().put(Canvas.Mode.SELECT, selector);
        canvas.GetShapeManagers().put(Canvas.Mode.IDLE, new ShapeManager()
        {
            @Override
            public DrawingShape GetCurrentShape()
            {
                return null;
            }

            @Override
            public void Manage(DrawingShape shape) {}

            @Override
            public void ManageNew(MouseEvent me) {}
        });

        DrawingShapeButton ellipse = new DrawingShapeButton("icons/ellipse.png", new DrawingCircle(100), drawer, canvas);
        DrawingShapeButton rectangle = new DrawingShapeButton("icons/rectangle.png", new DrawingSquare(100), drawer, canvas);
        DrawingShapeButton triangle = new DrawingShapeButton("icons/triangle.png", new DrawingTriangle(100), drawer, canvas);
        
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
