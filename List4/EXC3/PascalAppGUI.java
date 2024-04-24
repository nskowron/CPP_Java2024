import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import java.util.logging.Level;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;

public class PascalAppGUI
{
    public PascalAppGUI(Stage stage)
    {
        ComboBox<Integer> box = new ComboBox<Integer>();
        box.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33);
        box.setPromptText("Choose number of row");

        TextArea textArea = new TextArea();
        textArea.setPromptText("Choose elements");

        Label label = new Label();

        Button button = new ButtonPascalCPP("Render", box, textArea, label);

        DropdownPane dropdown = new DropdownTextPane(box, textArea, button);

        ScrollPane scroll = new ScrollPane(label);

        VBox root = new VBox();
        root.getChildren().add(dropdown);
        root.getChildren().add(scroll);

        VBox.setVgrow(scroll, Priority.ALWAYS);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(500);
        stage.setWidth(600);
        stage.setHeight(500);
        stage.setTitle("Pascal's Triangle's Row");
        stage.show();
        AppLogger.logger.log(Level.INFO, "Scene has been inited");
    }
}
