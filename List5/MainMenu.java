import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class MainMenu extends MenuBar
{
    public MainMenu(Stage stage, DrawableObjectDataLoader dataLoader, DrawableObjectInstantiator instantiator, Canvas canvas)
    {
        Menu info = new Menu("info");

        MenuItem author = new MenuItem("author");
        author.setOnAction(event ->
        {
            try
            {
                Desktop.getDesktop().browse(new URI("https://github.com/nskowron"));
            }
            catch(IOException | URISyntaxException e)
            {
                InfoDisplayer.display("Author", "Nel Skowronek");
            }
        });

        MenuItem usage = new MenuItem("usage");
        usage.setOnAction(event ->
        {
            InfoDisplayer.display("Usage", "TODO");
        });

        info.getItems().addAll(author, usage);


        Menu file = new Menu("file");

        MenuItem load = new MenuItem("load");
        load.setOnAction(event ->
        {
            try
            {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open file");
                File _file = fileChooser.showOpenDialog(stage);

                if(_file == null)
                {
                    return;
                }

                List<DrawableObjectData> datas = dataLoader.load(_file);
                List<Drawable> objects = new ArrayList<>(0);
                for(DrawableObjectData data : datas)
                {
                    objects.add(instantiator.instantiate(data));
                }

                List<Drawable> _objects = canvas.getObjects();
                while(!_objects.isEmpty())
                {
                    _objects.getLast().delete();
                }
                for(Drawable object : objects)
                {
                    object.draw(canvas);
                }
            }
            catch(IOException e)
            {
                ErrorHandler.showError("File error", "Could not read file");
            }
            catch(ClassNotFoundException | ClassCastException | IllegalArgumentException e)
            {
                ErrorHandler.showError("Data error", "File corrupted or containing invalid data");
                PaintLogger.logger.log(Level.SEVERE, "corrupted data", e);
            }
        });

        MenuItem save = new MenuItem("save");
        save.setOnAction(event ->
        {
            try
            {
                List<DrawableObjectData> datas = new ArrayList<>(0);
                for(Drawable object : canvas.getObjects())
                {
                    datas.add(object.getData());
                }

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save as");
                File _file = fileChooser.showSaveDialog(stage);

                if(_file == null)
                {
                    return;
                }

                dataLoader.save(datas, _file);
            }
            catch(IOException e)
            {
                ErrorHandler.showError("File error", "Could not write to file");
            }
        });

        file.getItems().addAll(load, save);


        getMenus().addAll(info, file);
    }
}
