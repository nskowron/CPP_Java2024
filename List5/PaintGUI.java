import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.*;
import javafx.scene.Node;

public class PaintGUI
{
    public PaintGUI(Stage stage)
    {
        BorderPane root = new BorderPane();

        //Shape test = new Circle();
        //test

        Canvas canvas = new Canvas();

        Selector selector = new Selector(canvas);
        Drawer drawer = new Drawer(canvas);

        Mode.setSelector(selector);
        Mode.setDrawer(drawer);

        State state = new State(canvas);
        

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
