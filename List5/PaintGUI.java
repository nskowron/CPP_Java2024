import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.util.Map;

public class PaintGUI
{
    public PaintGUI(Stage stage, Map<String, DrawableObjectSupplier> handledObjects)
    {
        BorderPane root = new BorderPane();

        DrawableObjectInstantiator instantiator = new DrawableObjectInstantiator(handledObjects);

        Selector selector = new Selector();
        Canvas canvas = new Canvas(selector);
        Drawer drawer = new Drawer(instantiator, canvas);

        Controller controller = new Controller(canvas, drawer);
        
        OptionPalette optionPalette = new OptionPalette();
        optionPalette.add(new SelectButton("icons/select.png", controller));
        for(String type : handledObjects.keySet())
        {
            optionPalette.add(new DrawingButton("icons/" + type + ".png", type, drawer, controller, selector));
        }

        root.setTop(optionPalette);
        root.setCenter(canvas);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Paint");
        stage.show();
    }
}
