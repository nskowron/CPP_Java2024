import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.Map;

public class PaintGUI
{
    public PaintGUI(Stage stage, Map<String, DrawableObjectSupplier> handledObjects)
    {
        BorderPane root = new BorderPane();

        DrawableObjectInstantiator instantiator = new DrawableObjectInstantiator(handledObjects);
        DrawableObjectDataLoader loader = new DrawableObjectDataLoader();

        VBox topPanel = new VBox();
        GridPane editPanel = new GridPane();

        ColorPicker colorPicker = new ColorPicker(Color.RED);

        Canvas canvas = new Canvas();
        Selector selector = new Selector();
        Drawer drawer = new Drawer(instantiator, canvas, colorPicker);

        Controller controller = new Controller(root, canvas, selector, drawer, colorPicker);

        OptionPalette optionPalette = new OptionPalette();
        optionPalette.add(new SelectButton("icons/select.png", controller));
        for(String type : handledObjects.keySet())
        {
            optionPalette.add(new DrawingButton("icons/" + type + ".png", type, drawer, controller, selector));
        }

        editPanel.add(optionPalette, 0, 0);
        editPanel.add(colorPicker, 1, 0);
        GridPane.setHgrow(optionPalette, Priority.ALWAYS);

        MainMenu menu = new MainMenu(stage, loader, instantiator, canvas);

        topPanel.getChildren().add(menu);
        topPanel.getChildren().add(editPanel);

        root.setTop(topPanel);
        root.setCenter(canvas);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Paint");
        stage.show();
    }
}
