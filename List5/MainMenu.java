import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * @brief Custom menu bar for the application.
 */
public class MainMenu extends MenuBar {

    /**
     * @brief Constructs a new MainMenu with the specified parameters.
     * @param stage The stage associated with the menu bar.
     * @param dataLoader The data loader for loading saved drawings.
     * @param instantiator The object instantiator for creating drawable objects.
     * @param canvas The canvas to draw on.
     */
    public MainMenu(Stage stage, DrawableObjectDataLoader dataLoader, DrawableObjectInstantiator instantiator, Canvas canvas) {

        // Create 'info' menu
        Menu info = new Menu("info");

        // Menu item for displaying author information
        MenuItem author = new MenuItem("author");
        author.setOnAction(event -> {
            try {
                // Open the author's GitHub page in the default browser
                Desktop.getDesktop().browse(new URI("https://github.com/nskowron"));
            } catch(IOException | URISyntaxException e) {
                // If browsing fails, display author information in an alert
                InfoDisplayer.display("Author", "Nel Skowronek");
            }
        });

        // Menu item for displaying usage instructions
        MenuItem usage = new MenuItem("usage");
        usage.setOnAction(event -> {
            InfoDisplayer.display("Usage",
                "Buttons with triangle, rectangle, and circle allow drawing the chosen shape\n" +
                "The 4th button allows selecting shapes.\n" +
                "Click on the canvas to draw / select a shape\n" +
                "Drag to draw / move\n" +
                "Scroll to resize\n" +
                "Scroll + ctrl to rotate\n" +
                "Right-click on a shape to open more editing options");
        });

        // Add items to the 'info' menu
        info.getItems().addAll(author, usage);

        // Create 'file' menu
        Menu file = new Menu("file");

        // Menu item for loading saved drawings
        MenuItem load = new MenuItem("load");
        load.setOnAction(event -> {
            try {
                // Open file chooser dialog to select a file to load
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open file");
                File _file = fileChooser.showOpenDialog(stage);

                if(_file == null) {
                    return; // User canceled the action
                }

                // Load drawable object data from the selected file
                List<DrawableObjectData> datas = dataLoader.load(_file);
                List<Drawable> objects = new ArrayList<>(0);
                for(DrawableObjectData data : datas) {
                    objects.add(instantiator.instantiate(data));
                }

                // Remove existing objects from the canvas and draw the loaded objects
                List<Drawable> _objects = canvas.getObjects();
                while(!_objects.isEmpty()) {
                    _objects.getLast().delete();
                }
                for(Drawable object : objects) {
                    object.draw(canvas);
                }
            } catch(IOException e) {
                ErrorHandler.showError("File error", "Could not read file");
            } catch(ClassNotFoundException | ClassCastException | IllegalArgumentException e) {
                ErrorHandler.showError("Data error", "File corrupted or containing invalid data");
                PaintLogger.logger.log(Level.SEVERE, "corrupted data", e);
            }
        });

        // Menu item for saving current drawings
        MenuItem save = new MenuItem("save");
        save.setOnAction(event -> {
            try {
                // Create drawable object data from the objects on the canvas
                List<DrawableObjectData> datas = new ArrayList<>(0);
                for(Drawable object : canvas.getObjects()) {
                    datas.add(object.getData());
                }

                // Open file chooser dialog to select a file to save
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save as");
                File _file = fileChooser.showSaveDialog(stage);

                if(_file == null) {
                    return; // User canceled the action
                }

                // Save drawable object data to the selected file
                dataLoader.save(datas, _file);
            } catch(IOException e) {
                ErrorHandler.showError("File error", "Could not write to file");
            }
        });

        // Add items to the 'file' menu
        file.getItems().addAll(load, save);

        // Add 'info' and 'file' menus to the menu bar
        getMenus().addAll(info, file);
    }
}
